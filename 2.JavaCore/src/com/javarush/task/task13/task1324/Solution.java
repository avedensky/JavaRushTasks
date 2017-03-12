package com.javarush.task.task13.task1324;

import java.awt.*;

/* 
Один метод в классе
1. Унаследовать Fox от интерфейса Animal.
2. Поменяй код так, чтобы в классе Fox был только один метод — getName.
3. Методы удалять нельзя!
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    public interface Animal {
        Color getColor();

        Integer getAge();
    }

    public abstract static class Fox implements Animal{
        public String getName() {
            return "Fox";
        }
    }
}
