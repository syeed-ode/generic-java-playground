package com.syeedode.acommonsencetoalgorithmdatastructure.graphs;

import com.syeedode.acommonsencetoalgorithmdatastructure.graphs.person.Person;
import org.junit.Test;

import java.util.Arrays;

public class CommonSenseAlgorithmGraphTest {
    Person alice = new Person("Alice");
    Person bob = new Person("Bob");
    Person candy = new Person("Candy");
    Person derek = new Person("Derek");
    Person elaine = new Person("Elaine");
    Person fred = new Person("Fred");
    Person helen = new Person("Helen");
    Person gina = new Person("Gina");
    Person irena = new Person("Irena");

    public void setUp() {
        fred.addFriend(helen);
        bob.addFriend(fred);
        gina.addFriend(irena);
        derek.addFriend(gina);
        alice.addFriends(Arrays.asList(bob, candy, derek, elaine));

    }

    @Test
    public void displayFriends_AssurePrintout(){
        setUp();
        alice.displayGraph();
    }
}
