package org.example.entities;

import java.util.UUID;

public class Product {

    ProductType productType;
    UUID id;

    public Product(ProductType productType) {
        this.productType = productType;
        this.id = UUID.randomUUID();
    }

    public ProductType getProductType() {
        return productType;
    }
}
