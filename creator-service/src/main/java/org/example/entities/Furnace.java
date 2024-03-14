package org.example.entities;

import java.util.HashMap;
import java.util.Map;

public class Furnace implements Producer {
    FurnaceType furnaceType;
    Map<Component, Integer> components;
    public Furnace(FurnaceType furnaceType) {
        this.furnaceType = furnaceType;
    }

    @Override
    public Product produceProduct(ProductType productType) throws InterruptedException {
        if (checkForAvailableComponents(productType)) {
            for (Map.Entry<Component, Integer> entity: productType.recipe.entrySet()) {
                int prev = components.get(entity.getKey());
                int post = prev - 1;
                components.put(entity.getKey(), post);
            }
            Thread.sleep(productType.delay);
            return new Product(productType);
        } else {
            return null;
        }
    }

    public boolean checkForAvailableComponents(ProductType productType) {
        return getNeededComponents(productType).isEmpty();
    }

    public Map<Component, Integer> getNeededComponents(ProductType productType) {
        Map<Component, Integer> result = new HashMap<>();
        for (Map.Entry<Component, Integer> entity: productType.recipe.entrySet()) {
            int ost = entity.getValue() - components.get(entity.getKey());
            if (ost > 0) {
                result.put(entity.getKey(), ost);
            }
        }
        return result;
    }

    public void putComponents(Map<Component, Integer> components) {
        for (Map.Entry<Component, Integer> entity: components.entrySet()) {
            this.components.put(entity.getKey(), this.components.get(entity.getKey()) + entity.getValue());
        }
    }

}
