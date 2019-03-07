package com.syeedode.datastructures.trees;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Cracking the Coding Interview
 * Chapter 4: Trees and Graphs
 * pg: 100
 */

@RestController
public class TreeController {

    @RequestMapping(value = "/trees", method = RequestMethod.GET)
    public String treeProcessing(@RequestParam(value = "next") String nodeValue) {
        return "";
    }
}
