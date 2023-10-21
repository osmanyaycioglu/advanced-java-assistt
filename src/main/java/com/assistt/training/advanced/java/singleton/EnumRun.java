package com.assistt.training.advanced.java.singleton;

public class EnumRun {
    public static void main(String[] args) {
        MyOtherSingletonEager.INSTANCE1.hello();
        MyOtherSingletonEager.INSTANCE2.hello();
        MyOtherSingletonEager.INSTANCE3.hello();


    }
}
