package com.javarush.task.task14.task1403;

/* 
Building и School

1. Расставь правильно наследование между Building(здание) и School(здание школы).
2. Подумай, объект какого класса должны возвращать методы getSchool и getBuilding.
3. Измени null на объект класса Building или School.
*/

public class Solution {
    public static void main(String[] args) {
        Building school = getSchool();
        Building shop = getBuilding();

        System.out.println(school);
        System.out.println(shop);
    }

    public static Building getSchool() {
        //измените null на объект класса Building или School
        return new School();
    }

    public static Building getBuilding() {
        //измените null на объект класса Building или School
        return new Building();
    }

    static class School extends Building/*Добавьте сюда ваш код*/ {
        @Override
        public String toString() {
            return "School";
        }
    }

    static class Building /*Добавьте сюда ваш код*/ {
        @Override
        public String toString() {
            return "Building";
        }
    }
}
