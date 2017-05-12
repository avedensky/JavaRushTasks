package com.javarush.task.task23.task2305;

/* 
Inner

Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.


Требования:
1. В классе Solution должен быть реализован метод getTwoSolutions.
2. Метод getTwoSolutions должен быть статическим.
3. Метод getTwoSolutions должен быть публичным.
4. Метод getTwoSolutions должен возвращать массив типа Solution заполненный согласно заданию.
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] res = new Solution[2];

        for (int i=0; i<2; i++) {
            res[i] = new Solution();
            res[i].innerClasses[0] = res [i].new InnerClass();
            res[i].innerClasses[1] = res [i].new InnerClass();
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
