package org.supamassirichotiyakul.catermate.cartitem;

import org.springframework.stereotype.Controller;

// TODO Maybe this CartItemController is not needed?
@Controller
public class CartItemController {
//    private CartItemService cartItemService;
//
//    @Autowired
//    public CartItemController(CartItemService cartItemService) {
//        this.cartItemService = cartItemService;
//    }
//
//    @GetMapping("/cartItems")
//    public String getAll(Model model) {
//        model.addAttribute("listCartItems", cartItemService.getAllCartItems());
//        return "cart";
//    }
//
//    @GetMapping("/showNewCartItemForm")
//    public String showNewForm(Model model) {
//        // create model attribute to bind form data
//        CartItem cartItem = new CartItem();
//        model.addAttribute("cartItem", cartItem);
//        return "new_cart_item";
//    }
//
//    @PostMapping("/saveCartItem")
//    public String save(@ModelAttribute("cartItem") CartItem cartItem) {
//        // save cartItem to database
//        cartItemService.saveCartItem(cartItem);
//        return "redirect:/cart";
//    }
//
//    @GetMapping("/showCartItemFormForUpdate/{id}")
//    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
//
//        // get cartItem from the service
//        CartItem cartItem = cartItemService.getCartItemById(id);
//
//        // set cartItem as a model attribute to pre-populate the form
//        model.addAttribute("cartItem", cartItem);
//        return "update_cart_item";
//    }
//
//    @GetMapping("/deleteCartItem/{id}")
//    public String delete(@PathVariable(value = "id") long id) {
//
//        // call delete cartItem method
//        this.cartItemService.deleteCartItemById(id);
//        return "redirect:/cart";
//    }
}
