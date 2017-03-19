package com.javarush.task.task18.task1828;

/*
Прайсы 2

CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD

Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id

Значения параметров:
где id — 8 символов
productName — название товара, 30 chars (60 bytes)
price — цена, 8 символов
quantity — количество, 4 символа
-u — обновляет данные товара с заданным id
-d — производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846 Шорты пляжные синие 159.00 12
198478 Шорты пляжные черные с рисунко173.00 17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Solution {
    private static final int ID_LEN = 8;
    private static final int PRODUCT_NAME_LEN = 30;
    private static final int PRICE_LEN = 8;
    private static final int QUANTITY_LEN = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        StringBuffer argsAsString = new StringBuffer();
        for (int i = 1; i < args.length; i++) {
            argsAsString.append(args[i]+" ");
        }

        ArrayList<String> products = new ArrayList<>();
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        while (fileReader.ready())
            products.add(fileReader.readLine());
        fileReader.close();


        switch (args[0]) {
            case "-u": {
                int startPos = 0;
                String id = argsAsString.substring(startPos,ID_LEN);
                startPos += ID_LEN;
                String productName = argsAsString.substring(startPos,startPos+PRODUCT_NAME_LEN-1);
                startPos += PRODUCT_NAME_LEN-1;
                String price = argsAsString.substring(startPos,startPos+PRICE_LEN);
                startPos += PRICE_LEN;
                String quantity = argsAsString.substring(startPos,startPos+QUANTITY_LEN);

                for (int i = 0; i < products.size(); i++)
                    if (products.get(i).startsWith(id)) {
                        StringBuffer sb = new StringBuffer();
                        sb.append(makeField(id, ID_LEN));
                        sb.append(makeField(productName, PRODUCT_NAME_LEN));
                        sb.append(makeField(price, PRICE_LEN));
                        sb.append(makeField(quantity, QUANTITY_LEN));
                        products.set(i, new String(sb));
                        break;
                    }
                break;
            }

            case "-d": {
                Iterator<String> iter = products.iterator();
                while (iter.hasNext()) {
                    String product = iter.next();
                    if (product.startsWith(args[1]))
                        iter.remove();
                }
                break;
            }
        }

        PrintWriter fileWriter = new PrintWriter(fileName);
        //PrintWriter fileWriter = new PrintWriter("d:\\prod3.txt");
        for (String s : products)
            fileWriter.println(s);
        fileWriter.close();
    }

    private static StringBuffer makeField(String s, int fieldLenght) {
        StringBuffer sb = new StringBuffer(s);
        for (int i = sb.length(); i < fieldLenght; i++)
            sb.append(" ");

        return sb;
    }
}