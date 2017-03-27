package com.javarush.task.task18.task1827;

/* 
Прайсы

CrUD для таблицы внутри файла.
Считать с консоли имя файла для операций CrUD.

Программа запускается со следующим набором параметров:
-c productName price quantity

Значения параметров:
где id — 8 символов.
productName — название товара, 30 chars (60 bytes).
price — цена, 8 символов.
quantity — количество, 4 символа.
-c — добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле.

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity

Данные дополнены пробелами до их длины.

Пример:
19846 Шорты пляжные синие 159.00 12
198478 Шорты пляжные черные с рисунко173.00 17
19847983Куртка для сноубордистов, разм10173.991234
*/

/*
спецификатор %5.7s выводит строку длиной не менее пяти и не более семи символов.
Если строка длиннее, конечные символы отбрасываются.
*/


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) throws Exception {
        if (args.length < 4) return;

        String priceText = args[args.length - 2];
        String qtyText = args[args.length - 1];
        String descripText = null;

        //Если у нас аргументов больше 4 из-за пробелов в строке productName
        if (args.length > 4) {
            StringBuffer buf = new StringBuffer();
            for (int i = 1; i < args.length - 2; i++)
                buf.append(args[i]).append(" ");
            descripText = buf.substring(0, buf.length() - 1);
        } else
            descripText = args[1];

        BufferedReader conReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = conReader.readLine();
        //String fileName = "e:\\price.txt";
        conReader.close();

        if (args[0].equals("-c")) {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

            ArrayList<Integer> idList = new ArrayList<>();
            int lastID = 0;
            while (fileReader.ready()) {
                String line = fileReader.readLine();
                if (line.length() < 8)
                    continue;

                String s = line.substring(0, 8).trim();
                lastID = Integer.parseInt(s);
                idList.add(lastID);

            }
            fileReader.close();

            int maxID = Collections.max(idList) + 1;
            String toFile = String.format("%n%-8d%-30.30s%-8.2f%-4d", maxID, descripText, Float.valueOf(priceText), Integer.valueOf(qtyText));
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileName, true));
            printWriter.println(toFile);
            printWriter.close();
        }
    }
}