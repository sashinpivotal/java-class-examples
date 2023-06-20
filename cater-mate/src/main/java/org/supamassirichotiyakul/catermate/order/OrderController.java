package org.supamassirichotiyakul.catermate.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.supamassirichotiyakul.catermate.cart.Cart;
import org.supamassirichotiyakul.catermate.cart.CartService;
import org.supamassirichotiyakul.catermate.menuitem.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

@Controller
public class OrderController {
    private OrderService orderService;
    private MenuItemService menuItemService;
    private CartService cartService;

    @Autowired
    public OrderController(OrderService orderService,
                           MenuItemService menuItemService,
                           CartService cartService) {
        this.orderService = orderService;
        this.menuItemService = menuItemService;
        this.cartService = cartService;
    }

    @GetMapping("/order")
    public String doOrder(Model model) {
        Cart cart = new Cart();
        model.addAttribute("cart", cart);
        model.addAttribute(
                "listMenuItems",
                menuItemService.getAllMenuItems());
        return "order";
    }

    @GetMapping("/viewOrders")
    public String getAll(Model model) {
        model.addAttribute("listOrders", orderService.getAllOrders());
        model.addAttribute("queryObj", new QueryObj());
        return "view_orders";
    }

    @GetMapping("/showOrderFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        // get order from the service
        Order order = orderService.getOrderById(id);

        // set order as a model attribute to pre-populate the form
        model.addAttribute("order", order);
        model.addAttribute("itemList", order.getOrderItemList());

        return "update_order";
    }

    @GetMapping("/deleteOrder/{id}")
    public String delete(@PathVariable(value = "id") long id) {
        // call delete order method
        this.orderService.deleteOrderById(id);
        return "redirect:/viewOrders";
    }

    @GetMapping("/checkout/{cart_id}")
    public String doCheckOut(@PathVariable(value="cart_id") long cartId, Model model) {
        Cart cart = cartService.getCartById(cartId);
        model.addAttribute("cart", cart);

        model.addAttribute("itemList", cart.getCartItemList());

        Order order = new Order();
        model.addAttribute("order", order);

        return "checkout";
    }

    @PostMapping("/orderSubmitted")
    public String doOrderSubmitted(
            @RequestParam(name="cart_id") int cartId,
            @ModelAttribute("order") Order order) {

        Cart cart = cartService.getCartById(cartId);
        orderService.copyInfoFromCart(order, cart);
        orderService.saveOrder(order);

        Logger logger = LoggerFactory.getLogger(OrderController.class);
        logger.info("Order for " + order.getCustomerFirstName() + " "
                    + order.getCustomerLastName() + " has been submitted");

        return "order_submitted";
    }

    // This is from when the order was updated, no need to copy the cart items to order items
    @PostMapping("/updateOrder")
    public String updateOrder(@ModelAttribute("order") Order order) {
        orderService.saveOrder(order);

        return "redirect:/viewOrders";
    }

    @PostMapping("/findOrders")
    public String findOrders(@ModelAttribute QueryObj queryObj, Model model) {
        System.out.println("qName is " + queryObj.getQueryName());
        System.out.println("qLocation is " + queryObj.getQueryLocation());
        System.out.println("qDate is " + queryObj.getQueryDeliveryDate());

        Set<Order> orderSet = new HashSet<>();

        if(queryObj.getQueryName().isEmpty()
                && queryObj.getQueryLocation().isEmpty()
                && queryObj.getQueryDeliveryDate() == null) {
            System.out.println("all empty fields");

            orderSet.addAll(orderService.getAllOrders());
        } else {
            if (!queryObj.getQueryName().isEmpty()) {
                String name = queryObj.getQueryName();
                orderSet.addAll(orderService.findByCustomerFirstNameContainingOrCustomerLastNameContaining(name, name));
            }

            if (!queryObj.getQueryLocation().isEmpty()) {
                orderSet.addAll(orderService.findByLocationContaining(queryObj.getQueryLocation()));
            }

            if (queryObj.getQueryDeliveryDate() != null) {
                orderSet.addAll(orderService.findByDeliveryDateEquals(queryObj.getQueryDeliveryDate()));
            }
        }

        model.addAttribute("listOrders", orderSet);
        model.addAttribute("queryObj", new QueryObj());

        return "view_orders";
    }
}
