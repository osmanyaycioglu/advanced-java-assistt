package com.assistt.training.advanced.java.streams;

import com.assistt.training.advanced.java.collections.Person;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Streams3 {
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
        List<String> collectLoc = stringListLoc.stream()
                                               .distinct()
                                               .filter(w -> w.length() >= 4)
                                               .collect(Collectors.toList());
        Map<String, Person> collectLoc1 = stringListLoc.stream()
                                                       .distinct()
                                                       .filter(w -> w.length() >= 4)
                                                       .collect(Collectors.toMap(s -> s,
                                                                                 s -> Person.builder()
                                                                                            .withName(s)
                                                                                            .build()));

        stringListLoc.stream()
                     .distinct()
                     .filter(w -> w.length() >= 4)
                     .collect(Collectors.joining(" "));

        ArrayList<String> reduceLoc = stringListLoc.stream()
                                                   .distinct()
                                                   .filter(w -> w.length() >= 4)
                                                   .reduce(new ArrayList<String>(),
                                                           (a, s) -> {
                                                               a.add(s);
                                                               return a;
                                                           },
                                                           (a1, a2) -> {
                                                               a1.addAll(a2);
                                                               return a1;
                                                           });

        Integer reduceLoc1 = stringListLoc.stream()
                                          .distinct()
                                          .filter(w -> w.length() >= 4)
                                          .reduce(0,
                                                  (i, s) -> i + s.length(),
                                                  (i1, i2) -> i1 + i2);

        stringListLoc.stream()
                     .distinct()
                     .filter(w -> w.length() >= 4)
                     .reduce("",
                             (s1, s2) -> s1.concat(s2),
                             (s1, s2) -> s1.concat(s2));

        List<String> collectLoc2 = stringListLoc.stream()
                                                .distinct()
                                                .filter(w -> w.length() >= 4)
                                                .collect(new Collector<String, List<String>, List<String>>() {
                                                    @Override
                                                    public Supplier<List<String>> supplier() {
                                                        return () -> new ArrayList<String>();
                                                    }

                                                    @Override
                                                    public BiConsumer<List<String>, String> accumulator() {
                                                        return (l, s) ->
                                                                l.add(s);
                                                    }

                                                    @Override
                                                    public BinaryOperator<List<String>> combiner() {
                                                        return (l1, l2) -> {
                                                            l1.addAll(l2);
                                                            return l1;
                                                        };
                                                    }

                                                    @Override
                                                    public Function<List<String>, List<String>> finisher() {
                                                        return l -> {
                                                            l.add("deneme");
                                                            return l;
                                                        };
                                                    }

                                                    @Override
                                                    public Set<Characteristics> characteristics() {
                                                        return Collections.emptySet();
                                                    }
                                                });
        System.out.println("-----------------");
        System.out.println(collectLoc2);


    }
}
