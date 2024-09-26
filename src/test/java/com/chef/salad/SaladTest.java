package com.chef.salad;

import com.chef.salad.vegetables.FruitVegetable;
import com.chef.salad.vegetables.LeafyGreen;
import com.chef.salad.vegetables.RootVegetable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaladTest {

    @Test
    void addVegetable() {
        RootVegetable beetroot = new RootVegetable("beetroot", 200.0, 43.0);
        FruitVegetable tomato = new FruitVegetable("tomato", 150.0, 20.0);

        Salad salad = new Salad();

        salad.addVegetable(beetroot);
        salad.addVegetable(tomato);

        assertEquals(2, salad.getVegetables().size());
    }
}