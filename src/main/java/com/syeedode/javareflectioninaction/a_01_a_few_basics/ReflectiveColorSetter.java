package com.syeedode.javareflectioninaction.a_01_a_few_basics;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectiveColorSetter {
    /**
     * This method uses reflection to invoke the 'setColor' method on any
     * object that has a 'setColor' method. We say that setObjectColor introspects
     * on its parameter, obj.
     *
     * @param obj
     * @param color
     */
    public static void setObjectColor(Object obj, Color color) {
        /** 1 Query the object for the class */
        Class cls = obj.getClass();

        try {
            Method method = cls.getMethod("setCoilor", /** <- Queries class for setObjectMethod */
                    new Class [] {Color.class});
            /**
             * Dynamic invocation is a feature that enables a program to call a method on an object at
             * runtime without specifying which method at compile time. This line calls the resulting
             * method on obj, passing it the color
             */
            method.invoke(obj, new Object[]{color});
        } catch (NoSuchMethodException ex) {
            throw new IllegalArgumentException(cls.getName() + " does not support setColor(Color)");
        } catch (IllegalAccessException ex) {
            /** The class does not have access privileges to call a protected, package, or private
             * visibility setColor method.
             */
            throw new IllegalArgumentException("Insufficient access permision to call"
                    + "setColor(:Color) in class " + cls.getName());
        } catch (InvocationTargetException ex) {
            /** 'setColor' method throws an exception */
            throw new RuntimeException(ex);
        }
    }
}
