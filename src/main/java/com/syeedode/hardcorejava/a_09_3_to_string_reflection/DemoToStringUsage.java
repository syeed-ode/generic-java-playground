package com.syeedode.hardcorejava.a_09_3_to_string_reflection;

import com.syeedode.hardcorejava.constraints.model.Customer;
import com.syeedode.hardcorejava.constraints.model.Person;
import com.syeedode.hardcorejava.constraints.model.SavingsAccount;

import java.util.HashSet;
import java.util.Set;

import static com.syeedode.hardcorejava.constraints.Gender.MALE;

public class DemoToStringUsage {
    public static void main(String [] args) {
        Person p = new Person();
        p.setFirstName("Rober");
        p.setLastName("Simmons");
        p.setGender(MALE);
        p.setTaxID("123abc456");

        Customer c = new Customer();
        c.setPerson(p);
        c.setCustomerID(new Integer(414122));
        c.setEmail("foo@bar.com");

        SavingsAccount a = new SavingsAccount();
        a.setCustomer(c);
        a.setBalance(new Float(2212.5f));
        a.setID(new Integer(412413789));
        a.setInterestRate(new Float(0.062f));

        Set<SavingsAccount> accounts = new HashSet<>();
        accounts.add(a);
        c.setAccounts(accounts);

        // Print all of the items
        System.out.println(p);
        System.out.println(c);
        System.out.println(a);
    }
}
