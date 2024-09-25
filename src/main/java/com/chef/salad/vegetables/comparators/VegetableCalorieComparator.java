package com.chef.salad.vegetables.comparators;

import com.chef.salad.vegetables.Vegetable;
import java.util.Comparator;

public class VegetableCalorieComparator implements Comparator<Vegetable> {
    @Override
    public int compare(Vegetable v1, Vegetable v2) {
        return Double.compare(v1.getCaloriesPer100g(), v2.getCaloriesPer100g());
    }
}
