package com.chef.salad.vegetables;

import com.chef.salad.vegetables.cookingstrategies.LeafyGreenCookingStrategy;
import com.chef.salad.vegetables.cookingstrategies.RootVegetableCookingStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VegetableTest {

    @Test
    void calculateTotalCalories() {
        Vegetable beetroot = new Vegetable("beetroot", 200.0, 43.0,
                new RootVegetableCookingStrategy());

        double expectedCalories = 86.0;  // (200.0 / 100) * 43.0
        assertEquals(expectedCalories, beetroot.calculateTotalCalories(), 0.001);

        Vegetable cabbage = new Vegetable("cabbage", 356.0, 25.0,
                new LeafyGreenCookingStrategy());

        expectedCalories = 89.0;
        assertEquals(expectedCalories, cabbage.calculateTotalCalories(), 0.001);
    }

    @Test
    void testToString() {
        Vegetable beetroot = new Vegetable("beetroot", 200.0, 43.0,
                new RootVegetableCookingStrategy());

        String actualStringRepresentation = "beetroot (200.0g, 43.0 cal/100g)";
        assertEquals(actualStringRepresentation, beetroot.toString());
    }
}