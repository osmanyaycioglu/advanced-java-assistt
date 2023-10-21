package com.assistt.training.advanced.java.collections;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListRunner {
    private List<String> globalList = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws Exception {
        List<String> stringsLoc = new LinkedList<>();
        for (int i = 0; i < 1_000_000; i++) {
            stringsLoc.add("osman");
        }
        stringsLoc = new LinkedList<>();
        System.gc();
        Thread.sleep(100);
        long         delta      = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            stringsLoc.add("osman");
        }
        System.out.println("Add delta : " + (System.currentTimeMillis() - delta));
        delta      = System.currentTimeMillis();
        for (int i = 0; i < 1_000; i++) {
            stringsLoc.remove(0);
        }
        System.out.println("Remove delta : " + (System.currentTimeMillis() - delta));
        stringsLoc.addAll(Arrays.asList("test1","test2")); // OK
        stringsLoc.contains("test1"); // NOT OK
        stringsLoc.containsAll(Arrays.asList("test1","test2"));// NOT OK
        stringsLoc.retainAll(Arrays.asList("test1","test2")); // OK

        List<String> listLoc = Arrays.asList("test3",
                                             "test4",
                                             "test1",
                                             "test2");
        Collections.sort(listLoc);

        System.out.println(listLoc);

        Collections.sort(listLoc,
                         String::compareTo);


    }

    public void method1() {
        List<String> stringsLoc = new ArrayList<>();
        stringsLoc.add("osman");
    }
}
