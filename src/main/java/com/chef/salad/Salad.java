package com.chef.salad;

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
}
