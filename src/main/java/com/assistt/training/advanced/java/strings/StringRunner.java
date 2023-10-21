package com.assistt.training.advanced.java.strings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

public class StringRunner {
    private static final Logger logger = LoggerFactory.getLogger(StringRunner.class);

    public static void main(String[] args) {
        String stringLoc = "osman";

        if (stringLoc == new String("osman")) {
            System.out.println("eşit");
        }

        String concatLoc = stringLoc.concat(" yaycıoğlu");
        System.out.println(concatLoc);

        String stringLoc1 = "osman" + stringLoc + " " + concatLoc;
        stringLoc1 += " ";

        for (int i = 0; i < 10; i++) {
            stringLoc1 += " " + i;
        }

        StringBuilder builderLoc = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            builderLoc.append(" ")
                      .append(i);
        }
        System.out.println(builderLoc);
        if (logger.isDebugEnabled()) {
            logger.debug("My log " + stringLoc1);
        }

        logger.debug("My Log {}",
                     stringLoc1);
        test(() -> "My log " + builderLoc,
             false);
    }

    public static void test(Supplier<String> str,
                            boolean b1) {
        if (b1) {
            System.out.println(str.get());
        }
    }
}
