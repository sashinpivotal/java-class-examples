package org.supamassirichotiyakul.catermate.menuitem;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

// Make this a manually created bean to satisfy the capstone requirement
//@Service
public class MenuItemServiceImpl implements MenuItemService {
    private MenuItemRepository menuItemRepository;

    @Autowired
    public MenuItemServiceImpl(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    @Override
    public void saveMenuItem(MenuItem menuItem) {
        menuItemRepository.save(menuItem);
    }

    @Override
    public MenuItem getMenuItemById(long id) {
        MenuItem menuItem = menuItemRepository.getById(id);
        if(menuItem == null) {
            throw new MenuItemNotFoundException();
        }
        return menuItem;
    }

    @Override
    public void deleteMenuItemById(long id) {
        menuItemRepository.deleteById(id);
    }
}
