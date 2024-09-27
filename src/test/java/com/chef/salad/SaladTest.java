package com.chef.salad;

import com.chef.salad.vegetables.Vegetable;
import com.chef.salad.vegetables.comparators.VegetableCalorieComparator;
import com.chef.salad.vegetables.cookingstrategies.FruitVegetableCookingStrategy;
import com.chef.salad.vegetables.cookingstrategies.RootVegetableCookingStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SaladTest {

    private Salad salad;
    private Vegetable beetroot;
    private Vegetable tomato;

    @BeforeEach
    public void setUp() {
        salad = new Salad(new ArrayList<>());

        beetroot = new Vegetable("beetroot", 200.0, 43.0,
                new RootVegetableCookingStrategy());
        tomato = new Vegetable("tomato", 150.0, 20.0,
                new FruitVegetableCookingStrategy());

        salad.addVegetable(beetroot);
        salad.addVegetable(tomato);
    }

    @Test
    void getSortedVegetables() {
        VegetableCalorieComparator comparator = new VegetableCalorieComparator();

        List<Vegetable> sortedVegetables = salad.getSortedVegetables(comparator);

        assertEquals(tomato, sortedVegetables.get(0));
        assertEquals(beetroot, sortedVegetables.get(1));
    }

    @Test
    void addVegetable() {
        Vegetable beetroot = new Vegetable("beetroot", 200.0, 43.0,
                new RootVegetableCookingStrategy());
        Vegetable tomato = new Vegetable("tomato", 150.0, 20.0,
                new FruitVegetableCookingStrategy());

        Salad salad = new Salad();

        salad.addVegetable(beetroot);
        salad.addVegetable(tomato);

        assertEquals(2, salad.getVegetables().size());
    }

    @Test
    void calculateTotalCalories() {
        double expectedCalories = beetroot.calculateTotalCalories() + tomato.calculateTotalCalories();

        assertEquals(expectedCalories, salad.calculateTotalCalories(), 0.001);
    }

    @Test
    void sortVegetables() {
        VegetableCalorieComparator comparator = new VegetableCalorieComparator();

        salad.sortVegetables(comparator);

        List<Vegetable> sortedVegetables = salad.getVegetables();
        assertEquals(tomato, sortedVegetables.get(0)); // Vegetable with lower calories should come first
        assertEquals(beetroot, sortedVegetables.get(1));
    }

    @Test
    void findVegetablesByCaloriesRange() {
        List<Vegetable> result = salad.findVegetablesByCaloriesRange(10, 31);

        assertEquals(1, result.size());
        assertTrue(result.contains(tomato));
        assertFalse(result.contains(beetroot));
    }
}