package com.chef.salad.vegetables.comparators;

import com.chef.salad.vegetables.Vegetable;
import com.chef.salad.vegetables.cookingstrategies.FruitVegetableCookingStrategy;
import com.chef.salad.vegetables.cookingstrategies.LeafyGreenCookingStrategy;
import com.chef.salad.vegetables.cookingstrategies.RootVegetableCookingStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VegetableCalorieComparatorTest {

    @Test
    void compare() {
        VegetableCalorieComparator comparator = new VegetableCalorieComparator();

        Vegetable beetroot = new Vegetable("beetroot", 200.0, 43.0,
                new RootVegetableCookingStrategy());
        Vegetable tomato = new Vegetable("tomato", 150.0, 20.0,
                new FruitVegetableCookingStrategy());
        Vegetable spinach = new Vegetable("spinach", 50.0, 43.0,
                new LeafyGreenCookingStrategy());

        assertTrue(comparator.compare(beetroot, tomato) > 0);

        assertTrue(comparator.compare(tomato, beetroot) < 0);

        assertEquals(0, comparator.compare(beetroot, spinach));
    }
}