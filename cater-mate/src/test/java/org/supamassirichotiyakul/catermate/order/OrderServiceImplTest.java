package org.supamassirichotiyakul.catermate.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.supamassirichotiyakul.catermate.order.Order;
import org.supamassirichotiyakul.catermate.order.OrderService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderServiceImplTest {
    @Autowired
    private OrderService orderService;

    @Test
    @Transactional
    void getAllOrdersShouldReturnCorrectResultList() {
        // act and assert
        List<Order> allOrders = orderService.getAllOrders();
        int beforeAddingMoreOrders = allOrders.size();

        Assertions.assertThat(beforeAddingMoreOrders).isEqualTo(0);

        Order order = new Order();
        order.setCustomerFirstName("Sam");
        order.setCustomerLastName("Smith");
        order.setDeliveryAddress("22 Main St., Chandler, AZ 85333");
        order.setCustomerPhone("480-222-4444");
        order.setDeliveryOption("Deliver");
        order.setLocation("Mesa");
        order.setDeliveryDate(new Date());
        order.setKitchenReadyTime(new Date());
        order.setOrderItemList(new ArrayList<>());

        orderService.saveOrder(order);

        allOrders = orderService.getAllOrders();
        int afterAddingMoreOrders = allOrders.size();

        Assertions.assertThat(afterAddingMoreOrders).isEqualTo(beforeAddingMoreOrders + 1);
        Assertions.assertThat(allOrders.contains(order)).isTrue();
    }
}
