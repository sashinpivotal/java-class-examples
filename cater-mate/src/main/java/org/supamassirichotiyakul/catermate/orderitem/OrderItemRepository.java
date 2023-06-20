package org.supamassirichotiyakul.catermate.orderitem;

import org.supamassirichotiyakul.catermate.orderitem.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
