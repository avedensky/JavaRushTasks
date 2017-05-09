package com.javarush.task.task39.task3912;

/* 
Максимальная площадь

Реализуй метод int maxSquare(int[][] matrix), возвращающий площадь самого большого квадрата состоящего из единиц
в двумерном массиве matrix.
Массив matrix заполнен только нулями и единицами.


Требования:
1. Метод maxSquare должен быть реализован в соответствии с условием задачи.
2. Метод maxSquare должен эффективно работать с большими массивами.
3. Метод maxSquare должен быть публичным.
4. Метод maxSquare должен возвращать число типа int.
5. Метод maxSquare должен быть статическим.
*/

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = new int[][]
                {
                        {1, 1, 1, 1},
                        {1, 0, 0, 1},
                        {1, 0, 1, 1},
                        {1, 1, 1, 1}
                };
        Solution solution = new Solution();
        System.out.println(solution.maxSquare(matrix));
    }

    public static int maxSquare(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int side = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i * j == 0)
                    continue;
                if (matrix[i][j] == 1)
                    matrix[i][j] = Math.min(matrix[i][j - 1], Math.min(matrix[i - 1][j], matrix[i - 1][j - 1])) + 1;

                if (matrix[i][j] > side)
                    side = matrix[i][j];
            }
        }

        return side * side;
    }
}
