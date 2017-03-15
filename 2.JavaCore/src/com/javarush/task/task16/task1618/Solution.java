package com.javarush.task.task16.task1618;

/* 
Снова interrupt

Создай нить TestThread.
В методе main создай экземпляр нити, запусти, а потом прерви ее используя метод interrupt().
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        //Add your code here - добавь код тут
        TestThread tst = new TestThread();
        tst.start();
        Thread.sleep(1000);
        tst.interrupt();
    }

    //Add your code below - добавь код ниже
    public static class TestThread extends Thread {

        public void run() {
            while (true) {
                System.out.println("I'am Thread second");
                if (isInterrupted())
                    break;
            }
        }
    }
}