package com.javarush.task.task23.task2302;

/* 
Запрети переопределение

Запрети переопределение метода onMouseDown.


Требования:
1. Класс Listener должен быть создан внутри класса Solution.
2. Класс Listener должен быть публичным.
3. Метод onMouseDown должен быть публичным.
4. Должна быть запрещена возможность переопределить метод onMouseDown.
*/
public class Solution {

    public static class Listener {
        public final void onMouseDown(int x, int y) {
            //do something on mouse down event
        }

        public void onMouseUp(int x, int y) {
            //do something on mouse up event
        }
    }

    public static void main(String[] args) {

    }
}
