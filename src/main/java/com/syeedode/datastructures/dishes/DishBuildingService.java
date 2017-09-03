package com.syeedode.datastructures.dishes;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DishBuildingService {

    public List<Dish> getDishList() {
        return Arrays.asList(
                  new Dish("pork",false,800, MealType.MEAT)
                , new Dish("beef", false, 700, MealType.MEAT)
                , new Dish("chicken",false, 400, MealType.MEAT)
                , new Dish("french fries", true, 530, MealType.OTHER)
                , new Dish("rice",true,350, MealType.OTHER)
                , new Dish("season fruit",true, 120, MealType.OTHER)
                , new Dish("prawns",false, 300, MealType.FISH)
                , new Dish("salmon",false, 450, MealType.FISH)
        );
    }
}
