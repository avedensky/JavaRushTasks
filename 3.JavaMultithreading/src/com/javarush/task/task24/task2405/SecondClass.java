package com.javarush.task.task24.task2405;

public class SecondClass implements Action {   //second implementation
    public static String SPECIFIC_ACTION_FOR_ANONYMOUS_SECOND_CLASS_PARAM = "\nSpecific action for anonymous SecondClass, param = ";

    private static String SECOND_CLASS_METHOD_STRING = "class SecondClass, method someAction";

    public SecondClass() {
        Solution.countActionObjects++;
    }
    protected StringBuilder sb = new StringBuilder(SECOND_CLASS_METHOD_STRING);

    public void someAction() {
        System.out.print(sb.toString());
    }
}
