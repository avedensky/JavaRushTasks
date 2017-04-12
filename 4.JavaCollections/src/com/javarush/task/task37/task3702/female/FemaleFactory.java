package com.javarush.task.task37.task3702.female;

import com.javarush.task.task37.task3702.Human;

/**
 * Created by Alexey Vedensky on 12.04.2017.
 * MAIL: avedensky@gmail.com
 */
public class FemaleFactory {
    public Human getPerson(int age) {
        if (age <= KidGirl.MAX_AGE)
            return new KidGirl();
        if (age <= TeenGirl.MAX_AGE)
            return new TeenGirl();
        return new Woman();
    }
}
