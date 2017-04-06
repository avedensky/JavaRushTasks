package com.javarush.task.task33.task3306;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.IOException;
import java.io.StringWriter;

/* 
Первая сериализация в XML

Расставь правильно JAXB аннотации у статических классов.


Требования:
1. Класс Cat должен быть отмечен аннотацией @XmlRootElement.
2. Класс Cat должен быть отмечен аннотацией @XmlType с параметром name = "cat".
3. Класс Dog должен быть отмечен аннотацией @XmlRootElement.
4. Класс Dog должен быть отмечен аннотацией @XmlType с параметром name = "dog".
*/
public class Solution {
    public static void main(String[] args) throws IOException, JAXBException {
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;
        cat.weight = 3;

        Dog dog = new Dog();
        dog.name = "Killer";
        dog.age = 8;
        dog.owner = "Bill Jeferson";

        StringWriter writer = new StringWriter();
        convertToXml(writer, cat);
        convertToXml(writer, dog);
        System.out.println(writer.toString());
        /* expected output
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<cat>
    <name>Murka</name>
    <age>5</age>
    <weight>3</weight>
</cat>
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<dog>
    <name>Killer</name>
    <age>8</age>
    <owner>Bill Jeferson</owner>
</dog>
        */
    }

    public static void convertToXml(StringWriter writer, Object obj) throws IOException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(obj, writer);
    }

    public static class Pet {
        public String name;
    }

    @XmlRootElement
    @XmlType(name = "cat")
    public static class Cat extends Pet {
        public int age;
        public int weight;
    }

    @XmlRootElement
    @XmlType(name = "dog")
    public static class Dog extends Pet {
        public int age;
        public String owner;
    }
}
