package org.example.entities;

import java.util.Map;

public enum ProductType {
    PIE_MEAT(1000, Map.of(Component.DOUGH, 1, Component.MEAT, 1)),
    PIE_CABBAGE(1000, Map.of(Component.DOUGH, 1, Component.CABBAGE, 1)),
    PIE_FISH(2000, Map.of(Component.DOUGH, 2, Component.FISH, 1)),
    PIE_BERRY(2000, Map.of(Component.DOUGH, 2, Component.BERRIES, 2)),
    TEA(3000, Map.of(Component.TEA_LEAVES, 1)),
    COFFEE(4000, Map.of(Component.COFFEE_BEANS, 2));

    final int delay;
    final Map<Component, Integer> recipe;
    ProductType(int delay, Map<Component, Integer> recipe) {
        this.delay = delay;
        this.recipe = recipe;
    }
}

