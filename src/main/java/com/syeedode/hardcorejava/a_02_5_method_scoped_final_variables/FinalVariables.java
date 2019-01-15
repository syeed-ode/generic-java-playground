package com.syeedode.hardcorejava.a_02_5_method_scoped_final_variables;

import javax.swing.*;

/**
 * The technique of fixing variables with 'final' is extremely
 * handy for long or complicated methods that have many local
 * variables. You can avert typos by using 'final' to fix the
 * value of your variables.
 */
public class FinalVariables {

    /**
     * This is a scoped 'final' variable that adds a prefix to the
     * parameter 'environmentKey'. The 'final' variable is final
     * only within the 'execution scope', which is different at
     * each execution method.
     *
     * @param environmentKey
     * @return
     */
    public static String someMethod(final String environmentKey) {
        /**
         * Each time the method is entered, the 'final' is
         * reconstructed. As soon as it is constructed, it cannot be
         * changed during the scope of the method execution.
         */
        /** method scoped final variable */
        final String key = "env." + environmentKey;
        System.out.println("Key is: " + key);
        return (System.getProperty(key));
    }

    /**
     * To see how method-scoped final variables works, use the test
     * program below.
     *
     * @param args
     */
    public final static void main(final String[] args) {
        System.out.println("Note how the key variable is changed.");
        /** Each time the method is entered, the passed-in 'environmentKey'
         *  parameter is appended to the constant prefix and then frozen
         *  for the duration of the method call
         */
        someMethod("JAVA_HOME");
        someMethod("ANT_HOME");
    }

    /**
     * This is a good example of trading a logic error for a compile time
     * error.
     *
     * @param environmentKey
     * @return
     */
    public static String someBuggedMethod(final String environmentKey) {
        final String key = "env." + environmentKey;
        System.out.println("Key is: " + key);
        /**
        key = new String("someValue"); // <- would cause a compile time error
        */
        return (System.getProperty(key));
    }

    /**
     * If you want to, you can defer the initialization of a 'final' variable
     * within the method.
     *
     * @param name
     */
    public void buildGUIDialog(final String name) {
        final String instanceName;
        if(name == null) {
            // no problem here
            instanceName = getClass().getName() + hashCode();
        } else {
            // no problem here either
            instanceName = getClass().getName() + hashCode();
        }
        JDialog dialog = new JDialog();
        // .. Do a bunch of layout and component building
        dialog.setTitle(instanceName);
        // .. Do dialog assembly
        /**
        instanceName = "hello"; // <- compiler error
         *
         */
        /**
         * Once you assign the variable a value, it can't be assigned again.
         */

    }
}
