package org.example.entities;

import java.util.Map;
import java.util.UUID;

public class Order {
    public UUID id;
    public Map<Product, Integer> products;
    public Destination destination;

    public void decreaseProducts(Product product) {
        products.put(product, products.get(product.productType) - 1);
    }
}
