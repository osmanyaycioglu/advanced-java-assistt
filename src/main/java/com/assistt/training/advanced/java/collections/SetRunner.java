package com.assistt.training.advanced.java.collections;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class SetRunner {
    public static void main(String[] args) {

        Set<String> stringsLoc = new HashSet<>();
        stringsLoc.add("1");
        stringsLoc.add("2");
        stringsLoc.add("3");
        stringsLoc.add("4");
        stringsLoc.add("5");
        stringsLoc.add("6");
        Set<String> stringsLoc2 = new HashSet<>();
        stringsLoc2.add("4");
        stringsLoc2.add("5");
        stringsLoc2.add("6");
        stringsLoc2.add("7");
        stringsLoc2.add("8");
        stringsLoc2.add("9");
        System.out.println(stringsLoc2);
        System.out.println("----------------------");
        stringsLoc.retainAll(stringsLoc2);
        System.out.println(stringsLoc);
    }
}
