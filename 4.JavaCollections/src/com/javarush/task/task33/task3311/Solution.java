package com.javarush.task.task33.task3311;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;

/* 
Странная ошибка

НЕОБХОДИМО: подключенные библиотеки Jackson Core, Bind и Annotation версии 2.6.1

В результате выполнения кода в методе main класса Solution возникает странная ошибка
при сериализации/десериализации в JSON. На экран должна быть выведена строка sampleJsonString,
а выводится не совсем она.

Разберись в чем проблема и исправь. Обрати внимание на класс RealBean.


Требования:
1. Метод getAdditionalMap должен быть отмечен одной подходящей Jackson аннотацией.
2. Сериализация элементов additionalMap в json должна происходить, как сериализация обычных полей класса.
3. Десериализация элементов additionalMap из json должна происходить, как десериализация обычных полей класса.
4. Метод main должен выводить данные на экран.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter stringWriter = new StringWriter();
        ObjectMapper objectMapper = new ObjectMapper();
        String sampleJsonString = "{\"id\":1,\"name\":\"first\",\"KEY#1\":\"VALUE#1\",\"KEY#3\":\"VALUE#3\",\"KEY#2\":\"VALUE#2\"}";
        RealBean realBean = objectMapper.readValue(sampleJsonString, RealBean.class);

        objectMapper.writeValue(stringWriter, realBean);
        System.out.println(stringWriter.toString());
    }
}
