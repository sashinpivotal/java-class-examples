package org.supamassirichotiyakul.catermate.cartitem;

import org.supamassirichotiyakul.catermate.menuitem.MenuItem;

import java.util.List;

public interface CartItemService {
    List<CartItem> getAllCartItems();
    void saveCartItem(CartItem cartItem);
    CartItem getCartItemById(long id);
    void deleteCartItemById(long id);
    CartItem getNewCartItemFromMenuItem(MenuItem menuItem);
}
