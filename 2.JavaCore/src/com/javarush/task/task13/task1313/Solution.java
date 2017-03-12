package com.javarush.task.task13.task1313;

import java.awt.*;

/* 
Интерфейс Animal
1. Реализуй в классе Fox интерфейс Animal.
2. Поменяй код так, чтобы в классе Fox был только один метод — getName.
3. Создавать дополнительные классы и удалять методы нельзя!
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    public interface Animal {
        Color getColor();
    }

    public abstract static class Fox implements Animal {
        public String getName() {
            return "Fox";
        }
    }
}