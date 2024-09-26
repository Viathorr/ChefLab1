package com.chef.salad;

import com.chef.salad.vegetables.FruitVegetable;
import com.chef.salad.vegetables.RootVegetable;
import com.chef.salad.vegetables.Vegetable;
import com.chef.salad.vegetables.comparators.VegetableCalorieComparator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class AdvancedSaladTest {

    private AdvancedSalad advancedSalad;
    private RootVegetable beetroot;
    private FruitVegetable tomato;

    @BeforeEach
    public void setUp() {
        advancedSalad = new AdvancedSalad(new ArrayList<>());

        beetroot = new RootVegetable("beetroot", 200.0, 43.0);
        tomato = new FruitVegetable("tomato", 150.0, 20.0);

        advancedSalad.addVegetable(beetroot);
        advancedSalad.addVegetable(tomato);
    }

    @Test
    void calculateTotalCalories() {
        double expectedCalories = beetroot.calculateTotalCalories() + tomato.calculateTotalCalories();

        assertEquals(expectedCalories, advancedSalad.calculateTotalCalories(), 0.001);
    }

    @Test
    void sortVegetables() {
        VegetableCalorieComparator comparator = new VegetableCalorieComparator();

        advancedSalad.sortVegetables(comparator);

        List<Vegetable> sortedVegetables = advancedSalad.getVegetables();
        assertEquals(tomato, sortedVegetables.get(0)); // Vegetable with lower calories should come first
        assertEquals(beetroot, sortedVegetables.get(1));
    }

    @Test
    void findVegetablesByCaloriesRange() {
        List<Vegetable> result = advancedSalad.findVegetablesByCaloriesRange(10, 31);

        assertEquals(1, result.size());
        assertTrue(result.contains(tomato));
        assertFalse(result.contains(beetroot));
    }
}