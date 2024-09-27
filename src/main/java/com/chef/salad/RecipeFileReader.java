package com.chef.salad;

import com.chef.salad.vegetables.*;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class RecipeFileReader {
    public static List<Vegetable> readVegetableRecipe(Reader reader) {
        List<Vegetable> vegetables = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(reader)) {
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
            case "root" -> new RootVegetable(name, weight, caloriesPer100g);
            case "fruit" -> new FruitVegetable(name, weight, caloriesPer100g);
            case "bulb" -> new BulbVegetable(name, weight, caloriesPer100g);
            case "leafy" -> new LeafyGreen(name, weight, caloriesPer100g);
            default -> {
                System.out.println("Unknown vegetable category: " + category);
                yield null;
            }
        };
    }
}
