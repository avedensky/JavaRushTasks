package com.javarush.task.task24.task2408;

import java.util.List;

/* 
Как избежать Copy+Paste

В классе Dog реализуй логику метода toSayable, которая описана в джавадоке.


Требования:
1. В классе Dog должен быть реализован публичный метод toSayable с одним параметром типа int.
2. Метод toSayable должен возвращать объект типа Sayable.
3. Объект возвращаемый методом toSayable должен быть потомком класса SuperDog.
4. В случае, если параметр переданный в метод toSayable меньше 1, метод say должен вернуть строку с сообщением
 о том что собака спит (формат согласно javadoc).
5. В случае, если параметр переданный в метод toSayable больше либо равен 1, метод say должен вернуть строку
с сообщением о том что собака лает и текущую дату (формат согласно javadoc).
6. Программа должна выводить данные на экран.
7. В методе getName класса DogPet должен быть вызван метод getSuperQuotes класса SuperDog.
*/
public class Solution {
    public static void main(String[] args) {
        List<Pet> pet = Util.getPets();
        List<Sayable> pets = Util.convertPetToSayable(pet);
        Util.printDialog(pets);
    }
}
