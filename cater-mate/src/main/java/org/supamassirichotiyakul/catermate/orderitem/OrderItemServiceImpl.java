package org.supamassirichotiyakul.catermate.orderitem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    private OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemServiceImpl(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    @Override
    public void saveOrderItem(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }

    @Override
    public OrderItem getOrderItemById(long id) {
        OrderItem orderItem = orderItemRepository.getById(id);
        if(orderItem == null) {
            throw new OrderItemNotFoundException();
        }
        return orderItem;
    }

    @Override
    public void deleteOrderItemById(long id) {
        orderItemRepository.deleteById(id);
    }
}
