package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //String motherName = reader.readLine();
        //Cat catMother = new Cat(motherName);

        //String daughterName = reader.readLine();
        //Cat catDaughter = new Cat(daughterName, catMother);

        String grandFatherName = reader.readLine();
        String grandMotherName = reader.readLine();
        String fatherName = reader.readLine();
        String motherName = reader.readLine();
        String sonName = reader.readLine();
        String dauhterName = reader.readLine();
        Cat grandFather = new Cat (grandFatherName,null,null);
        Cat grandMother = new Cat (grandMotherName,null,null);
        Cat father = new Cat (fatherName,null,grandFather);
        Cat mother = new Cat (motherName,grandMother,null);
        Cat son = new Cat (sonName,mother,father);
        Cat dauhter = new Cat (dauhterName,mother,father);

        System.out.println(grandFather);
        System.out.println(grandMother);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(son);
        System.out.println(dauhter);
    }

    public static class Cat {
        private String name;
        private Cat mother;
        private Cat father;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat mother, Cat father) {
            this.name = name;
            this.mother = mother;
            this.father = father;


        }

        @Override
        public String toString() {
            String s="Cat name is " + this.name+",";

            if (this.mother == null)
                s += " no mother,";
            else
                s+= " mother is " + mother.name+",";

            if (this.father == null)
                s += " no father";
            else
                s+= " father is " + father.name;

            return s;
        }
    }

}
