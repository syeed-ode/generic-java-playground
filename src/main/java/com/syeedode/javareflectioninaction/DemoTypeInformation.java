package com.syeedode.javareflectioninaction;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public class DemoTypeInformation {

    public static void main(String [] args) {
        System.out.println("This is the class: " + Boolean.class);
        System.out.println("This is the class, DemoTypeInformation.class: " + DemoTypeInformation.class);
        System.out.println("This is the class, DemoTypeInformation.class.getName(): " + DemoTypeInformation.class.getName());
        System.out.println("This is the class, new DemoTypeInformation(): " + new DemoTypeInformation());
        (new DemoTypeInformation()).printName();
    }

    public DemoTypeInformation() {
//        this.class.getName();
        System.out.println("Inside DemoTypeInformation constructor: " + this.getClass().getName());
    }

    public void printName() {
        System.out.println("Inside method printName: " + this.getClass().getName());
    }


    /**
     * Listing 1.3
     *
     * This method is a recursive method that traverses the inheritance hierarchy
     * looking for a method with the correct signature using
     * {@code getDeclaredMethod}.
     */
    public static Method getSupportedMethod(Class cls, String name, Class[] paramTypes)
            throws NoSuchMethodException{
        if(Objects.isNull(cls)) {
            throw new NoSuchMethodException();
        }
        try {
            /**
             * The {@code getSuperclass} method returns the class object representing the class
             * that its target extends.
             */
            return cls.getDeclaredMethod(name, paramTypes);
        } catch (NoSuchMethodException ex) {
            return getSupportedMethod(cls.getSuperclass(), name, paramTypes);
        }
    }

    /**
     * Listing 1.4
     *
     * This update allows {@code setObjectColor} to retrieve metaobjects for private, package,
     * and protected methods that are not retrieved by {@code getMethod}. However, this update
     * does not guarantee permission to invoke the method.
     *
     * @param obj
     * @param color
     */
    public static void setObjectColor(Object obj, Color color) {
        Class cls = obj.getClass();
        try {
            Method method = getSupportedMethod(cls, "setColor", new Class[]{Color.class});
            method.invoke(obj, new Object[]{color});
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException(cls.getName()
                    + " does not support method setColor(:Color)");
        } catch (IllegalAccessException e) {
            /**
             * If {@code setObjectColor} does not have access to the  inherited method, an
             * {@code IllegalAccessException} is thrown instead of a
             * {@code NoSuchMethodException}.
             *
             */
            throw new IllegalArgumentException(cls.getName()
                    + " Insufficient access permission to call setColor(:Color) in class "
                    + cls.getName());
        } catch (InvocationTargetException ex) {
            throw new RuntimeException(ex);
        }
    }
}
