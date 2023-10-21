package com.assistt.training.advanced.java.lambdas;

public class ExecuteImpl implements IExecute{
    @Override
    public String execute(final String stringParam,
                          final Integer intValIntegerParam) {
        return stringParam + "-" + intValIntegerParam;
    }
}
