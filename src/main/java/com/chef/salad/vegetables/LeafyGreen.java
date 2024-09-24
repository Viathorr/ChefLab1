package com.chef.salad.vegetables;

public class LeafyGreen extends Vegetable {
    public LeafyGreen() {}

    public LeafyGreen(String name, double weight, double caloriesPer100g) {
        super(name, weight, caloriesPer100g);
    }

    @Override
    public void prepareForSalad() {
        trimStems();
        tearLeaves();
    }

    private void trimStems() {
        System.out.printf("Trimming stems from %s.%n", name);
    }

    private void tearLeaves() {
        System.out.printf("Tearing %s into pieces.%n", name);
    }
}
