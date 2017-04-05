package com.javarush.task.task33.task3312;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/* 
Сериализация зоопарка

Сделай так, чтобы при сериализации объекта типа Zoo, каждому элементу списка animals был добавлен тип (dog для класса Dog, cat для класса Cat).
Для проверки можешь использовать метод main класса Solution.

Было:
{"animals":[{"name":"doggy","barkVolume":0.0},{"name":"catty","lives":0}]}

Должно стать:
{"animals":[{"type":"dog","name":"doggy","barkVolume":0.0},{"type":"cat","name":"catty","lives":0}]}


Требования:
1. Класс Zoo.Animal должен быть отмечен аннотацией @JsonTypeInfo.
2. Класс Zoo.Animal должен быть отмечен аннотацией @JsonSubTypes.
3. Класс Zoo.Dog должен быть отмечен аннотацией @JsonTypeName.
4. Класс Zoo.Cat должен быть отмечен аннотацией @JsonTypeName.
5. При сериализации в JSON всем объектам списка animals должен быть добавлен тип и сохранен основной формат (пример в задании).
*/
public class Solution {
    public static void main(String[] args) throws JsonProcessingException {
        Zoo.Dog dog = new Zoo.Dog("doggy");
        Zoo.Cat cat = new Zoo.Cat("catty");
        Zoo zoo = new Zoo();
        zoo.animals.add(dog);
        zoo.animals.add(cat);

        String result = new ObjectMapper().writeValueAsString(zoo);

        System.out.println(result);
    }
}
