package com.assistt.training.advanced.java.streams;

import java.util.Arrays;
import java.util.List;

public class Streams1 {
    public static void main(String[] args) {
        List<String> stringListLoc = Arrays.asList("osman",
                                                   "ali",
                                                   "mehmet",
                                                   "ayşe",
                                                   "fatma",
                                                   "osman",
                                                   "ali",
                                                   "mehmet",
                                                   "ayşe",
                                                   "fatma");
        stringListLoc.forEach(System.out::println);

        for (String stringLoc : stringListLoc) {
            System.out.println(stringLoc);
        }
        System.out.println("---------------");
        stringListLoc.parallelStream()
                     .skip(2)
                     .limit(10)
                     .distinct()
                     .peek(s -> System.out.println("before Filter : " + s + " Thread : " + Thread.currentThread()))
                     .filter(w -> w.length() >= 4)
                     .forEach(System.out::println);
    }
}
