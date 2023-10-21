package com.assistt.training.advanced.java.lambdas;

import java.util.function.*;

public class JavaInterfaces {
    public static void main(String[] args) {
        Supplier<Integer>         s1 = () -> 10;
        Consumer<String>          c1 = q -> System.out.println("pref : " + q);
        BiConsumer<String,Integer> bc1 = (a1,b1)-> System.out.println(a1 + " " +b1);
        Function<String, Integer> f1 = s -> Integer.parseInt(s);
        Predicate<String>         p1 = s -> s.length() > 5;
    }
}
