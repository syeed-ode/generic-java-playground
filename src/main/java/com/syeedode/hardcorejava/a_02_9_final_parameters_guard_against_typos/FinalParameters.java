package com.syeedode.hardcorejava.a_02_9_final_parameters_guard_against_typos;

public class FinalParameters {

    private static final double M = 9.3;

    /**
     * Using final for the parameter assures that no one accidentally changes
     * the parameter values afterward.
     *
     * ALWAYS LABEL METHOD PARAMETER AS FINAL
     * @param inputValue
     * @return
     */
    public double equation2(final double inputValue) {
        final double K = 1.414;
        final double X = 45.0;
        double result =- (((Math.pow(inputValue, 3.0d) * K) + X) * M);

        double powInputValue = 0;
        /** Start */
        if(result > 360) {
            powInputValue = X * Math.sin(result);
        } else {
            /**
             * Changing the value of the parameter passed into the method is a problem.
             * This is a typo example. Instead of typing powInputValue the developer
             * typed in inoutValue. Little bugs like this are often the most difficult
             * to locate.
             */
            /**
            inputValue = K * Math.sin(result); <- typo should be what it is below
             */
            powInputValue = K * Math.sin(result);

        }
        /** End */

        result = Math.pow(result, powInputValue);
        if(result > 360) {
            result = result / inputValue;
        }

        return result;
    }
}
