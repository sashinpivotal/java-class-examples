package org.supamassirichotiyakul.catermate.menuitem;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.supamassirichotiyakul.catermate.menuitem.MenuItem;
import org.supamassirichotiyakul.catermate.menuitem.MenuItemService;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MenuItemServiceImplTest {
    @Autowired
    private MenuItemService menuItemService;
    
    @Test
    @Transactional
    void getAllMenuItemsShouldReturnCorrectResultList() {
        // act and assert
        List<MenuItem> allMenuItems = menuItemService.getAllMenuItems();
        int beforeAddingMoreMenuItems = allMenuItems.size();

        Assertions.assertThat(beforeAddingMoreMenuItems).isEqualTo(10);

        MenuItem menuItem1 = new MenuItem();
        menuItem1.setName("Horchata");
        menuItem1.setPrice(3.5);
        menuItemService.saveMenuItem(menuItem1);

        allMenuItems = menuItemService.getAllMenuItems();
        int afterAddingMoreMenuItems = allMenuItems.size();

        Assertions.assertThat(afterAddingMoreMenuItems).isEqualTo(beforeAddingMoreMenuItems + 1);
        Assertions.assertThat(allMenuItems.contains(menuItem1)).isTrue();
    }

    @Test
    @Transactional
    void saveMenuItemShouldSaveToTable() {
        List<MenuItem> allMenuItems = menuItemService.getAllMenuItems();
        int beforeAddingMoreMenuItems = allMenuItems.size();

        MenuItem menuItem1 = new MenuItem();
        menuItem1.setName("Horchata");
        menuItem1.setPrice(3.5);
        menuItemService.saveMenuItem(menuItem1);

        allMenuItems = menuItemService.getAllMenuItems();
        int afterAddingMoreMenuItems = allMenuItems.size();

        Assertions.assertThat(afterAddingMoreMenuItems).isEqualTo(beforeAddingMoreMenuItems + 1);
        Assertions.assertThat(allMenuItems.contains(menuItem1)).isTrue();
    }

    @Test
    @Transactional
    void getMenuItemByIdShouldReturnCorrectMenuItem() {
        // act and assert
        MenuItem expected = new MenuItem();
        expected.setName("Horchata");
        expected.setPrice(3.5);
        menuItemService.saveMenuItem(expected);

        MenuItem actual = menuItemService.getMenuItemById(expected.getId());

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @Transactional
    void deleteMenuItemByIdShouldDeleteFromTable() {
        // act and assert
        MenuItem expected = new MenuItem();
        expected.setName("Horchata");
        expected.setPrice(3.5);
        menuItemService.saveMenuItem(expected);

        List<MenuItem> allMenuItems = menuItemService.getAllMenuItems();
        int beforeDeletingMenuItem = allMenuItems.size();

        menuItemService.deleteMenuItemById(expected.getId());

        Assertions.assertThat(menuItemService.getAllMenuItems().size()).isEqualTo(beforeDeletingMenuItem-1);
    }
}
