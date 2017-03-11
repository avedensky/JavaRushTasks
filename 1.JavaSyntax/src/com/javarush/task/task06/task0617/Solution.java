package com.javarush.task.task06.task0617;

/* 
Блокнот для новых идей
*/

public class Solution {
    public static void main(String[] args) {
        printIdea(new Idea());
    }

    public static void printIdea (Idea ideya) {
        System.out.println(ideya.getDescription());
    }

    //напишите тут ваш код
    public static class Idea {
        public String getDescription() {
            return "alex";
        }
    }
}
