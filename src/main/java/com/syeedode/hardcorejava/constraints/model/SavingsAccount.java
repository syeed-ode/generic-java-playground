package com.syeedode.hardcorejava.constraints.model;

import com.syeedode.hardcorejava.a_09_3_to_string_reflection.MutableObject;

public class SavingsAccount extends MutableObject {
    private Customer customer;
    private Float balance;
    private Integer ID;
    private Float interestRate;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Float getBalance() {
        return balance;
    }

    public void setID(Integer id) {
        this.ID = id;
    }

    public Integer getID() {
        return ID;
    }

    public void setInterestRate(Float interestRate) {
        this.interestRate = interestRate;
    }

    public Float getInterestRate() {
        return interestRate;
    }
}
