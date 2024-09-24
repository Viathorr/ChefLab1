package com.chef.salad.vegetables;

public class RootVegetable extends Vegetable {
    public RootVegetable() {}

    public RootVegetable(String name, double weight, double caloriesPer100g) {
        super(name, weight, caloriesPer100g);
    }

    @Override
    public void prepareForSalad() {
        boil();
        shred();
    }

    private void boil() {
        System.out.printf("Boiling %s before shredding.%n", name);
    }

    private void shred() {
        System.out.printf("Shredding %s for salad.%n", name);
    }
}
