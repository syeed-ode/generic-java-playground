package com.syeedode.reflection.constraints.model;

import com.syeedode.reflection.a_9_3_to_string_reflection.MutableObject;
import com.syeedode.reflection.constraints.Gender;

public class Person extends MutableObject {
    private String firstName;
    private String lastName;
    private Gender gender;
    private String taxID;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    public void setTaxID(String taxID) {
        this.taxID = taxID;
    }

    public String getTaxID() {
        return taxID;
    }
}
