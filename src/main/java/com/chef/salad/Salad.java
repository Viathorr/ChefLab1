package com.chef.salad;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import com.chef.salad.vegetables.Vegetable;

public class Salad {
    protected List<Vegetable> vegetables = new ArrayList<>();

    public Salad() {}

    public Salad(List<Vegetable> vegetables) {
        this.vegetables = vegetables;
    }

    public List<Vegetable> getVegetables() {
        return new ArrayList<>(vegetables);
    }

    public List<Vegetable> getSortedVegetables(Comparator<Vegetable> comparator) {
        List<Vegetable> copyVegetables = new ArrayList<>(vegetables);

        copyVegetables.sort(comparator);

        return copyVegetables;
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
        return vegetables.stream()
                .filter(v -> v.calculateTotalCalories() >= min && v.calculateTotalCalories() <= max)
                .collect(Collectors.toList());
    }
}
