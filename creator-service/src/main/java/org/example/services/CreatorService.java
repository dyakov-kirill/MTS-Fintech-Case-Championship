package org.example.services;

import org.example.entities.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CreatorService {
    List<Furnace> furnaces;

    public CreatorService() {
        this.furnaces = new FurnaceFactory().createFurnaceList(5, 3, 2);
    }

    public Map<Product, Integer> produceOrder(Order order) throws InterruptedException {
        Map<Product, Integer> result = new HashMap<>();
        for (Map.Entry<Product, Integer> entity: order.products.entrySet()) {
            for (int i = 0; i < entity.getValue(); i++) {
                ProductType type = entity.getKey().getProductType();
                Furnace furnace = getAvailableFurnace(type);
                if (getAvailableFurnace(type).checkForAvailableComponents(type))  {
                    result.put(furnace.produceProduct(type), result.getOrDefault(type, 0) + 1);
                    order.decreaseProducts(entity.getKey());
                } else {
                    Map<Component, Integer> neededComponents = furnace.getNeededComponents(type);
                    furnace.putComponents(neededComponents);
                    furnace.produceProduct(type);
                    //new RestTemplate().postForEntity();
                    // if ok ->
                    result.put(furnace.produceProduct(type), result.getOrDefault(type, 0) + 1);
                }
            }
        }
        return result;
    }

    private Furnace getAvailableFurnace(ProductType type) {
        for (Furnace furnace: furnaces) {
            if (furnace.checkForAvailableComponents(type)) {
                return furnace;
            }
        }
        return furnaces.get(0);
    }
}
