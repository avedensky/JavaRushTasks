package com.javarush.task.task16.task1632;

import javax.imageio.metadata.IIOMetadataNode;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*

Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. Нить 1 должна бесконечно выполняться;
1.2. Нить 2 должна выводить «InterruptedException» при возникновении исключения InterruptedException;
1.3. Нить 3 должна каждые полсекунды выводить «Ура«;
1.4. Нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. Нить 5 должна читать с консоли числа пока не введено слово «N«, а потом вывести в консоль сумму введенных чисел.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.

Подсказка:
Нить 4 можно проверить методом isAlive()

*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new ThreadInfinitely("Thread Infinitely"));
        threads.add(new ThreadInterrupted("Thread Interrupted"));
        threads.add(new ThreadUra("Thread Ura"));
        threads.add(new ThreadMessage("Thread Message"));
        threads.add(new ThreadNumberInputs("Thread Number Inputs"));
    }

    public static void main(String[] args) {
        for (Thread th : threads)
            th.start();
    }


    public static class ThreadInfinitely extends Thread {

        public ThreadInfinitely(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) {
            }
        }
    }


    public static class ThreadInterrupted extends Thread {

        public ThreadInterrupted(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                Thread.sleep(100000000);
            } catch (InterruptedException e) {
                //e.printStackTrace();
                System.out.println("InterruptedException");
            }
        }
    }


    public static class ThreadUra extends Thread {

        public ThreadUra(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }

        }
    }


    public static class ThreadMessage extends Thread implements Message {

        private boolean die;

        public ThreadMessage(String name) {
            super(name);
            this.die = false;
        }

        @Override
        public void run() {
            while (die == false) {
            }
        }

        @Override
        public void showWarning() {
            die = true;
        }
    }


    public static class ThreadNumberInputs extends Thread {

        public ThreadNumberInputs(String name) {
            super(name);
        }

        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int sum = 0;
            String s = null;
            while (true) {
                try {
                    s = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s.equals("N") == true)
                    break;

                sum += Integer.parseInt(s);
            }
            System.out.println(sum);
        }
    }
}