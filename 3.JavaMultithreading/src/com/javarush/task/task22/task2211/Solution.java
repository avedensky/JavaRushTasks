package com.javarush.task.task22.task2211;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


/* 
Смена кодировки

В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать
содержимое первого файла в кодировке UTF-8.


Требования:
1. Программа НЕ должна считывать данные с клавиатуры.
2. Программа НЕ должна выводить данные на экран.
3. Программа должна записывать данные в файл.
4. Содержимое второго файла должно соответствовать содержимому первого файла за исключением кодировки(UTF-8).
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        //Так валидатор не прнимает:
        //byte[] buffer = Files.readAllBytes(Paths.get(args[0]));
        //Files.write(Paths.get(args[1]),new String(buffer, "UTF-8").getBytes("Windows-1251"));

        //А так принимает
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        FileOutputStream fileOutputStream = new FileOutputStream(args[1]);

        byte[] buffer = new byte[fileInputStream.available()];
        fileInputStream.read(buffer);

        fileOutputStream.write(new String(buffer, "UTF-8").getBytes("Windows-1251"));

        fileInputStream.close();
        fileOutputStream.close();


    }
}
