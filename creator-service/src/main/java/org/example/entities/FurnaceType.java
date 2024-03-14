package org.example.entities;

public enum FurnaceType {
    SMALL(2),
    MEDIUM(5),
    BIG(10);

    public final int capacity;

    FurnaceType(int capacity) {
        this.capacity = capacity;
    }
}
