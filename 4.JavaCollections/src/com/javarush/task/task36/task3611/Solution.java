package com.javarush.task.task36.task3611;

import java.util.HashSet;
import java.util.Set;

/* 
Сколько у человека потенциальных друзей?

Сегодня рассмотрим часть функционала социальных сетей. Откуда сеть знает, каких людей предлагать тебе в друзья,
которых ты можешь знать? Эту задачу легко решить с помощью графов.

Твоя задача реализовать метод Set<Integer> getAllFriendsAndPotentialFriends(int index, int deep), который возвращает
индексы людей, которые у тебя в друзьях уже есть и которых ты можешь знать. После этого отработает
метод removeFriendsFromSet, и результат этого метода — это все потенциальные друзья
человека с индексом index и глубиной поиска deep.
Для упрощения будем рассматривать связи всех людей как двумерный массив humansRelationships (смотри пример массива
в методе generateRelationships). По главной диагонали все элементы true, так как это один и тот же человек.
Пересечение столбца и столбика указывает, добавлены ли люди друг у друга в друзья (если true — то люди есть друг
у друга в друзьях). Если человек с индексом k добавлен в друзья к человеку с индексом p, это означает,
что у человека с индексом p в друзьях есть человек с индексом k.

В метод передается два аргумента:
int index — это индекс человека в массиве (начиная с нуля);
int deep — глубина поиска друзей. Если Маша в друзьях у Наташи и у Маши в друзьях есть Оля, при глубине поиска = 1,
для Наташи нужно добавить в результирующее множество Машу и как потенциального друга Олю. Если глубина поиска = 2,
в это же множество нужно добавить еще и всех, с кем дружит Оля.
Смотри пример в методе main.
В множестве, которое возвращает метод getAllFriendsAndPotentialFriends не должно быть индекса index.


Требования:
1. В классе Solution должен существовать публичный метод Set getAllFriendsAndPotentialFriends(int index, int deep).
2. В классе Solution должно быть объявлено приватное поле boolean[][] humansRelationships.
3. В множестве, которое возвращает метод getAllFriendsAndPotentialFriends не должно быть индекса index.
4. Метод getAllFriendsAndPotentialFriends должен быть реализован согласно условию.
*/

public class Solution {
    private boolean[][] humansRelationships;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.humansRelationships = generateRelationships();

        Set<Integer> allFriendsAndPotentialFriends = solution.getAllFriendsAndPotentialFriends(4, 2);
        System.out.println(allFriendsAndPotentialFriends);                              //expected: [0, 1, 2, 3, 5, 7]
        Set<Integer> potentialFriends = solution.removeFriendsFromSet(allFriendsAndPotentialFriends, 4);
        System.out.println(potentialFriends);                                           //expected: [2, 5, 7]
    }

    public Set<Integer> getAllFriendsAndPotentialFriends(int index, int deep) {
        //напишите тут ваш код
        Set<Integer> result = new HashSet<>();
        if (deep == 0) return result;
        for (int i = 0; i < humansRelationships.length; i++) {
            if (i < index) {
                if (humansRelationships[index][i]) {
                    result.add(i);
                    result.addAll(getAllFriendsAndPotentialFriends(i, deep - 1));
                }
            } else {
                if (humansRelationships[i][index]) {
                    result.add(i);
                    result.addAll(getAllFriendsAndPotentialFriends(i, deep - 1));
                }
            }
        }
        result.remove(index);
        return result;
    }

    //remove people from set, with which you have already had relationship
    public Set<Integer> removeFriendsFromSet(Set<Integer> set, int index) {
        for (int i = 0; i < humansRelationships.length; i++) {
            if ((i < index) && (index < humansRelationships.length) && humansRelationships[index][i]) {
                set.remove(i);
            } else if ((i > index) && humansRelationships[i][index]) {
                set.remove(i);
            }
        }
        return set;
    }

    //return test data
    private static boolean[][] generateRelationships() {
        return new boolean[][]{
                {true},                                                                 //0
                {true, true},                                                           //1
                {false, true, true},                                                    //2
                {false, false, false, true},                                            //3
                {true, true, false, true, true},                                        //4
                {true, false, true, false, false, true},                                //5
                {false, false, false, false, false, true, true},                        //6
                {false, false, false, true, false, false, false, true}                  //7
        };
    }
}