package com.javarush.task.task38.task3801;

/* 
Исправь ошибки в коде

Исключения NameIsEmptyException и NameIsNullException должны быть checked.
Все типы исключений должны быть обработаны.
Реализацию методов main() и getNumberOfCharacters() не менять.


Требования:
1. При возникновении NameIsNullException на экран должна быть выведена строка: "Ошибка: Имя не задано".
2. При возникновении NameIsEmptyException на экран должна быть выведена строка: "Ошибка: Имя пустое".
3. При возникновении любого другого исключения на экран должна быть выведена строка возвращаемая
методом toString этого исключения.
4. Если исключений не было, на экран должна быть выведена строка формата: "Имя содержит X символов",
где X - количество символов в нулевом параметре переданном в метод main.
5. Класс NameIsEmptyException должен быть потомком класса Exception.
6. Класс NameIsNullException должен быть потомком класса Exception.
*/

public class Solution {
    public static void main(String[] args) {
        if (args.length > 0) {
            try {
                System.out.println("Имя содержит " + NameChecker.getNumberOfCharacters(args[0]) + " символов");
            } catch (NameIsNullException e) {
                System.out.println("Ошибка: Имя не задано");
            } catch (NameIsEmptyException e) {
                System.out.println("Ошибка: Имя пустое");
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
}

