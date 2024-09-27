package com.chef.salad.vegetables.cookingstrategies;

import com.chef.salad.vegetables.Vegetable;

public class FruitVegetableCookingStrategy implements CookingStrategy {
    @Override
    public void cook(Vegetable vegetable) {
        System.out.printf("Dicing %s into small cubes.%n", vegetable.getName());
    }
}
