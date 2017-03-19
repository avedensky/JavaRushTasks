package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Нити и байты

Читайте с консоли имена файлов, пока не будет введено слово «exit«.
Передайте имя файла в нить ReadThread.
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String — это имя файла, параметр Integer — это искомый байт.
Закрыть потоки.
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = null;
        while (true) {
            s = reader.readLine();
            if (s.equals("exit"))
                break;

            ReadThread th = new ReadThread(s);
            th.start();
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;
        private byte findedByte;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
            //start();
        }

        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            HashMap<Byte, Integer> freqMap = new HashMap<Byte, Integer>();

            try {
                FileInputStream f = new FileInputStream(this.fileName);
                while (f.available() > 0) {
                    byte[] buf = new byte[f.available()];
                    f.read(buf);

                    for (byte b : buf) {
                        if (freqMap.containsKey(b))
                            freqMap.put(b, freqMap.get(b) + 1);
                        else
                            freqMap.put(b, 1);
                    }
                }
                f.close();
            } catch (FileNotFoundException e) {
                e.getMessage();
            } catch (IOException e) {
                e.getMessage();
            }

            //Find Byte
            int max = 0;
            for (Map.Entry<Byte, Integer> pair : freqMap.entrySet()) {
                if (max < pair.getValue()) {
                    this.findedByte = pair.getKey();
                    max = pair.getValue();
                }
            }

            synchronized (resultMap) {
                resultMap.put(this.fileName, new Integer(this.findedByte));
            }
        }
    }
}
