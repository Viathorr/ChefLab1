package com.chef.salad.vegetables.cookingstrategies;

import com.chef.salad.vegetables.Vegetable;

public class RootVegetableCookingStrategy implements CookingStrategy {
    @Override
    public void cook(Vegetable vegetable) {
        System.out.printf("Boiling %s before shredding.%n", vegetable.getName());
        System.out.printf("Shredding %s for salad.%n", vegetable.getName());
    }
}
