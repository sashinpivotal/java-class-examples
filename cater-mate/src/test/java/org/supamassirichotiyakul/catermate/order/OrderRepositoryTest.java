package org.supamassirichotiyakul.catermate.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.supamassirichotiyakul.catermate.order.Order;
import org.supamassirichotiyakul.catermate.order.OrderRepository;
import org.supamassirichotiyakul.catermate.order.OrderService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderRepositoryTest {
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    @Transactional
    void findByCustomerFirstNameContainingOrCustomerLastNameContainingShouldReturnCorrectResult() {
        // act and assert
        List<Order> beforeList = orderRepository.findByCustomerFirstNameContainingOrCustomerLastNameContaining("am", "am");
        int beforeAddingMoreOrders = beforeList.size();

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

        List<Order> resultList = orderRepository.findByCustomerFirstNameContainingOrCustomerLastNameContaining("am", "am");

        Assertions.assertThat(resultList.size()).isEqualTo(beforeAddingMoreOrders + 1);
        Assertions.assertThat(resultList.contains(order)).isTrue();
    }

    @Test
    @Transactional
    void findByLocationContainingShouldReturnCorrectResult() {
        // act and assert
        List<Order> beforeList = orderRepository.findByCustomerFirstNameContainingOrCustomerLastNameContaining("am", "am");
        int beforeAddingMoreOrders = beforeList.size();

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

        List<Order> resultList = orderRepository.findByLocationContaining("Mesa");

        Assertions.assertThat(resultList.size()).isEqualTo(beforeAddingMoreOrders + 1);
        Assertions.assertThat(resultList.contains(order)).isTrue();
    }

    @Test
    @Transactional
    void findByDeliveryDateEqualsShouldReturnCorrectResult() {
        // act and assert
        List<Order> beforeList = orderRepository.findByCustomerFirstNameContainingOrCustomerLastNameContaining("am", "am");
        int beforeAddingMoreOrders = beforeList.size();

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

        List<Order> resultList = orderRepository.findByDeliveryDateEquals(new Date());

        Assertions.assertThat(resultList.size()).isEqualTo(beforeAddingMoreOrders + 1);
        Assertions.assertThat(resultList.contains(order)).isTrue();
    }
}
