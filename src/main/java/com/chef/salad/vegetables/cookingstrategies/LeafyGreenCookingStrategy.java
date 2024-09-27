package com.chef.salad.vegetables.cookingstrategies;

import com.chef.salad.vegetables.Vegetable;

public class LeafyGreenCookingStrategy implements CookingStrategy {
    @Override
    public void cook(Vegetable vegetable) {
        System.out.printf("Trimming stems from %s.%n", vegetable.getName());
        System.out.printf("Tearing %s into pieces.%n", vegetable.getName());
    }
}
