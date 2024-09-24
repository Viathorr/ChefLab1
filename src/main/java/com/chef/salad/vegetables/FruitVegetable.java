package com.chef.salad.vegetables;

public class FruitVegetable extends Vegetable {
    public FruitVegetable() {}

    public FruitVegetable(String name, double weight, double caloriesPer100g) {
        super(name, weight, caloriesPer100g);
    }

    @Override
    public void prepareForSalad() {
        dice();
    }

    private void dice() {
        System.out.printf("Dicing %s into small cubes.%n", name);
    }
}
