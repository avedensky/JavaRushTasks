package com.javarush.task.task35.task3501;
/* 
Вызов статического метода

Измени статический метод в классе GenericStatic так, чтобы он стал дженериком.
Пример вызова дан в методе main.


Требования:
1. Метод someStaticMethod в классе GenericStatic должен быть изменен в соответствии с условием задачи.
2. Метод someStaticMethod должен быть статическим.
3. Метод someStaticMethod должен быть публичным.
4. Метод someStaticMethod должен выводить данные на экран.
*/
public class Solution {
    public static void main(String[] args) {
        Number number = GenericStatic.<Number>someStaticMethod(new Integer(3));
    }
}
