package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private String firstName;
        private String secondName;
        private int age;
        private char sex;
        private short yearOfBirth;
        private short monthOfBirth;

        public Human () {
            this.firstName = "";
            this.secondName = "";
            this.age = 0;
            this.sex = 'M';
            this.yearOfBirth = 1970;
            this.monthOfBirth = 1;
        }

        public Human (Human hm) {
            this.firstName = hm.firstName;
            this.secondName = hm.secondName;
            this.age = hm.age;
            this.sex = hm.sex;
            this.yearOfBirth = hm.yearOfBirth;
            this.monthOfBirth = hm.monthOfBirth;

        }

        public Human (Human hm, String firstName) {
            this.firstName = firstName;
            this.secondName = hm.secondName;
            this.age = hm.age;
            this.sex = hm.sex;
            this.yearOfBirth = hm.yearOfBirth;
            this.monthOfBirth = hm.monthOfBirth;

        }

        public Human (Human hm, String firstName, String secondName) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.age = hm.age;
            this.sex = hm.sex;
            this.yearOfBirth = hm.yearOfBirth;
            this.monthOfBirth = hm.monthOfBirth;

        }



        public Human (String firstName) {
            this.firstName = firstName;
            this.secondName = "";
            this.age = 0;
            this.sex = 'M';
            this.yearOfBirth = 1970;
            this.monthOfBirth = 1;
        }

        public Human (String firstName, String secondName ) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.age = 0;
            this.sex = 'M';
            this.yearOfBirth = 0;
            this.monthOfBirth = 0;
        }

        public Human (String firstName, String secondName, int age) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.age = age;
            this.sex = 'M';
            this.yearOfBirth = 0;
            this.monthOfBirth = 0;
        }

        public Human (String firstName, String secondName, int age, char sex) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.age = age;
            this.sex = sex;
            this.yearOfBirth = 0;
            this.monthOfBirth = 0;
        }

        public Human (String firstName, String secondName, int age, char sex, short yearOfBirth) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.age = age;
            this.sex = sex;
            this.yearOfBirth = yearOfBirth;
            this.monthOfBirth = 0;
        }

        public Human (String firstName, String secondName, int age, char sex, short yearOfBirth, short monthOfBirth) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.age = age;
            this.sex = sex;
            this.yearOfBirth = yearOfBirth;
            this.monthOfBirth = monthOfBirth;
        }

    }
}
