package com.assistt.training.advanced.java.lambdas;

public class FunctionalRunner {
    public static void main(String[] args) {
        String   prefix     = "pref : ";
        IExecute executeLoc = new ExecuteImpl();
        System.out.println(executeLoc.execute("test",
                                              10));

        IExecute executeLoc1 = new IExecute() {
            @Override
            public String execute(final String stringParam,
                                  final Integer intValIntegerParam) {
                return prefix + " " + stringParam + "-" + intValIntegerParam;
            }
        };

        System.out.println(executeLoc1.execute("test",
                                               10));

        IExecute executeLoc2 = (w, p) -> prefix + " " + w + "-" + p;

        System.out.println(executeLoc2.execute("test lambda",
                                               10));

        IExecute executeLoc3 = (w, p) -> {
            System.out.println("multi line");
            return prefix + " " + w + "-" + p;
        };

        IExecute            executeLoc4 = FunctionalRunner::xyz;

        FunctionalRunner f           = new FunctionalRunner();
        IExecute            executeLoc5 = f::abc;
    }

    public String abc(String a,
                      Integer b) {
        return a + "-" + b;
    }


    public static String xyz(String a,
                             Integer b) {
        return a + "-" + b;
    }
}
