package com.javarush.task.task34.task3407;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

/* 
Призрачные ссылки

Разберись в примере.
Реализуй логику метода getFilledList класса Helper:
1) создай список, который сможет хранить призрачные ссылки на объекты Monkey
2) добавь в список 200 ссылок, используйте очередь helper.getQueue()
3) верни заполненный список


Требования:
1. Метод getFilledList должен возвращать список заполненный фантомными ссылками на объекты типа Monkey.
2. Метод getFilledList должен возвращать список из 200 элементов.
3. Класс Helper не должен быть приватным.
4. Метод getFilledList не должен быть приватным.
*/
public class Solution {
    public static Helper helper = new Helper();

    public static class Monkey {
    }

    public static void main(String args[]) throws InterruptedException {
        helper.startTime();
        List<PhantomReference<Monkey>> list = helper.getFilledList();

        //before GC
        helper.checkListWithReferences(list, "before");

        helper.callGC();
        helper.heapConsuming();

        //after GC
        helper.checkListWithReferences(list, "after");

        helper.finish();
    }

    public static class Helper {
        private ReferenceQueue<Monkey> queue = new ReferenceQueue<>();

        private long startTime;

        void startTime() {
            this.startTime = System.currentTimeMillis();
        }

        int getTime() {
            return (int) (System.currentTimeMillis() - startTime) / 1000;
        }

        void callGC() throws InterruptedException {
            System.gc();
            Thread.sleep(1000);
        }

        public ReferenceQueue<Monkey> getQueue() {
            return queue;
        }

        void heapConsuming() {
            try {
                List<Solution> heap = new ArrayList<Solution>(100000);
                while (true) {
                    heap.add(new Solution());
                }
            } catch (OutOfMemoryError e) {
                System.out.println("Out of memory error raised");
            }
        }

        public void checkListWithReferences(List<PhantomReference<Monkey>> list, String string) {
            int count = 0;
            for (PhantomReference<Monkey> reference : list) {
                if (reference.isEnqueued()) {
                    count++;
                }
            }

            System.out.println(String.format("The enqueue reference count is %d (%s GC was called)", count, string));
        }

        public List<PhantomReference<Monkey>> getFilledList() {
            //список призрачных ссылок
            ArrayList<PhantomReference<Monkey>> list = new ArrayList<PhantomReference<Monkey>>();
            //создаем 200 объектов и добавляем их в список через призрачные ссылки
            for ( int i = 0; i < 200; i++) {
                Monkey monkey = new Monkey();
                list.add(new PhantomReference (monkey, queue));
            }
            return list;
        }

        public void finish() throws InterruptedException {
            int count = 0;
            while (queue.poll() != null) {
                count++;
            }
            System.out.println(count + " objects are in the queue of phantom reference");
            System.out.println("It took " + getTime() + " sec");
        }
    }
}
