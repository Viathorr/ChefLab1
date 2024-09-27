package com.chef.salad.vegetables.cookingstrategies;

import com.chef.salad.vegetables.Vegetable;

public class BulbVegetableCookingStrategy implements CookingStrategy {
    @Override
    public void cook(Vegetable vegetable) {
        System.out.printf("Slicing %s.%n", vegetable.getName());
        System.out.printf("Soaking %s to reduce pungency.%n", vegetable.getName());
    }
}
