package org.supamassirichotiyakul.catermate.orderitem;

import org.supamassirichotiyakul.catermate.orderitem.OrderItem;

import java.util.List;

public interface OrderItemService {
    List<OrderItem> getAllOrderItems();
    void saveOrderItem(OrderItem orderItem);
    OrderItem getOrderItemById(long id);
    void deleteOrderItemById(long id);
}
