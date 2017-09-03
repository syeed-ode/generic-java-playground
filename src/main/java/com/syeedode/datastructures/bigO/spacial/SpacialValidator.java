package com.syeedode.datastructures.bigO.spacial;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SpacialValidator {

    public int validateInput(String questionableInput){
        if(Objects.isNull(questionableInput)){
            return -1;
        }
        Integer validInput = Integer.valueOf(questionableInput);
        if(validInput < 1){
            return -1;
        }
        return validInput;
    }
}
