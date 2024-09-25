package com.chef.salad.vegetables;

public class BulbVegetable extends Vegetable {
    public BulbVegetable() {}

    public BulbVegetable(String name, double weight, double caloriesPer100g) {
        super(name, weight, caloriesPer100g);
    }

    @Override
    public void prepareForSalad() {
        soak();
        slice();
    }

    private void slice() {
        System.out.printf("Slicing %s.%n", getName());
    }

    private void soak() {
        System.out.printf("Soaking %s to reduce pungency.%n", getName());
    }
}
