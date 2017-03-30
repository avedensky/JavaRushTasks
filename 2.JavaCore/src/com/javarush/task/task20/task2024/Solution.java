package com.javarush.task.task20.task2024;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/* 
Знакомство с графами

Прочитать в дополнительных материалах о сериализации графов.
Дан ориентированный плоский граф Solution, содержащий циклы и петли.

Пример, http://edu.nstu.ru/courses/saod/images/graph1.gif

Сериализовать Solution.
Все данные должны сохранить порядок следования.


Требования:
1. В классе Solution должно существовать поле edges.
2. В классе Solution должно существовать поле node.
3. Тип поля node должен быть int.
4. Класс Solution должен поддерживать интерфейс Serializable.
*/
public class Solution implements Serializable{
    int node;
    List<Solution> edges = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        /*Solution solution = new Solution();
        ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("fileName"));
        obj.defaultWriteObject();
        obj.close();*/
    }
}
