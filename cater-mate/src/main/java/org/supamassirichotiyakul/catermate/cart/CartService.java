package org.supamassirichotiyakul.catermate.cart;

import org.supamassirichotiyakul.catermate.cart.Cart;

import java.util.List;

public interface CartService {
    List<Cart> getAllCarts();
    void saveCart(Cart cart);
    Cart getCartById(long id);
    void deleteCartById(long id);
    void addMenuItemToCartById(Cart cart, long menuItemId);
}
