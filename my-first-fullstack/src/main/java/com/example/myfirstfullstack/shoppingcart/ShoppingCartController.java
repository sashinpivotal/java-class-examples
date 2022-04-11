package com.example.myfirstfullstack.shoppingcart;

import com.example.myfirstfullstack.models.Employee;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ShoppingCartController {

    private ShoppingCart shoppingCart;

    public ShoppingCartController(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @GetMapping("/items")
    public String getItems(Model model) {
        List<Item> items = shoppingCart.getItems();
        model.addAttribute("items", items);
        return "index_items";
    }

    @GetMapping("/itemForm")
    public String showItemForm(Model model) {
        // create model attribute to bind form data
        Item item = new Item();
        model.addAttribute("item", item);
        return "new_item";
    }

    @PostMapping("/items")
    public String saveItem(@ModelAttribute("item") Item item) {
        shoppingCart.addItem(item);
        return "redirect:/items";
    }

}
