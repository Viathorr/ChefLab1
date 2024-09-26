package com.chef.salad.vegetables;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VegetableTest {

    @Test
    void calculateTotalCalories() {
        RootVegetable beetroot = new RootVegetable("beetroot", 200.0, 43.0);

        double expectedCalories = 86.0;  // (200.0 / 100) * 43.0
        assertEquals(expectedCalories, beetroot.calculateTotalCalories(), 0.001);

        LeafyGreen cabbage = new LeafyGreen("cabbage", 356.0, 25.0);

        expectedCalories = 89.0;
        assertEquals(expectedCalories, cabbage.calculateTotalCalories(), 0.001);
    }

    @Test
    void testToString() {
        RootVegetable beetroot = new RootVegetable("beetroot", 200.0, 43.0);

        String actualStringRepresentation = "beetroot (200.0g, 43.0 cal/100g)";
        assertEquals(actualStringRepresentation, beetroot.toString());
    }
}