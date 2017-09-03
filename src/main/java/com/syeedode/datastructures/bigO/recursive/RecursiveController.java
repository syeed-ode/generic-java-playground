package com.syeedode.datastructures.bigO.recursive;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Cracking the Coding Interview
 * Chapter 5: Big O
 * pg: 44, bottom
 */

@RestController
public class RecursiveController {

    @RequestMapping(value = "/recursive", method = RequestMethod.GET)
    public String recursiveProcessing(@RequestParam(value = "depth", required = false) String inputValue) {
        return "";
    }
}
