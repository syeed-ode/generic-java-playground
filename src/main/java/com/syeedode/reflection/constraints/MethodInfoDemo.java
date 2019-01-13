package com.syeedode.reflection.constraints;

import com.syeedode.reflection.constraints.model.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodInfoDemo {


    public static void printMethodInfo(final Object obj) {
        Class type = obj.getClass();
        final Method[] methods = type.getMethods();

        for(int idx = 0; idx < methods.length; idx++) {
            System.out.println(methods[idx]);
        }
    }

    public static void emptyStrings(final Object obj) throws IllegalAccessException
            , InvocationTargetException {
        final String PREFIX = "set";
        Method[] methods = obj.getClass().getMethods();
        for(int idx = 0; idx < methods.length; idx++) {
            if(methods[idx].getName().startsWith(PREFIX)){
                if(methods[idx].getParameterTypes()[0] == String.class) {
                    methods[idx].invoke(obj, new Object[]{new String() });
                }
            }
        }
    }

    public static void main(String [] args) {
        Person p = new Person();
        p.setFirstName("Robert");
        p.setLastName("Simmons");
        p.setGender(Gender.MALE);
        p.setTaxID("123abc456");

        printMethodInfo(p);
    }
}
