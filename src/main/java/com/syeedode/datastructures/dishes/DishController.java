package com.syeedode.datastructures.dishes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

@RestController
public class DishController {

    @Autowired
    DishBuildingService buildingService;

    @RequestMapping(value = "/dishes", method = RequestMethod.GET)
    public List<Dish> getDishes() {
        return buildingService.getDishList()
                .stream()
                .sorted(comparing(Dish::getCalories))
                .limit(3)
                .collect(toList());
    }

}
