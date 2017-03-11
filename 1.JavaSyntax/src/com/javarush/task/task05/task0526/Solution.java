package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Man man1 = new Man ("Alex1", 40, "Profa");
        Man man2 = new Man ("Alex2", 40, "Profa");

        Woman woman1 = new Woman ("Ira1", 40, "Profa");
        Woman woman2 = new Woman ("Ira2", 40, "Profa");

        //name + » » + age + » « + address
        System.out.println(man1.name + " " + man1.age + " " + man1.address);
        System.out.println(man2.name + " " + man2.age + " " + man2.address);
        System.out.println(woman1.name + " " + woman1.age + " " + woman1.address);
        System.out.println(woman2.name + " " + woman2.age + " " + woman2.address);
    }

    //напишите тут ваш код
    public static class Man {
        public String name;
        public int age;
        public String address;

        Man (String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }

    public static class Woman {
        public String name;
        public int age;
        public String address;

        Woman (String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }


}
