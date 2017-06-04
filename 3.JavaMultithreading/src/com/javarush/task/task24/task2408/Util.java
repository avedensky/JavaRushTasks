package com.javarush.task.task24.task2408;

import java.util.LinkedList;
import java.util.List;

public class Util {
    //Util отлично работает с классами Dog, Mouse.
    public static void printDialog(List<Sayable> pets) {
        for (int i = 0; i < pets.size(); i++) {
            System.out.println(pets.get(i).say());
        }
    }

    public static List<Pet> getPets() {
        List<Pet> pets = new LinkedList<>();
        pets.add(new Dog("Барбос"));
        pets.add(new Dog("Тузик"));
        pets.add(new Dog("Бобик"));
        pets.add(new Mouse());
        pets.add(new Dog("Шарик"));
        return pets;
    }

    public static List<Sayable> convertPetToSayable(List<Pet> pets) {
        List<Sayable> result = new LinkedList<>();
        for (Pet pet : pets) {
            int i = (int) (Math.random() * 7) - 2;
            result.add(pet.toSayable(i));
        }
        return result;
    }
}
