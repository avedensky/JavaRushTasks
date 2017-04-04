package com.javarush.task.task33.task3302;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;

/* 
Вторая сериализация в JSON

НЕОБХОДИМО: подключенные библиотеки Jackson Core, Bind и Annotation версии 2.6.1

Расставь JSON аннотации так, чтобы результат работы метода main был следующим
{"wildAnimal":"Murka","over":3}


Требования:
1. Поле name класса Cat должно быть отмечено аннотацией JsonProperty.
2. Поле age класса Cat должно быть отмечено аннотацией JsonIgnore.
3. Поле weight класса Cat должно быть отмечено аннотацией JsonProperty.
4. Значение (value) аннотации JsonProperty у поля name должно быть равно "wildAnimal".
5. Значение (value) аннотации JsonProperty у поля weight должно быть равно "over".
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;
        cat.weight = 3;

        StringWriter writer = new StringWriter();
        convertToJSON(writer, cat);
        System.out.println(writer.toString());
    }

    public static void convertToJSON(StringWriter writer, Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, object);
    }



    @JsonAutoDetect
    public static class Cat {

        @JsonProperty("wildAnimal")
        public String name;

        @JsonIgnore
        public int age;

        @JsonProperty("over")
        public int weight;

        Cat() {
        }
    }
}
