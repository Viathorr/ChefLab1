package com.chef;

import com.chef.salad.AdvancedSalad;
import com.chef.salad.Chef;
import com.chef.salad.vegetables.Vegetable;
import com.chef.salad.vegetables.BulbVegetable;
import com.chef.salad.vegetables.FruitVegetable;
import com.chef.salad.vegetables.RootVegetable;
import com.chef.salad.vegetables.LeafyGreen;
import com.chef.salad.vegetables.comparators.VegetableCalorieComparator;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaladMaker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String recipeFileName;

        while (true) {
            System.out.println("Enter the recipe file name (or type 'quit' to exit): ");
            recipeFileName = scanner.nextLine().trim();

            if (recipeFileName.equalsIgnoreCase("quit")) {
                break;
            }

            List<Vegetable> vegetables = readVegetableRecipes(recipeFileName);

            if (vegetables.isEmpty()) {
                System.out.println("No vegetables found or error reading the file. Please try again.");
                continue;
            }

            AdvancedSalad salad = Chef.cookSalad(vegetables);
            boolean back = false;

            do {
                System.out.println("\nChoose an option (enter the number):");
                System.out.println("1. Calculate total calories");
                System.out.println("2. Sort vegetables by calories");
                System.out.println("3. Find vegetables by calories range");
                System.out.println("4. Go back to recipe selection");

                String option = scanner.nextLine().trim();

                switch (option) {
                    case "1":
                        System.out.println("Total calories: " + salad.calculateTotalCalories());
                        break;

                    case "2":
                        VegetableCalorieComparator comparator = new VegetableCalorieComparator();
                        salad.sortVegetables(comparator);

                        System.out.println("Sorted vegetables: ");
                        for (Vegetable v : salad.getVegetables()) {
                            System.out.println(v);
                        }
                        break;

                    case "3":
                        System.out.println("Enter min calories: ");
                        double minCalories = scanner.nextDouble();
                        System.out.println("Enter max calories: ");
                        double maxCalories = scanner.nextDouble();
                        scanner.nextLine();

                        List<Vegetable> foundVegetables = salad.findVegetablesByCaloriesRange(minCalories, maxCalories);

                        System.out.println("Found Vegetables: ");
                        for (Vegetable vegetable : foundVegetables) {
                            System.out.println(vegetable);
                        }
                        break;

                    case "4":
                        back = true;
                        break;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } while (!back);
        }

        scanner.close();
        System.out.println("Quitting...");
    }

    private static List<Vegetable> readVegetableRecipes(String filename) {
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
