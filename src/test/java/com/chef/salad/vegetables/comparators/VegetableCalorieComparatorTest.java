package com.chef.salad.vegetables.comparators;

import com.chef.salad.vegetables.FruitVegetable;
import com.chef.salad.vegetables.LeafyGreen;
import com.chef.salad.vegetables.RootVegetable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VegetableCalorieComparatorTest {

    @Test
    void compare() {
        VegetableCalorieComparator comparator = new VegetableCalorieComparator();

        RootVegetable beetroot = new RootVegetable("beetroot", 200.0, 43.0);
        FruitVegetable tomato = new FruitVegetable("tomato", 150.0, 20.0);
        LeafyGreen spinach = new LeafyGreen("spinach", 50.0, 43.0);

        assertTrue(comparator.compare(beetroot, tomato) > 0);

        assertTrue(comparator.compare(tomato, beetroot) < 0);

        assertEquals(0, comparator.compare(beetroot, spinach));
    }
}