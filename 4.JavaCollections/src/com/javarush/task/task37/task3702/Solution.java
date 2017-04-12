package com.javarush.task.task37.task3702;

import com.javarush.task.task37.task3702.male.MaleFactory;

/**
 * Created by Alexey Vedensky on 12.04.2017.
 * MAIL: avedensky@gmail.com
 */
public class Solution {
    public static void main(String[] args) {
        MaleFactory maleFactory = new MaleFactory();
        Human[] humans = new Human[3];
        humans[0] = maleFactory.getPerson(99);
        humans[1] = maleFactory.getPerson(4);
        humans[2] = maleFactory.getPerson(15);

        for (Human human : humans)
            System.out.println(human);
    }
}
