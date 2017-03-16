package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность

Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла — в allLines, из второго — в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки,
которые есть в forRemoveLines
4. Если условие из п.3 не выполнено, то:
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
Не забудь закрыть потоки.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName1 = sc.nextLine();
        String fileName2 = sc.nextLine();
//        String fileName1 = "d:\\3.txt";
//        String fileName2 = "d:\\4.txt";

        try {
            BufferedReader file1 = new BufferedReader(new InputStreamReader(new FileInputStream(fileName1)));

            while (file1.ready()) {
                allLines.add(file1.readLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName1 + " not found");
        } catch (IOException e) {
            System.out.println("Can't Read File " + fileName1);
        }

        try {
            BufferedReader file2 = new BufferedReader(new InputStreamReader(new FileInputStream(fileName2)));

            while (file2.ready()) {
                forRemoveLines.add(file2.readLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName2 + " not found");
        } catch (IOException e) {
            System.out.println("Can't Read File " + fileName2);
        }

        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
            System.out.println("Что-то");
        }
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
            return;
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
