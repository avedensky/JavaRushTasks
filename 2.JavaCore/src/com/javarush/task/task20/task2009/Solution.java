package com.javarush.task.task20.task2009;

import java.io.*;

/*
Как сериализовать static?

Сделай так, чтобы сериализация класса ClassWithStatic была возможной.
*/
public class Solution {
    public static class ClassWithStatic implements Serializable {
        public static String staticString = "it's test static string";
        public int i;
        public int j;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String fileName = "e:\\6.txt";
        ClassWithStatic cws = new ClassWithStatic();
        cws.i = 10;
        cws.j = 20;

        ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(fileName));

        writer.writeObject(cws);

        ObjectInputStream reader = new ObjectInputStream(new FileInputStream(fileName));
        ClassWithStatic cws2 = (ClassWithStatic) reader.readObject();

        System.out.printf("i="+cws2.i+" "+cws2.j+" "+cws2.staticString);
    }
}
