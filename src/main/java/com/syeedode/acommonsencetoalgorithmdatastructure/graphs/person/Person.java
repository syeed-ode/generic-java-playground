package com.syeedode.acommonsencetoalgorithmdatastructure.graphs.person;

import java.util.*;

public class Person {
    String name;
    List<Person> friends = new ArrayList<>();
    boolean visited;
    Queue<Person> personQueue = new ArrayDeque<>();
    Person currentVertex;

    public Person(String personsName) {
        this.name = personsName;
    }

    public void addFriend(Person friend){
        friends.add(friend);
    }

    public void addFriends(List<Person> friend){
        friends.addAll(friend);
    }

    public void displayGraph() {
        List<Person> toBeReset = new ArrayList<>();
        personQueue.add(this);
        this.visited = true;

        while (Objects.nonNull(personQueue.peek())) {
            currentVertex = personQueue.remove();
            System.out.println(currentVertex.name);

            for(Person friend : currentVertex.friends) {
                if(!friend.visited) {
                    toBeReset.add(friend);
                    personQueue.add(friend);
                    friend.visited = true;
                }
            }
        }

        toBeReset.stream().forEach(f -> f.visited = false);
    }
}
