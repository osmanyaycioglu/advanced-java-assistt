package com.assistt.training.advanced.java.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Streams4 {
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
        stringListLoc.stream()
                     .distinct()
                     .filter(w -> w.length() >= 4)
                     .flatMap(Streams4::stringToCharacterStream )
                     .distinct()
                     .sorted()
                     .forEach(c -> System.out.println(c));
    }

    public static Stream<Character> stringToCharacterStream(String s){
        List<Character> charactersLoc = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            charactersLoc.add(s.charAt(i));
        }
        return charactersLoc.stream();
    }
}
