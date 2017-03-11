package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код

        Human grandfather1 = new Human ("Bob",true,70);
        Human grandfather2 = new Human ("Bobik",true,80);
        Human grandmother1 = new Human ("Alisa",false,60);
        Human grandmother2 = new Human ("Sharik",false,50);

        Human mother = new Human ("Elka",false,20, grandfather1, grandmother1);
        Human father = new Human ("Hren",true,30, grandfather2, grandmother2);

        Human child1 = new Human ("Redka",false,2, mother, father);
        Human child2 = new Human ("Morkovka",true,3, mother, father);
        Human child3 = new Human ("Repka",false,4, mother, father);

        System.out.println(grandfather1);
        System.out.println(grandfather2);
        System.out.println(grandmother1);
        System.out.println(grandmother2);
        System.out.println(mother);
        System.out.println(father);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human (String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = null;
            this.mother = null;
        }

        public Human (String name, boolean sex, int age,  Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















