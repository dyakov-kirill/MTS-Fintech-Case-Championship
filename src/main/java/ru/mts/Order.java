package ru.mts;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

public class Order {
    private Map<Product, Integer> products;
    private City city;

    private LocalDateTime date;

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
