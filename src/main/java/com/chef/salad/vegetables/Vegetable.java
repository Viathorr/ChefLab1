package com.chef.salad.vegetables;

abstract public class Vegetable {
    private String name;
    private double weight;
    private double caloriesPer100g;

    public Vegetable() {}

    public Vegetable(String name, double weight, double caloriesPer100g) {
        this.name = name;
        this.weight = weight;
        this.caloriesPer100g = caloriesPer100g;
    }

    @Override
    public String toString() {
        return "Vegetable{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", caloriesPer100g=" + caloriesPer100g +
                '}';
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

    abstract public void prepareForSalad();
}
