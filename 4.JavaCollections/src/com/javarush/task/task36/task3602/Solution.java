package com.javarush.task.task36.task3602;

import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;

/* 
Найти класс по описанию

Описание класса:
1. Реализует интерфейс List;
2. Является приватным статическим классом внутри популярного утилитного класса;
3. Доступ по индексу запрещен — кидается исключение IndexOutOfBoundsException.
Используя рефлекшн (метод getDeclaredClasses), верни подходящий тип в методе getExpectedClass.


Требования:
1. Метод getExpectedClass должен использовать метод getDeclaredClasses подходящего утилитного класса.
2. Метод getExpectedClass должен вернуть правильный тип.
3. Метод main должен вызывать метод getExpectedClass.
4. Метод main должен вывести полученный класс на экран.
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

 public static Class getExpectedClass() throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Class[] classes = Collections.class.getDeclaredClasses();
        for (Class c : classes){

            if(Modifier.isPrivate(c.getModifiers()))
                if(Modifier.isStatic(c.getModifiers()))
                {
                if(List.class.isAssignableFrom(c))
                {
                    try{
                        Constructor constructor = c.getDeclaredConstructor();
                        constructor.setAccessible(true);
                        List list = (List) constructor.newInstance();
                        list.get(0);
                    }catch (IndexOutOfBoundsException e){
                        // вернуть класс
                        return c;
                    } catch (NoSuchMethodException e) {
                        //e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        //e.printStackTrace();
                    }
                }

                }
        }
        return null;
    }
}
