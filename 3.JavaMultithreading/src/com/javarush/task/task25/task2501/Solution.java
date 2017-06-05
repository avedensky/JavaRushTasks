package com.javarush.task.task25.task2501;

/* 
Новые возможности!
Используя возможности enum-а реализуй метод getLetterPosition, который должен возвращать позицию буквы.
Позиция буквы A — 1.


Требования:
1. Класс Solution должен содержать enum Alphabet.
2. Alphabet должен содержать по порядку 26 букв английского алфавита.
3. Метод getLetterPosition у класса Alphabet должен возвращать позицию буквы в алфавите.
4. Метод getLetterPosition должен вызывать метод ordinal.
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(Alphabet.G.getLetterPosition());
    }

    public enum Alphabet {
        A, B, C, D, E,
        F, G, H, I, J,
        K, L, M, N, O,
        P, Q, R, S, T,
        U, V, W, X, Y, Z;

        int getLetterPosition() {

            return ordinal()+1;
        }
    }
}
