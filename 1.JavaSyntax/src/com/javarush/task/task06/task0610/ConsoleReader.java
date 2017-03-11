package com.javarush.task.task06.task0610;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Класс ConsoleReader
*/

public class ConsoleReader {
    public static String readString() throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();

    }

    public static int readInt() throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();

    }

    public static double readDouble() throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();

    }

    public static boolean readBoolean() throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        return sc.nextBoolean();

    }

    public static void main(String[] args) {

    }
}
