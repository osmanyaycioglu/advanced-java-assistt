package com.assistt.training.advanced.java.singleton;

public enum MyOtherSingletonEager {

    INSTANCE1("i1") {
        @Override
        public void hello() {
            System.out.println("hello from instance 1");
        }
    },
    INSTANCE2("i2"),
    INSTANCE3("i3");


    private String prefix;

    MyOtherSingletonEager(final String prefixParam) {
        prefix = prefixParam;
    }

    public void hello() {
        System.out.println(prefix + " Hello Root");
    }


}
