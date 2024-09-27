package com.chef;

import com.chef.salad.Chef;
import com.chef.salad.Salad;
import com.chef.salad.RecipeFileReader;
import com.chef.salad.vegetables.Vegetable;
import com.chef.salad.vegetables.comparators.VegetableCalorieComparator;

import java.io.InputStream;
import java.io.InputStreamReader;
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

            InputStream inputStream = SaladMaker.class.getResourceAsStream(recipeFileName);

            if (inputStream == null) {
                System.out.println("File not found. Please try again.");
                continue;
            }

            Chef chef = new Chef();
            chef.setVegetables(RecipeFileReader.readVegetableRecipe(new InputStreamReader(inputStream)));

            Salad salad = chef.cookSalad();

            if (salad.getVegetables().isEmpty()) {
                System.out.println("Salad has no vegetables. Please try again.");
                continue;
            }

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
                    salad.getVegetables()
                            .forEach(System.out::println);

                    break;

                case "3":
                    System.out.println("Enter min calories: ");
                    double minCalories = scanner.nextDouble();
                    System.out.println("Enter max calories: ");
                    double maxCalories = scanner.nextDouble();
                    scanner.nextLine();

                    List<Vegetable> foundVegetables = salad.findVegetablesByCaloriesRange(minCalories, maxCalories);

                    System.out.println("Found Vegetables: ");
                    foundVegetables.forEach(System.out::println);

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
}
