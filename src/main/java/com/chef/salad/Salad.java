package com.chef.salad;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import com.chef.salad.vegetables.Vegetable;

public class Salad {
    protected List<Vegetable> vegetables = new ArrayList<>();

    public Salad() {}

    public Salad(List<Vegetable> vegetables) {
        this.vegetables = vegetables;
    }

    public List<Vegetable> getVegetables() {
        return Collections.unmodifiableList(vegetables);
    }

    public void addVegetable(Vegetable vegetable) {
        vegetables.add(vegetable);
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
