package com.javarush.task.task21.task2102;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* 
Сравниваем модификаторы

Реализовать логику метода isAllModifiersContainSpecificModifier, который проверяет, содержит ли переданный параметр
allModifiers значение конкретного модификатора specificModifier.

P.S. Перед выполнением задания ознакомься с классом Modifier и реализацией методов isPublic, isStatic и т.п.


Требования:
1. Метод isAllModifiersContainSpecificModifier должен быть статическим.
2. Метод isAllModifiersContainSpecificModifier должен возвращать значение типа boolean.
3. Метод isAllModifiersContainSpecificModifier должен принимать два параметра типа int.
4. Метод isAllModifiersContainSpecificModifier должен возвращать корректное значение в соответствии с условием
задачи(true, если заданный модификатор присутствует в allModifiers, иначе false).
*/
public class Solution {
    public static void main(String[] args) {
        int modifiersOfThisClass = Solution.class.getModifiers();
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.PUBLIC));   //true
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.STATIC));   //false

        int modifiersOfMethod = getMainMethod().getModifiers();
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfMethod, Modifier.STATIC));      //true
    }

    public static boolean isAllModifiersContainSpecificModifier(int allModifiers, int specificModifier) {
        if (Modifier.isAbstract(allModifiers) && Modifier.isAbstract(specificModifier))
            return true;

        if (Modifier.isFinal(allModifiers) && Modifier.isFinal(specificModifier))
            return true;

        if (Modifier.isInterface(allModifiers) && Modifier.isInterface(specificModifier))
            return true;

        if (Modifier.isNative(allModifiers) && Modifier.isNative(specificModifier))
            return true;

        if (Modifier.isPrivate(allModifiers) && Modifier.isPrivate(specificModifier))
            return true;

        if (Modifier.isProtected(allModifiers) && Modifier.isProtected(specificModifier))
            return true;

        if (Modifier.isPublic(allModifiers) && Modifier.isPublic(specificModifier))
            return true;

        if (Modifier.isStatic(allModifiers) && Modifier.isStatic(specificModifier))
            return true;

        if (Modifier.isStrict(allModifiers) && Modifier.isStrict(specificModifier))
            return true;

        if (Modifier.isSynchronized(allModifiers) && Modifier.isSynchronized(specificModifier))
            return true;

        if (Modifier.isTransient(allModifiers) && Modifier.isTransient(specificModifier))
            return true;

        if (Modifier.isVolatile(allModifiers) && Modifier.isVolatile(specificModifier))
            return true;

        if (Modifier.isVolatile(allModifiers) && Modifier.isVolatile(specificModifier))
            return true;

        return false;
    }

    private static Method getMainMethod() {
        Method[] methods = Solution.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("main")) return method;
        }

        return null;
    }
}
