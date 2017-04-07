package com.javarush.task.task34.task3402;

/* 
Факториал с помощью рекурсии

Почитай про вычисление факториала.
Реализуй рекурсивную логику метода factorial, где n — это число, факториал которого нужно вычислить.
Не создавай в классе Solution дополнительные поля.


Требования:
1. В классе Solution не должны быть созданы дополнительные поля.
2. Метод factorial должен возвращать факториал числа принятого в качестве параметра.
3. Метод factorial не должен быть статическим.
4. Метод factorial должен быть рекурсивным.
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.factorial(9));     //362880
        System.out.println(solution.factorial(0));     //1
        System.out.println(solution.factorial(1));     //1
    }

    public int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }
}
