package com.javarush.task.task33.task3310;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by Alexey Vedensky on 14.04.2017.
 * MAIL: avedensky@gmail.com
 */
public class Helper {
    public static String generateRandomString() {
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
