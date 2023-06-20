package org.supamassirichotiyakul.catermate.cart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.supamassirichotiyakul.catermate.cartitem.CartItem;
import org.supamassirichotiyakul.catermate.menuitem.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.supamassirichotiyakul.catermate.cartitem.CartItemService;
import org.supamassirichotiyakul.catermate.menuitem.MenuItemService;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    private CartRepository cartRepository;
    private MenuItemService menuItemService;
    private CartItemService cartItemService;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository, MenuItemService menuItemService, CartItemService cartItemService) {
        this.cartRepository = cartRepository;
        this.menuItemService = menuItemService;
        this.cartItemService = cartItemService;
    }

    @Override
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public void saveCart(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public Cart getCartById(long id) {
        Cart cart = cartRepository.getById(id);
        if(cart == null) {
            throw new CartNotFoundException();
        }
        return cart;
    }

    @Override
    public void deleteCartById(long id) {
        cartRepository.deleteById(id);
    }

    @Override
    public void addMenuItemToCartById(Cart cart, long menuItemId) {
        MenuItem menuItem = menuItemService.getMenuItemById(menuItemId);

        CartItem cartItem = cartItemService.getNewCartItemFromMenuItem(menuItem);

        cart.addCartItemToCart(cartItem);

        cartItemService.saveCartItem(cartItem);

        Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);
        logger.info("CartServiceImpl: Menu item with id " + menuItemId + " has been added to cart with id " + cart.getId());
    }
}
