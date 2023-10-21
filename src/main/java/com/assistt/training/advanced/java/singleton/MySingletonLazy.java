package com.assistt.training.advanced.java.singleton;

public class MySingletonLazy {
    private static volatile MySingletonLazy instance;

    private MySingletonLazy() {
    }

    public static MySingletonLazy getInstance() {
        if (instance == null) {
            synchronized (MySingletonLazy.class) {
                if (instance == null) {
                    instance = new MySingletonLazy();
                }
            }
        }
        return instance;
    }

}
