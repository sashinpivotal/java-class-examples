package org.supamassirichotiyakul.catermate.cartitem;

import org.supamassirichotiyakul.catermate.menuitem.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {
    private CartItemRepository cartItemRepository;

    @Autowired
    public CartItemServiceImpl(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    @Override
    public void saveCartItem(CartItem cartItem) {
        cartItemRepository.save(cartItem);
    }

    @Override
    public CartItem getCartItemById(long id) {
        CartItem cartItem = cartItemRepository.getById(id);
        if(cartItem == null) {
            throw new CartItemNotFoundException();
        }
        return cartItem;
    }

    @Override
    public void deleteCartItemById(long id) {
        cartItemRepository.deleteById(id);
    }

    /**
     * Returns a CartItem object that has the following information copied from the input MenuItem object:
     *      id, name, price
     *
     * @param menuItem a MenuItem object whose information to be copied from
     * @return         a CartItem object containing menuItem's id, name, and price.
     */
    @Override
    public CartItem getNewCartItemFromMenuItem(MenuItem menuItem) {
        CartItem cartItem = new CartItem();
        cartItem.setMenuItemId(menuItem.getId());
        cartItem.setName(menuItem.getName());
        cartItem.setPrice(menuItem.getPrice());

        return cartItem;
    }
}
