package com.example.test.Repository;

import com.example.test.Model.Order;
import com.example.test.Model.OrderStatus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class OrderRepository {

    private final ConcurrentMap<Long, Order> map = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Order save(Order order) {
        long id = idGenerator.getAndIncrement();
        order.setId(id);
        map.put(id, order);
        return order;
    }

    public Optional<Order> findById(long id) {
        return Optional.ofNullable(map.get(id));
    }

    public List<Order> findAll() {
        return new ArrayList<>(map.values());
    }

    public Optional<Order> updateStatus(long id, OrderStatus newStatus) {
        Order updated = map.computeIfPresent(id, (k, existing) -> {
            existing.setStatus(newStatus);
            return existing;
        });
        return Optional.ofNullable(updated);
    }
}
