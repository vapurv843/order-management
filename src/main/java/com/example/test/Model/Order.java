package com.example.test.Model;

import com.example.test.Model.OrderItem;
import com.example.test.Model.OrderStatus;
import jdk.jfr.DataAmount;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Data
public class Order {
    private Long id;
    private String customerName;
    private List<OrderItem> items = new ArrayList<>();
    private OrderStatus status;




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
