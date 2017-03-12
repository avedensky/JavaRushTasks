package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Looser, Coder and Proger

1. Ввести [в цикле] с клавиатуры несколько строк (ключей).
Строки(ключи) могут быть такими: «user«, «loser«, «coder«, «proger«.
Ввод окончен, когда строка не совпадает ни с одной из выше указанных.

2. Для каждой введенной строки нужно:
2.1. Создать соответствующий объект [см. Person.java], например, для строки «user» нужно создать объект класса User.
2.2. Передать этот объект в метод doWork.

3. Написать реализацию метода doWork, который:
3.1. Вызывает метод live() у переданного обекта, если этот объект (person) имеет тип User.
3.2. Вызывает метод doNothing(), если person имеет тип Loser.
3.3. Вызывает метод coding(), если person имеет тип Coder.
3.4. Вызывает метод enjoy(), если person имеет тип Proger.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        //тут цикл по чтению ключей, пункт 1
        String s;
        while (true)
        {
            s = reader.readLine();
            //создаем объект, пункт 2
            if (s.equals("user")) {
                person = new Person.User();
                doWork(person); //вызываем doWork
                continue;
            }

            if (s.equals("loser")) {
                person = new Person.Loser();
                doWork(person); //вызываем doWork
                continue;
            }

            if (s.equals("coder")) {
                person = new Person.Coder();
                doWork(person); //вызываем doWork
                continue;
            }

            if (s.equals("proger")) {
                person = new Person.Proger();
                doWork(person); //вызываем doWork
                continue;
            }

            break; // User input other string, break.
        }
    }

    public static void doWork(Person person) {
        // пункт 3
        if (person instanceof Person.User) {
            ((Person.User) person).live();
            return;
        }

        if (person instanceof Person.Loser) {
            ((Person.Loser) person).doNothing();
            return;
        }

        if (person instanceof Person.Coder) {
            ((Person.Coder) person).coding();
            return;
        }

        if (person instanceof Person.Proger) {
            ((Person.Proger) person).enjoy();
            return;
        }
    }
}
