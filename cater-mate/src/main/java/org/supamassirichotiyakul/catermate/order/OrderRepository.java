package org.supamassirichotiyakul.catermate.order;

import org.supamassirichotiyakul.catermate.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomerFirstNameContainingOrCustomerLastNameContaining(String firstNameInfix, String lastNameInfix);
    List<Order> findByDeliveryDateEquals(Date deliveryDate);
    List<Order> findByLocationContaining(String locationInfix);
}
