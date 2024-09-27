package com.chef.salad;

import java.util.ArrayList;
import java.util.List;
import com.chef.salad.vegetables.Vegetable;

public class Chef {
    private List<Vegetable> vegetables = new ArrayList<>();

    public void setVegetables(List<Vegetable> vegetables) {
        this.vegetables = vegetables;
    }

    public Salad cookSalad() {
        Salad cookedSalad = new Salad();

        if (vegetables.isEmpty()) {
            return cookedSalad;
        }

        System.out.println("Cooking a salad:");

        vegetables.forEach(v -> {
            v.prepareForSalad();
            cookedSalad.addVegetable(v);
        });

        return cookedSalad;
    }
}
