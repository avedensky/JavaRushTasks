package com.javarush.task.task39.task3908;

/* 
Возможен ли палиндром?

Реализуй метод isPalindromePermutation(String s) который будет возвращать true, если из
всех символов строки s можно составить палиндром. Иначе — false.

Символы в анализируемой строке ограничены кодировкой ASCII.
Регистр букв не учитывается.


Требования:
1. Метод isPalindromePermutation должен возвращать true, если выполнив перестановку символов
входящей строки можно получить палиндром.
2. Метод isPalindromePermutation должен возвращать false, если выполнив перестановку символов
входящей строки получить палиндром невозможно.
3. Метод isPalindromePermutation должен быть публичным.
4. Метод isPalindromePermutation должен быть статическим.
*/

//Thanks hakimsd9
//https://github.com/11601/CCAssignment/blob/0685fa7ce761fe292cd8ecc618f30f9e41fe0a6c/ch1/Solution04.java
//Here is original
public class Solution {
    public static void main(String[] args) {

    }

    public static boolean isPalindromePermutation(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        // Lower case the String and remove white spaces
        s = s.toLowerCase();
        s = s.replaceAll(" ", "");

        // Assume 8-bit ascii encoding
        boolean[] isOdd = new boolean[256];

        // For each character c in the input String, save whether it is
        // represented an odd number of times
        for (int i = 0; i < s.length(); i++) {
            isOdd[s.charAt(i)] = !isOdd[s.charAt(i)];
        }

        // Count the number of odd characters
        int numberOdds = 0;

        for (int i = 0; i < isOdd.length; i++) {
            if (isOdd[i]) {
                numberOdds++;
            }
            // At most one character can have an odd count
            if (numberOdds > 1) {
                return false;
            }
        }
        return true;
    }
}
