package com.chef.salad;

import com.chef.salad.vegetables.Vegetable;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecipeFileReaderTest {

    private static final String TEST_FILE = "/test_salad.txt";

    @Test
    void readVegetableRecipe() {
        List<Vegetable> vegetables = RecipeFileReader.readVegetableRecipe(TEST_FILE);

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
}