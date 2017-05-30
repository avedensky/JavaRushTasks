package com.javarush.task.task24.task2403;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.server.RemoteObject;
import java.util.ArrayDeque;
import java.util.EventListener;

/* 
Так-с... сопоставим

Исправь ошибки: перемести методы clone в те классы, в которых они должны быть реализованы.
Лишние методы удали.
Не удаляй метод main.


Требования:
1. В классе C должен быть реализован метод clone без параметров.
2. В классе Solution должен существовать метод main.
3. В классе Solution должны существовать 4 вложенных класса.
4. В классе Solution должен существовать 1 метод.
5. Метод clone в классе C должен возвращать объект типа C.
*/
public class Solution {
    public static class A implements Serializable, Cloneable {
        protected A clone() throws CloneNotSupportedException {
            return (A) super.clone();
        }
    }

    public static class B implements Remote, Cloneable {
        protected final B clone() throws CloneNotSupportedException {
            return (B) super.clone();
        }
    }

    public static class C extends ArrayDeque {
        public C clone() {
            return (C) super.clone();
        }
    }

    public static class D implements EventListener, Cloneable {
        protected D clone() throws CloneNotSupportedException {
            return (D) super.clone();
        }
    }

    public static void main(String[] args) {
        try {
            A a = new A();
            System.out.println(a);
            System.out.println(a.clone());
            System.out.println();

            B b = new B();
            System.out.println(b);
            System.out.println(b.clone());
            System.out.println();

            C c = new C();
            System.out.println(c);
            System.out.println(c.clone());
            System.out.println();

            D d = new D();
            System.out.println(d);
            System.out.println(d.clone());

        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
    }
}
