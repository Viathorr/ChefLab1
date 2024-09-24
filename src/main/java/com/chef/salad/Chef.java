package com.chef.salad;

import java.util.List;
import com.chef.salad.vegetables.Vegetable;

// TODO Delete this class and create app main salad-related methods in another place.
public class Chef {
    private Salad cookedSalad;

    public Salad cookSalad(List<Vegetable> vegetables) {
        System.out.println("Cooking a salad:\n");

        for (Vegetable v : vegetables) {
            v.prepareForSalad();
        }

        cookedSalad = new Salad(vegetables);

        return cookedSalad;
    }


}
