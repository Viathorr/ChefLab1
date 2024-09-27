package com.chef.salad;

import com.chef.SaladMaker;
import com.chef.salad.vegetables.*;
import com.chef.salad.vegetables.cookingstrategies.BulbVegetableCookingStrategy;
import com.chef.salad.vegetables.cookingstrategies.FruitVegetableCookingStrategy;
import com.chef.salad.vegetables.cookingstrategies.LeafyGreenCookingStrategy;
import com.chef.salad.vegetables.cookingstrategies.RootVegetableCookingStrategy;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RecipeFileReader {
    public static List<Vegetable> readVegetableRecipe(String filename) {
        List<Vegetable> vegetables = new ArrayList<>();

        try (InputStream inputStream = SaladMaker.class.getResourceAsStream(filename);
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                String category = parts[0].trim();
                String name = parts[1].trim();
                double weight = Double.parseDouble(parts[2].trim());
                double caloriesPer100g = Double.parseDouble(parts[3].trim());

                Vegetable vegetable = createVegetable(category, name, weight, caloriesPer100g);

                if (vegetable != null) {
                    vegetables.add(vegetable);
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return vegetables;
    }

    private static Vegetable createVegetable(String category, String name, double weight, double caloriesPer100g) {
        return switch (category.toLowerCase()) {
            case "root" -> new Vegetable(name, weight, caloriesPer100g, new RootVegetableCookingStrategy());
            case "fruit" -> new Vegetable(name, weight, caloriesPer100g, new FruitVegetableCookingStrategy());
            case "bulb" -> new Vegetable(name, weight, caloriesPer100g, new BulbVegetableCookingStrategy());
            case "leafy" -> new Vegetable(name, weight, caloriesPer100g, new LeafyGreenCookingStrategy());
            default -> {
                System.out.println("Unknown vegetable category: " + category);
                yield null;
            }
        };
    }
}
