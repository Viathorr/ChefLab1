package com.chef.salad;

import java.util.List;
import com.chef.salad.vegetables.Vegetable;

public class Chef {
    static public Salad cookSalad(List<Vegetable> vegetables) {
        System.out.println("Cooking a salad:");

        Salad cookedSalad = new Salad();

        for (Vegetable v : vegetables) {
            v.prepareForSalad();
            cookedSalad.addVegetable(v);
        }

        return cookedSalad;
    }
}
