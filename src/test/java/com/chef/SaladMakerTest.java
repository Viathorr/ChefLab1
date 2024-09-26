package com.chef;

import java.util.List;

import com.chef.salad.vegetables.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaladMakerTest {

    private static final String TEST_FILE = "/test_salad.txt";

    @Test
    void readVegetableRecipes() {
        List<Vegetable> vegetables = SaladMaker.readVegetableRecipes(TEST_FILE);

        assertEquals(4, vegetables.size());

        assertEquals("Carrot", vegetables.get(0).getName());
        assertEquals("Tomato", vegetables.get(1).getName());
        assertEquals("Onion", vegetables.get(2).getName());
        assertEquals("Spinach", vegetables.get(3).getName());

        assertEquals(41, vegetables.get(0).getCaloriesPer100g());
        assertEquals(20, vegetables.get(1).getCaloriesPer100g());
        assertEquals(40, vegetables.get(2).getCaloriesPer100g());
        assertEquals(23, vegetables.get(3).getCaloriesPer100g());
    }

    @Test
    void createVegetable() {
        Vegetable carrot = SaladMaker.createVegetable("Root", "Carrot", 150.0, 41.0);
        Vegetable tomato = SaladMaker.createVegetable("Fruit", "Tomato", 150.0, 20.0);
        Vegetable onion = SaladMaker.createVegetable("Bulb", "Onion", 120.0, 40.0);
        Vegetable spinach = SaladMaker.createVegetable("Leafy", "Spinach", 100.0, 23.0);

        assertInstanceOf(RootVegetable.class, carrot);
        assertInstanceOf(FruitVegetable.class, tomato);
        assertInstanceOf(BulbVegetable.class, onion);
        assertInstanceOf(LeafyGreen.class, spinach);
    }
}