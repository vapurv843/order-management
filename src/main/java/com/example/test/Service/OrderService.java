package com.example.test.Service;

import com.example.test.Model.Order;
import com.example.test.Model.OrderStatus;
import com.example.test.Repository.OrderRepository;
import com.example.test.dto.CreateOrderRequest;
import org.springframework.stereotype.Service;
import com.example.test.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository repository;

    public OrderService(OrderRepository repository ){
        this.repository = repository;
    }

    public Order createOrder(CreateOrderRequest orderRequest){
        Order order = new Order();
        order.setCustomerName(orderRequest.getCustomerName());
        order.setItems(orderRequest.getItems());
        order.setStatus(OrderStatus.ORDER_PLACED);
        return repository.save(order);

    }

    public Order getOrder(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found: " + id));
    }

    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    public Order updateStatus(long id, OrderStatus newStatus) {
        return repository.updateStatus(id, newStatus)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found: " + id));
    }


}
