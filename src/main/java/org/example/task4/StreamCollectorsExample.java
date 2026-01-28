package org.example.task4;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Order {
    private String product;
    private double cost;

    public Order(String product, double cost) {
        this.product = product;
        this.cost = cost;
    }

    public String getProduct() {
        return product;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(cost, order.cost) == 0 && Objects.equals(product, order.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, cost);
    }

    @Override
    public String toString() {
        return "Order{" +
                "product='" + product + '\'' +
                ", cost=" + cost +
                '}';
    }
}

public class StreamCollectorsExample {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0)
        );

        Map<String, List<Order>> task1 = orders.stream().collect(Collectors.groupingBy(Order::getProduct));
        Map<String, Double> task2 = orders.stream().collect(Collectors.groupingBy(
                Order::getProduct,
                Collectors.summingDouble(Order::getCost)));
        List<String> task3 = task2.entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed()).map(Map.Entry::getKey).toList();
        List<Order> task4 = orders.stream().sorted(Comparator.comparing(Order::getCost).reversed()).limit(3).toList();
        //Последнее не понял как делать
    }
}