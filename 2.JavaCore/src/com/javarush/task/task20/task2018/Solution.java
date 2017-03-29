package com.javarush.task.task20.task2018;

import java.io.*;

/* 
Найти ошибки

Почему-то при сериализации/десериализации объекта класса B возникают ошибки.

Найди проблему и исправь ее.

Класс A не должен реализовывать интерфейсы Serializable и Externalizable.

В сигнатуре класса В ошибки нет :).

Метод main не участвует в тестировании.


Требования:
1. Класс B должен быть потомком класса A.
2. Класс B должен поддерживать интерфейс Serializable.
3. В классе B должен быть реализован метод writeObject с одним параметром типа ObjectOutputStream.
4. В классе B должен быть реализован метод readObject с одним параметром типа ObjectInputStream.
5. В методе writeObject должен быть вызван метод defaultWriteObject на объекте полученном в качестве параметра.
6. В методе writeObject должен быть вызван метод writeObject(name) на объекте полученном в качестве параметра.
7. В методе readObject должен быть вызван метод defaultReadObject на объекте полученном в качестве параметра.
8. Метод readObject должен корректно восстанавливать значение поля name.
9. Класс A не должен поддерживать интерфейс Serializable.
10. Класс A не должен поддерживать интерфейс Externalizable.
*/
public class Solution {
    public static class A {
        protected String name = "A";

        public A(String name) {
            this.name += name;
        }
    }

    public class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
        }

        private void writeObject(ObjectOutputStream out) throws IOException {
            out.defaultWriteObject();
            out.writeObject(name);

        }
        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            in.defaultReadObject ();
            this.name = (String) in.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(arrayOutputStream);

        Solution solution = new Solution();
        B b = solution.new B("B2");
        System.out.println(b.name);

        oos.writeObject(b);

        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(arrayOutputStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(arrayInputStream);

        B b1 = (B)ois.readObject();
        System.out.println(b1.name);
    }
}
