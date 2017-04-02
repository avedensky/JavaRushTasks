package com.javarush.task.task32.task3205;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Alexey Vedensky on 02.04.2017.
 * MAIL: avedensky@gmail.com
 */
public class CustomInvocationHandler implements InvocationHandler {
    private SomeInterfaceWithMethods obj;

    public CustomInvocationHandler(SomeInterfaceWithMethods obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + " in");
        Object result = method.invoke(obj, args);
        System.out.println(method.getName() + " out");
        return result;
    }
}
