package com.javarush.task.task20.task2020;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.logging.Logger;

/* 
Сериализуйте Person

Сериализуй класс Person стандартным способом. При необходимости добавь некоторым полям модификатор transient.


Требования:
1. Класс Person должен поддерживать интерфейс Serializable.
2. Поле fullName должно быть отмечено модификтором transient.
3. Поле greetingString должно быть отмечено модификтором transient.
4. Поле outputStream должно быть отмечено модификтором transient.
5. Поле logger должно быть отмечено модификтором transient.
6. Поле firstName НЕ должно быть отмечено модификтором transient.
7. Поле lastName НЕ должно быть отмечено модификтором transient.
8. Поле country НЕ должно быть отмечено модификтором transient.
9. Поле sex НЕ должно быть отмечено модификтором transient.
*/
public class Solution {

    public static class Person implements Serializable{
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) {

    }
}
