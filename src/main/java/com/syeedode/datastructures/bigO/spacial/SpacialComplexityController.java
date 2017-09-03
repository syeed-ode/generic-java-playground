package com.syeedode.datastructures.bigO.spacial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Cracking the Coding Interview
 * Chapter 5: Big O
 * pg: 44, bottom
 */

@RestController
public class SpacialComplexityController {

    @Autowired
    public SpacialComplexityService sumService;

    @Autowired
    SpacialValidator spacialValidator;

    @RequestMapping(value = "/sum", method = RequestMethod.GET)
    public String sumDepth(@RequestParam(value="numStart", required = false) String inputValue) {

        Integer validInput = spacialValidator.validateInput(inputValue);

        if(validInput == -1) {
            return "Sorry invalid input";
        }
        ArrayList<String> list = new ArrayList<String>();
        list.add("Hello");

        return sumService.createSumAndPrintValue(validInput);
    }

}
