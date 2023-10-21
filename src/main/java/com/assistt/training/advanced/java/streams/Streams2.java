package com.assistt.training.advanced.java.streams;

import com.assistt.training.advanced.java.collections.Person;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams2 {
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
        IntSummaryStatistics intSummaryStatisticsLoc = stringListLoc.parallelStream()
                                                                    .skip(2)
                                                                    .limit(10)
                                                                    .distinct()
                                                                    .map(s -> Person.builder()
                                                                                    .withName(s)
                                                                                    .build())
                                                                    .peek(p -> p.setAge(p.getName()
                                                                                         .length() * 8))
                                                                    .map(Person::getAge)
                                                                    .filter(i -> i > 35)
                                                                    .mapToInt(i -> i - 5)
                                                                    .summaryStatistics();

        System.out.println(intSummaryStatisticsLoc);
//                     .filter(w -> w.length() >= 4)
//                     .forEach(System.out::println);
    }
}
