package com.syeedode.datastructures.dishes;

public class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final MealType type;

    public Dish(String name, boolean vegetarian, int calories, MealType type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public MealType getType() {
        return type;
    }
}
