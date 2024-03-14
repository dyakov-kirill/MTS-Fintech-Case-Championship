package org.example.entities;

import java.util.Map;

public class Recipe {
    Map<Component, Long> recipe;

    public Recipe(Map<Component, Long> recipe) {
        this.recipe = recipe;
    }
}
