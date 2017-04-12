package com.javarush.task.task37.task3702.male;

import com.javarush.task.task37.task3702.Human;

/**
 * Created by Alexey Vedensky on 12.04.2017.
 * MAIL: avedensky@gmail.com
 */
public class MaleFactory {

    public Human getPerson(int age) {
        if (age <= KidBoy.MAX_AGE)
            return new KidBoy();
        if (age <= TeenBoy.MAX_AGE)
            return new TeenBoy();
        return new Man();
    }
}
