package com.javarush.task.task23.task2311;

/* 
Повторяем threads

Сделать так, чтобы в методе someActions вызывались только методы класса Solution.

Ожидаемый вывод в методе main:
Amigo: Mmmmm, beef
Amigo: knock knock
Amigo: Zzzzzzz...1 sec


Требования:
1. Вывод на экран должен соответствовать условию задачи.
2. В методе someActions должен быть вызван метод sleep класса Solution.
3. В классе Solution должно присутствовать поле name.
4. В классе Solution должно присутствовать поле food.
5. В классе Solution должно присутствовать поле sound.
*/
public class Solution {
    public final String name;
    public final String food;
    public final String sound;

    public Solution(String name, String food, String sound) {
        this.name = name;
        this.food = food;
        this.sound = sound;
    }

    public void eat() {
        System.out.println(name + ": Mmmmm, " + food);
    }

    public void play() {
        System.out.println(name + ": " + sound + " " + sound);
    }

    public void sleep(long milliseconds) {
        System.out.println(name + ": Zzzzzzz..." + (milliseconds / 1000) + " sec");
    }

    public void live() throws InterruptedException {
        Thread thread = new Thread() {
            public void run() {
                try {
                    someActions();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private void someActions() throws InterruptedException {
                eat();
                play();
                Solution.this.sleep(1000);
            }
        };
        thread.start();
        thread.join();
    }

    public static void main(String[] args) throws InterruptedException {
        new Solution("Amigo", "beef", "knock").live();
    }
}