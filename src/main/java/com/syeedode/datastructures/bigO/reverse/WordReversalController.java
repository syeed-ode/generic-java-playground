package com.syeedode.datastructures.bigO.reverse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordReversalController {

    @RequestMapping(value = "/reverse", method = RequestMethod.GET)
    public String reverseWord(@RequestParam(value="word", required=false) String word) {
        char[] wordAsCharArray = word.toCharArray();
        int length = wordAsCharArray.length;
        char [] reversedCharArray = new char[length];
        for(int i=0; i < length; i++){
            reversedCharArray[length-1-i] = wordAsCharArray[i];
        }
        return new String(reversedCharArray);
    }

    @RequestMapping(value = "/reverse2", method = RequestMethod.GET)
    public String reverse(@RequestParam(value="word", required = false) String wordToReverse) {
        char [] wordAsCharArray = wordToReverse.toCharArray();
        int length = wordAsCharArray.length;
        char [] reversedCharArray = new char[length];
        for(int i = 0; i < length; i++) {
            reversedCharArray[length-1-i] = wordAsCharArray[i];
        }
        return String.valueOf(reversedCharArray);
    }

    @RequestMapping(value = "/reverse3", method = RequestMethod.GET)
    public String reverseWordBigO(@RequestParam(value = "word", required = false) String wordToReverse) {
        char [] wordAsCharArray = wordToReverse.toCharArray();
        int length = wordAsCharArray.length;
        for(int i = 0; i < length/2; i++) {
            int reversedPosition = length - 1 - i;
            char tempChar = wordAsCharArray[i];
            wordAsCharArray[i] = wordAsCharArray[reversedPosition];
            wordAsCharArray[reversedPosition] = tempChar;
        }
        return String.valueOf(wordAsCharArray) + ": This is length divide by two: " + length/2;
    }
}
