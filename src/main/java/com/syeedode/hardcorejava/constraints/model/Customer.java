package com.syeedode.hardcorejava.constraints.model;


import com.syeedode.hardcorejava.a_09_3_to_string_reflection.MutableObject;

import java.util.Set;

public class Customer extends MutableObject {
    private Person person;
    private Integer customerID;
    private String email;
    private Set<SavingsAccount> accounts;

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setAccounts(Set<SavingsAccount> accounts) {
        this.accounts = accounts;
    }

    public Set<SavingsAccount> getAccounts() {
        return accounts;
    }
}
