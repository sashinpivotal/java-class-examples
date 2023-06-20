package org.supamassirichotiyakul.catermate.order;

import org.supamassirichotiyakul.catermate.cart.Cart;
import org.supamassirichotiyakul.catermate.orderitem.OrderItem;
import org.supamassirichotiyakul.catermate.orderitem.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private OrderItemService orderItemService;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository,
                            OrderItemService orderItemService) {
        this.orderRepository = orderRepository;
        this.orderItemService = orderItemService;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Order getOrderById(long id) {
        Order order = orderRepository.getById(id);
        if(order == null) {
            throw new OrderNotFoundException();
        }
        return order;
    }

    @Override
    public void deleteOrderById(long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public void copyInfoFromCart(Order order, Cart cart) {
        cart.getCartItemList().forEach( cartItem -> {
            OrderItem orderItem = new OrderItem(cartItem);
//            orderItem.setOrder(order);
            order.getOrderItemList().add(orderItem);
        });

        order.setSubTotal(cart.getSubTotal());
        order.setTax(cart.getTax());
        order.setTotal(cart.getTotal());
    }

    @Override
    public List<Order> findByCustomerFirstNameContainingOrCustomerLastNameContaining(String firstNameInfix, String lastNameInfix) {
        return orderRepository.findByCustomerFirstNameContainingOrCustomerLastNameContaining(firstNameInfix, lastNameInfix);
    }

    @Override
    public List<Order> findByDeliveryDateEquals(Date deliveryDate) {
        return orderRepository.findByDeliveryDateEquals(deliveryDate);
    }

    @Override
    public List<Order> findByLocationContaining(String locationInfix) {
        return orderRepository.findByLocationContaining(locationInfix);
    }
}
