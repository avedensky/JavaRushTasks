package com.javarush.task.task12.task1217;

/* 
Интерфейсы Fly, Run, Swim
Напиши public интерфейсы Fly(летать), Run(бежать/ездить), Swim(плавать).
Добавить в каждый интерфейс по одному методу.
*/

public class Solution {
    public static void main(String[] args) {

    }

//add interfaces here - добавь интерфейсы тут
    public interface Fly {
        int left ();

}

    public interface Run {
        int quick ();

    }

    public interface Swim  {
        int up ();

    }

}
