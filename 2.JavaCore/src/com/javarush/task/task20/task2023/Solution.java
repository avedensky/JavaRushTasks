package com.javarush.task.task20.task2023;

/* 
Правильный вывод

Расставить обращение к методам суперкласса и модификаторы доступа так, чтобы вывод на экран был следующим:

C class, method2
A class, method2
A class, method1
B class, method1

1. Из одного метода можно вызвать только один метод суперкласса.
2. Из одного метода можно вызвать только один метод класса.
3. Можно менять модификаторы доступа к методам.


Требования:
1. Вывод на экран должен соответствовать условию задачи.
2. Метод method1 должен быть объявлен с модификатором доступа private в классе A.
3. Метод method1 в классе B должен содержать вызов super.method2().
4. Метод method2 в классе С должен содержать вызов super.method1().
5. Метод method2 в классе A должен содержать вызов method1().
*/
public class Solution {
    public static void main(String[] s) {
        A a = new C();
        a.method2();
    }

    public static class A {
        private void method1() {
            System.out.println("A class, method1");//5
        }

        public void method2() {
            System.out.println("A class, method2");//3
            method1();//4
        }
    }

    public static class B extends A {
        public void method1() {
            super.method2();//2
            System.out.println("B class, method1");//6

        }

        public void method2() { //не используется
            System.out.println("B class, method2");
        }
    }

    private static class C extends B {
        public void method1() {
            System.out.println("C class, method1");
        }

        public void method2() {
            System.out.println("C class, method2");//0
            super.method1();//1

        }
    }
}
