package org.supamassirichotiyakul.catermate.menuitem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MenuItemController {
    private MenuItemService menuItemService;

    @Autowired
    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @GetMapping("/menu")
    public String getAll(Model model) {
        model.addAttribute("listMenuItems", menuItemService.getAllMenuItems());
        return "menu";
    }

    @GetMapping("/showNewMenuItemForm")
    public String showNewForm(Model model) {
        // create model attribute to bind form data
        MenuItem menuItem = new MenuItem();
        model.addAttribute("menuItem", menuItem);
        return "new_menu_item";
    }

    @PostMapping("/saveMenuItem")
    public String save(@ModelAttribute("menuItem") MenuItem menuItem) {
        // save menuItem to database
        menuItemService.saveMenuItem(menuItem);

        Logger logger = LoggerFactory.getLogger(MenuItemController.class);

        logger.info("Menu item " + menuItem.getName()
                + " has been saved to the menu");

        return "redirect:/menu";
    }

    @GetMapping("/showMenuItemFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        // get menuItem from the service
        MenuItem menuItem = menuItemService.getMenuItemById(id);

        // set menuItem as a model attribute to pre-populate the form
        model.addAttribute("menuItem", menuItem);
        return "update_menu_item";
    }

    @GetMapping("/deleteMenuItem/{id}")
    public String delete(@PathVariable(value = "id") long id) {
        // call delete menuItem method
        this.menuItemService.deleteMenuItemById(id);
        return "redirect:/menu";
    }
}
