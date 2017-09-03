package com.syeedode.effectivejava.generics.genericmethods;

import java.util.Collection;

/**
 * Effective Java
 * Generics -> Item 27: Favor Generic Methods
 * <p>
 * Author: syeedode
 * Date: 7/10/17
 */
public class GenericMethods {

    public <T> void fromArrayToCollections(T[] array, Collection<T> collection){
        for(T t : array) {
            collection.add(t);
        }
    }
}
