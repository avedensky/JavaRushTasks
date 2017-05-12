package com.javarush.task.task23.task2310;

/* 
Напряги извилины!

Метод printName должен выводить свое собственное имя, т.е. «sout»
Сделайте минимум изменений.


Требования:
1. Вывод на экран должен соответствовать условию.
2. В классе Solution должен присутствовать метод sout без параметров.
3. В классе Solution должно присутствовать поле name.
4. Модификатор доступа метода getName должен быть расширен.
*/
public class Solution {
    private String name;

    Solution(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void sout() {
        new Solution("sout") {
            void printName() {
                System.out.println(getName());//А если без расширения метода? то: super.getName() !!!
            }
        }.printName();
    }

    public static void main(String[] args) {
        new Solution("main").sout();
    }
}
