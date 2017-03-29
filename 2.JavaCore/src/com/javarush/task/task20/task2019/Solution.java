package com.javarush.task.task20.task2019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Исправить ошибку. Сериализация

После десериализации объекта класса Solution обнаружили, что данных в словаре [m] нет :(

Исправить 1 ошибку.


Требования:
1. В классе Solution не должно быть метода void Solution без параметров.
2. В классе Solution должен существовать конструктор без параметров.
3. В классе Solution должен существовать метод size без параметров.
4. В классе Solution метод size должен возвращать значение типа int.

*/


public class Solution implements Serializable {

    public static void main(String args[]) throws Exception {
        FileOutputStream fileOutput = new FileOutputStream("e:\\5.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

        Solution solution = new Solution();
        outputStream.writeObject(solution);

        fileOutput.close();
        outputStream.close();

        //loading
        FileInputStream fiStream = new FileInputStream("e:\\5.txt");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);

        Solution loadedObject = (Solution) objectStream.readObject();

        fiStream.close();
        objectStream.close();

        //Attention!!
        System.out.println(loadedObject.size());
    }

    private Map<String, String> m = new HashMap<>();

    public Map<String, String> getMap() {
        return m;
    }

    public Solution() { //Было: public void Solution() т.е. был объявлен метод, а не коструктор, и который никто и не вызывал..
        m.put("Mickey", "Mouse");
        m.put("Mickey", "Mantle");
    }

    public int size() {
        return m.size();
    }
}
