package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* 
Знакомство с properties

В методе fillInPropertiesMap считайте имя файла с консоли и заполни карту properties данными из файла.
Про .properties почитать тут — http://ru.wikipedia.org/wiki/.properties
Реализуй логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public static Properties prop = new Properties();
    public static String filName;

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader conReader = new BufferedReader(new InputStreamReader(System.in));
        filName = conReader.readLine();
        conReader.close();

        FileInputStream fileInputStream = new FileInputStream (Solution.filName);
        load(fileInputStream);
        fileInputStream.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        prop.clear();
        for (Map.Entry<String, String> pair : properties.entrySet()) {
            prop.put (pair.getKey(), pair.getValue());
        }

        prop.store(outputStream,"");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        prop.load(inputStream);
        for (Map.Entry<Object, Object> pair: prop.entrySet()) {
            properties.put((String) pair.getKey(), (String) pair.getValue());
        }
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.fillInPropertiesMap ();

        FileOutputStream fileOutputStream = new FileOutputStream(Solution.filName);
        solution.save(fileOutputStream);
        fileOutputStream.close();
    }
}
