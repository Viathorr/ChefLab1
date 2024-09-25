package com.chef.salad;

import com.chef.salad.vegetables.Vegetable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AdvancedSalad extends Salad {
    public AdvancedSalad() {}

    public AdvancedSalad(List<Vegetable> vegetables) {
        super(vegetables);
    }

    public double calculateTotalCalories() {
        return vegetables.stream()
                         .mapToDouble(Vegetable::calculateTotalCalories)
                         .sum();
    }

    public void sortVegetables(Comparator<Vegetable> comparator) {
        vegetables.sort(comparator);
    }

    public List<Vegetable> findVegetablesByCaloriesRange(double min, double max) {
        List<Vegetable> result = new ArrayList<>();

        for (Vegetable v : vegetables) {
            double calories = v.calculateTotalCalories();
            if (calories >= min && calories <= max) {
                result.add(v);
            }
        }

        return result;
    }
}
