package com.assistt.training.advanced.java.singleton;

public class MySingletonEager {
    private static MySingletonEager instance = new MySingletonEager();

    private MySingletonEager() {
    }

    public static MySingletonEager getInstance(){
        return instance;
    }

}
