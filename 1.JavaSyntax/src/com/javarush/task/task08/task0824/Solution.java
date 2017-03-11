package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human child1 = new Human("Яблоко",true, 10,null);
        Human child2 = new Human("Грушка",false, 12,null);
        Human child3 = new Human("Тыква",false, 13,null);
        ArrayList <Human> chlds = new ArrayList<>();
        chlds.add(child1);
        chlds.add(child2);
        chlds.add(child3);

        Human father = new Human("Отец",true, 30,chlds);
        Human mather = new Human("Мать",false, 40,chlds);

        ArrayList <Human> parents1 = new ArrayList<>();
        parents1.add (father);
        //parents1.add (mather);

        ArrayList <Human> parents2 = new ArrayList<>();
        //parents2.add (father);
        parents2.add (mather);

        Human grandfather1 = new Human("Дед 1",true, 70,parents1);
        Human grandfather2 = new Human("Дед 2",true, 65,parents2);
        Human grandmather1 = new Human("Бабушка 1",false, 50,parents1);
        Human grandmather2 = new Human("Бабушка 2",false, 56,parents2);

        System.out.println(grandfather1);
        System.out.println(grandfather2);
        System.out.println(grandmather1);
        System.out.println(grandmather2);
        System.out.println(mather);
        System.out.println(father);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
    }

    public static class Human {
        //напишите тут ваш код
        public String name;
        public boolean sex;
        public int age;
        public ArrayList <Human> children;

        public Human (String name,  boolean sex, int age, ArrayList <Human> children){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;
            if (this.children==null)
                return text;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
