package com.javarush.task.task13.task1327;

import java.util.ArrayList;
import java.util.List;

/* 
Репка
*/

public class Solution {
    public static void main(String[] args) {
        List<Person> plot = new ArrayList<Person>();
        plot.add(new Person("Репка", "Репку"));
        plot.add(new Person("Дедка", "Дедку"));
        plot.add(new Person("Бабка", "Бабку"));
        plot.add(new Person("Внучка", "Внучку"));
        RepkaStory.tell(plot);
    }

//    interface RepkaItem {
//        void pull(Person person);
//    }
//
//    public static class Person implements RepkaItem {
//        public String name = "";
//        public String namePadezh = "";
//
//        public Person (String name, String namePadezh) {
//            this.name = name;
//            this.namePadezh = namePadezh;
//        }
//
//        @Override
//        public void pull(Person person) {
//            System.out.println(name+" за "+ person.name);
//
//        }
//    }
}
