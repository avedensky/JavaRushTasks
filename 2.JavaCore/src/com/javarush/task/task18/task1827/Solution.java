
package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
CrUD для таблицы внутри файла.
Считать с консоли имя файла для операций CrUD.

Программа запускается со следующим набором параметров:
-c productName price quantity

Значения параметров:
где id — 8символов.
productName — название товара,30chars(60bytes).
price — цена,8символов.
quantity — количество,4символа.
-c — добавляет товар с заданными параметрами в конец файла,генерирует id самостоятельно,инкрементируя максимальный id,найденный в файле.

В файле данные хранятся в следующей последовательности(без разделяющих пробелов):
id productName price quantity

Данные дополнены пробелами до их длины.

Пример:
19846Шорты пляжные синие159.00 12
198478Шорты пляжные черные с рисунко173.00 17
19847983Куртка для сноубордистов,разм10173.991234


Требования:
1. Программа должна считать имя файла для операций CrUD с консоли.
2. При запуске программы без параметров список товаров должен остаться неизменным.
3. При запуске программы с параметрами"-c productName price quantity"в конец файла должна добавится новая строка с товаром.
4. Товар должен иметь следующий id,после максимального,найденного в файле.
5. Форматирование новой строки товара должно четко совпадать с указанным в задании.
6. Созданные для файлов потоки должны быть закрыты.
*/

//Валидацию прошел с 35 попытки. Без малого это п-ц.
//А все потому, что нигде не сказано, что режим append для записи в файл использовать нельзя.
//Зато выскакивают бестолковые подсказки о том что форматирование должно совпадать с условием задачи....
//Решение прошло только после полной перезаписи файла, без append.
//И да, половину проверок скорее всего можно не делать, это перестраховка.
public class Solution {

    public static void main(String[] args) throws Exception {
        if (args.length < 4 || !args[0].equals("-c")) return;
        float price;
        int qty;

        //Если что-то передали не то
        try {
            price = Float.parseFloat(args[args.length - 2]);
            qty = Integer.parseInt(args[args.length - 1]);
        } catch (NumberFormatException e) {
            return;
        }

        //Если у нас аргументов больше 4 из-за пробелов в строке productName
        String productName;
        if (args.length > 4) {
            StringBuffer buf = new StringBuffer();
            for (int i = 1; i < args.length - 2; i++)
                buf.append(args[i]).append(" ");
            productName = buf.substring(0, buf.length() - 1);
        } else
            productName = args[1];

        //Read file name from console
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = consoleReader.readLine();
        consoleReader.close();

        //Get Lines from file
        //List<String> lines = Files.readAllLines(Paths.get(fileName)); //так проще, но не пропускается
        List<String> lines = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            while (fileReader.ready())
                lines.add(fileReader.readLine());
        }

        //Get ID from line
        Pattern p = Pattern.compile("([0-9]{1,8})");
        int maxID = 0;
        for (String s : lines) {
            Matcher m = p.matcher(s);
            if (m.lookingAt()) {
                try {
                    //System.out.println(s.substring(m.start(), m.end()));
                    int id = Integer.parseInt(s.substring(m.start(), m.end()));
                    if (id > maxID)
                        maxID = id;
                } catch (NumberFormatException e) {
                    continue;
                }
            }
        }

        if (maxID++ == 99999999)
            return;
        String toFile = String.format(Locale.ROOT,"%-8d%-30s%-8.2f%-4d", maxID, productName, price, qty);

        lines.add(toFile);
        try (BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)))) {
            for (String s: lines)
                buf.write(s+"\r\n");
        }
    }
}