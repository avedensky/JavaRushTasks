package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити

В методе main добавить в статический объект list 5 нитей. Каждая нить должна быть новым объектом класса Thread,
работающим со своим объектом класса SpecialThread.
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        //Add your code here - добавьте свой код тут
        SpecialThread specialThread1 = new SpecialThread();
        SpecialThread specialThread2 = new SpecialThread();
        SpecialThread specialThread3 = new SpecialThread();
        SpecialThread specialThread4 = new SpecialThread();
        SpecialThread specialThread5 = new SpecialThread();

        list.add(new Thread(specialThread1));
        list.add(new Thread(specialThread2));
        list.add(new Thread(specialThread3));
        list.add(new Thread(specialThread4));
        list.add(new Thread(specialThread5));
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
