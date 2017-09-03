package com.syeedode.datastructures.utilities;


import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * Cracking the Coding Interview
 * Chapter 5: Big O
 * pg: 51, Example 12
 */

@RestController
public class UtilitiesController {

    @RequestMapping(value="/substring", method = RequestMethod.GET)
    public String getSubstring(@RequestParam(value = "integer", required=false)
                                           Integer inputInteger,
                               @RequestParam(value="string")
                                       String inputString) {

        if(StringUtils.isEmpty(inputString)) { return "Invalid string supplied"; }

        if(Objects.isNull(inputString)) { return inputString.substring(0,inputString.length() - 1); }


        return inputString.substring(inputInteger);
    }
}
