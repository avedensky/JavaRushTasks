package com.javarush.task.task33.task3305;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.MINIMAL_CLASS,  property="className")
public class Parking {
    public String name;
    public String city;
    public List<Auto> autos;

    public Parking(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", autos=" + autos +
                '}';
    }
}