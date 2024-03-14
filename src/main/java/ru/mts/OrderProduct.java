package ru.mts;

import lombok.Getter;

@Getter
public class OrderProduct{
    String nameProduct;
    int cntProduct;

    public OrderProduct() {
    }

    public OrderProduct(String nameProduct, int cntProduct) {
        this.nameProduct = nameProduct;
        this.cntProduct = cntProduct;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "nameProduct='" + nameProduct + '\'' +
                ", cntProduct=" + cntProduct +
                '}';
    }
}
