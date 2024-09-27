package com.chef.salad.vegetables;

import com.chef.salad.vegetables.cookingstrategies.CookingStrategy;

public class Vegetable {
    private String name;
    private double weight; // in grams
    private double caloriesPer100g;
    private CookingStrategy cookingStrategy;

    public Vegetable() {}

    public Vegetable(String name, double weight, double caloriesPer100g, CookingStrategy cookingStrategy) {
        this.name = name;
        this.weight = weight;
        this.caloriesPer100g = caloriesPer100g;
        this.cookingStrategy = cookingStrategy;
    }

    @Override
    public String toString() {
        return name + " (" + weight + "g, " + caloriesPer100g + " cal/100g)";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getCaloriesPer100g() {
        return caloriesPer100g;
    }

    public void setCaloriesPer100g(double caloriesPer100g) {
        this.caloriesPer100g = caloriesPer100g;
    }

    public double calculateTotalCalories() {
        return (weight / 100) * caloriesPer100g;
    }

    public void prepareForSalad() {
        cookingStrategy.cook(this);
    }
}
