package com.chef.salad;

import com.chef.salad.vegetables.FruitVegetable;
import com.chef.salad.vegetables.RootVegetable;
import com.chef.salad.vegetables.Vegetable;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ChefTest {

    @Test
    void cookSalad() {
        RootVegetable beetroot = mock(RootVegetable.class);
        FruitVegetable tomato = mock(FruitVegetable.class);

        List<Vegetable> vegetables = Arrays.asList(beetroot, tomato);

        Salad cookedSalad = Chef.cookSalad(vegetables);

        verify(beetroot).prepareForSalad();
        verify(tomato).prepareForSalad();

        assertNotNull(cookedSalad);
        assertEquals(2, cookedSalad.getVegetables().size());
    }
}