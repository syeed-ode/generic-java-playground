package com.syeedode.hardcorejava.a_02_22_a_method_with_traces;

import org.apache.log4j.Logger;

public class ConditionalCompile {

    private static final Logger LOGGER = Logger.getLogger(ConditionalCompile.class);

    public static void someMethod() {
        LOGGER.debug("Set up complete, beginning phases.");

        LOGGER.debug("phase1 complete");

        LOGGER.debug("phase2 complete");
        LOGGER.debug("phase3 complete");
        LOGGER.debug("phase4 complete");
        LOGGER.debug("All phases completed successfully");
    }
}
