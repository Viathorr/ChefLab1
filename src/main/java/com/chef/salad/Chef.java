package com.chef.salad;

import java.util.List;
import com.chef.salad.vegetables.Vegetable;

public class Chef {
    private Salad cookedSalad;

    public Salad getCookedSalad() {
        return cookedSalad;
    }

    public void cookSalad(List<Vegetable> vegetables) {
        System.out.println("Cooking a salad:\n");

        cookedSalad = new Salad();

        for (Vegetable v : vegetables) {
            v.prepareForSalad();
            cookedSalad.addVegetable(v);
        }
    }
}
