package com.syeedode.datastructures.bigO.permutations;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Cracking the Coding Interview
 * Chapter 5: Big O
 * pg: 51, Example 12
 */

@RestController
public class PermutationsController {

    @RequestMapping(value="/permutations", method = RequestMethod.GET)
    public String calculatePermutations(@RequestParam(value = "prefix", required=false)
                                       String inputPrefix,
                               @RequestParam(value="string")
                                       String userInputString) {

        if(StringUtils.isEmpty(userInputString)) { return "Invalid string supplied"; }

        if(StringUtils.isEmpty(inputPrefix)) { return permutation(userInputString); }


        return permutation(userInputString, inputPrefix);
    }

    private String permutation(String inString) {
        return permutation(inString, "");
    }

    private String permutation(String inputString, String prefix) {
        int length = inputString.length();
        if(length == 0) {
            return prefix;
        } else {
            // let input string be: a
            // for loop has O(a)
            for(int i = 0; i < length; i++) {
                String substring = inputString.substring(0, i);
                String restOfSubstring = inputString.substring(i + 1);
                String remainder = substring + restOfSubstring;
                // permutation will have O()
                String newPrefix = prefix + inputString.charAt(i);
                permutation(remainder, newPrefix);
            }
        }
        return "Failed to execute code to completion. Please see log flow";
    }
}
