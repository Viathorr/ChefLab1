package com.chef.salad;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import com.chef.salad.vegetables.Vegetable;

public class Salad {
    private List<Vegetable> vegetables = new ArrayList<Vegetable>();

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

    public double totalCalories() {
        double calories = 0.0;

        for (Vegetable v : vegetables) {
            calories += v.totalCalories();
        }

        return calories;
    }
}
