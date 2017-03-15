package com.javarush.task.task16.task1605;

import java.util.Date;

/* 
Поговорим о музыке?

1. Измени класс Violin так, чтоб он стал таском для нити. Используй интерфейс MusicalInstrument
2. Реализуй необходимый метод в нити Violin. Реализация должна быть следующей:
2.1. Считай время начала игры — метод startPlaying().
2.2. Подожди 1 секунду — метод sleepNSeconds(int n), где n — количество секунд.
2.3. Считай время окончания игры — метод stopPlaying().
2.4. Выведи на консоль продолжительность игры в миллисекундах.

Пример «Playing 1002 ms«.
*/

public class Solution {
    public static int delay = 1000;

    public static void main(String[] args) {
        Thread violin = new Thread(new Violin("Player"));
        violin.start();
    }

    public static void sleepNSeconds(int n) {
        try {
            Thread.sleep(n * delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public interface MusicalInstrument extends Runnable {
        Date startPlaying();

        Date stopPlaying();
    }

    public static class Violin implements MusicalInstrument {
        private String owner;

        public Violin(String owner) {
            this.owner = owner;
        }

        public Date startPlaying() {
            System.out.println(this.owner + " starts playing");
            return new Date();
        }

        public Date stopPlaying() {
            System.out.println(this.owner + " stops playing");
            return new Date();
        }

        @Override
        public void run() {
            Date start = startPlaying();
            sleepNSeconds(1);
            Date finish = stopPlaying();

            System.out.println("Playing " + (finish.getTime() - start.getTime()) + " ms");
        }
    }
}
