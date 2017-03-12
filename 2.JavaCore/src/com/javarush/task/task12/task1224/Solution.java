package com.javarush.task.task12.task1224;

/* 
Что это? «Кот», «Тигр», «Лев», «Бык», «хз»
Напиши метод, который определяет, какой объект передали в него.
Программа должна выводить на экран одну из надписей:
«Кот», «Тигр», «Лев», «Бык», «хз».
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Pig()));
    }

    public static String getObjectType(Object o) {
        //напишите тут ваш код
        String s="хз";

        if (o instanceof Cat)
            s = "Кот";

        if (o instanceof Tiger)
            s = "Тигр";

        if (o instanceof Lion)
            s = "Лев";

        if (o instanceof Bull)
            s = "Бык";

//        if (o instanceof Pig)
//            s = "Pig";

        return s;
    }

    public static class Cat {
    }

    public static class Tiger {
    }

    public static class Lion {
    }

    public static class Bull {
    }

    public static class Pig {
    }
}
