package com.assistt.training.advanced.java.collections;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MapRunner {
    public static void main(String[] args) {
        Map<String, Person> personMapLoc = new HashMap<>();
        Map<String, Person> personMapLoc2 = new ConcurrentHashMap<>(1_200_000,
                                                                    0.9f,
                                                                    1_000);

        Map<String, Person> personMapLoc3 = new ConcurrentHashMap<>(60_000,
                                                                    0.9f,
                                                                    600);
        Map<String, Person> personMapLoc4 = new Hashtable<>();

        Person personLoc = new Person(null,
                                      null,
                                      null);
        personLoc.setName("osman");
        personLoc.setSurname("yay");
        String stringLoc = "sjkdhfkdsf";
        personLoc.setAge(53);

        personMapLoc.put("osman_yay",
                         Person.builder()
                               .withName("osman")
                               .withSurname("yay")
                               .withAge(53)
                               .build());

        personMapLoc.put("osman_test",
                         Person.builder()
                               .withName("osman")
                               .withSurname("test")
                               .withAge(45)
                               .build());

        Collection<Person> valuesLoc = personMapLoc.values();
        for (Person valueLoc : valuesLoc) {
            System.out.println(valueLoc);
        }

        Set<String> stringsLoc = personMapLoc.keySet();
        for (String sLoc : stringsLoc) {
            System.out.println(personMapLoc.get(sLoc));
        }

        Set<Map.Entry<String, Person>> entriesLoc = personMapLoc.entrySet();
        for (Map.Entry<String, Person> entryLoc : entriesLoc) {
            System.out.println("Key : " + entryLoc.getKey() + " " + entryLoc.getValue());
        }
    }
}
