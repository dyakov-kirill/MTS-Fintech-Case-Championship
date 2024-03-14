package org.example.entities;

public interface Producer {
    Product produceProduct(ProductType productType) throws InterruptedException;
}
