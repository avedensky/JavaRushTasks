package com.javarush.task.task08.task0808;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* 
10 тысяч удалений и вставок
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // ArrayList
        long a = 0;
        long b = 0;

        ArrayList arrayList = new ArrayList();
        System.out.println("ArrayList");

        //insert
        b = System.currentTimeMillis();
        insert10000(arrayList);
        a = System.currentTimeMillis();
        System.out.println("insert:"+(a-b));

        //get
        b = System.currentTimeMillis();
        get10000(arrayList);
        a = System.currentTimeMillis();
        System.out.println("get:"+(a-b));

        //set
        b = System.currentTimeMillis();
        set10000(arrayList);
        a = System.currentTimeMillis();
        System.out.println("set:"+(a-b));

        // remove
        b = System.currentTimeMillis();
        remove10000(arrayList);
        a = System.currentTimeMillis();
        System.out.println("remove:"+(a-b));


        // LinkedList
        LinkedList linkedList = new LinkedList();
        System.out.println ();
        System.out.println("LinkedList");

        //insert
        b = System.currentTimeMillis();
        insert10000(linkedList);
        a = System.currentTimeMillis();
        System.out.println("insert:"+(a-b));

        //get
        b = System.currentTimeMillis();
        get10000(linkedList);
        a = System.currentTimeMillis();
        System.out.println("get:"+(a-b));

        //set
        b = System.currentTimeMillis();
        set10000(linkedList);
        a = System.currentTimeMillis();
        System.out.println("set:"+(a-b));

        // remove
        b = System.currentTimeMillis();
        remove10000(linkedList);
        a = System.currentTimeMillis();
        System.out.println("remove:"+(a-b));
    }

    public static void insert10000(List list) {
        //напишите тут ваш код
        for (int i=0; i<100000; i++)
            list.add(i);

    }

    public static void get10000(List list) {
        //напишите тут ваш код
        for (int i=0; i<100000; i++)
            list.get(i);

    }

    public static void set10000(List list) {
        //напишите тут ваш код
        for (int i=0; i<100000; i++)
            list.set(i,i);
    }

    public static void remove10000(List list) {
        //напишите тут ваш код
        for (int i=99999; i>=0; i--)
            list.remove(i);

    }
}
