package com.javarush.task.task37.task3702;

import com.javarush.task.task37.task3702.female.FemaleFactory;
import com.javarush.task.task37.task3702.male.MaleFactory;

/**
 * Created by Alexey Vedensky on 12.04.2017.
 * MAIL: avedensky@gmail.com
 */
public class FactoryProducer {
    public static enum HumanFactoryType {MALE, FEMALE};

    public static AbstractFactory getFactory (HumanFactoryType humanFactoryType) {
        if (humanFactoryType == HumanFactoryType.MALE)
            return new MaleFactory();
        if (humanFactoryType == HumanFactoryType.FEMALE)
            return new FemaleFactory();
        return null;
    }
}
