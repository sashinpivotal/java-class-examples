package org.supamassirichotiyakul.catermate.menuitem;

import org.supamassirichotiyakul.catermate.menuitem.MenuItem;

import java.util.List;

public interface MenuItemService {
    List<MenuItem> getAllMenuItems();
    void saveMenuItem(MenuItem menuItem);
    MenuItem getMenuItemById(long id);
    void deleteMenuItemById(long id);
}
