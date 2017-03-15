package com.javarush.task.task16.task1601;

/* 
My first thread

Создать public static class TestThread — нить с интерфейсом Runnable.
TestThread должен выводить в консоль «My first thread«.
*/

public class Solution {
    public static void main(String[] args) {
        TestThread task = new TestThread();
        new Thread(task).start();
    }

    public static class TestThread implements Runnable {
        public void run (){
            System.out.println("My first thread");
        }

    }
}
