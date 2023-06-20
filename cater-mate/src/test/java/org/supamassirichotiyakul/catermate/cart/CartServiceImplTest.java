package org.supamassirichotiyakul.catermate.cart;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.supamassirichotiyakul.catermate.cart.Cart;
import org.supamassirichotiyakul.catermate.cart.CartService;
import org.supamassirichotiyakul.catermate.menuitem.MenuItem;
import org.supamassirichotiyakul.catermate.menuitem.MenuItemService;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CartServiceImplTest {
    @Autowired
    private CartService cartService;

    @Autowired
    private MenuItemService menuItemService;

    @DisplayName("Parameterized test using JUnit 5 assert")
    @ParameterizedTest(name = "add {1} menuItem with id {0} to cart")
    @CsvSource({
            " 1, 1",
            " 2, 1",
            "10, 4"
    })
    @Transactional
    void getAllCartsShouldReturnCorrectResultList(int menuItemId, int quantity) {
        // act and assert
        List<Cart> allCarts = cartService.getAllCarts();
        int beforeAddingMoreCarts = allCarts.size();

        Assertions.assertThat(beforeAddingMoreCarts).isEqualTo(0);

        Cart cart = new Cart();

        cart.setCurrentItemQuantity(quantity);

        cartService.addMenuItemToCartById(cart, menuItemId);
        MenuItem menuItem = menuItemService.getMenuItemById(menuItemId);

        double subTotal = quantity * menuItem.getPrice();

        Assertions.assertThat(cart.getSubTotal()).isEqualTo(subTotal);
        Assertions.assertThat(cart.getTax()).isEqualTo(subTotal * 0.08);
        Assertions.assertThat(cart.getTotal()).isEqualTo(subTotal + subTotal * 0.08);

        cartService.saveCart(cart);

        allCarts = cartService.getAllCarts();
        int afterAddingMoreCarts = allCarts.size();

        Assertions.assertThat(afterAddingMoreCarts).isEqualTo(beforeAddingMoreCarts + 1);
        Assertions.assertThat(allCarts.contains(cart)).isTrue();
    }
}
