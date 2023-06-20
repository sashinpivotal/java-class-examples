package org.supamassirichotiyakul.catermate.order;

import org.supamassirichotiyakul.catermate.cart.Cart;
import org.supamassirichotiyakul.catermate.order.Order;

import java.util.Date;
import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    void saveOrder(Order order);
    Order getOrderById(long id);
    void deleteOrderById(long id);

    void copyInfoFromCart(Order order, Cart cart);

    List<Order> findByCustomerFirstNameContainingOrCustomerLastNameContaining(String firstNameInfix, String lastNameInfix);
    List<Order> findByDeliveryDateEquals(Date deliveryDate);
    List<Order> findByLocationContaining(String locationInfix);
}
