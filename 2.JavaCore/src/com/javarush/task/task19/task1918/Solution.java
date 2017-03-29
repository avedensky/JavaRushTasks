package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами

Считайте с консоли имя файла, который имеет HTML-формат.

Пример:
Info about Leela <span xml:lang=»en» lang=»en»><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>

Первым параметром в метод main приходит тег. Например, «span«.
Вывести на консоль все теги, которые соответствуют заданному тегу.
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле.
Количество пробелов, n, r не влияют на результат.
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нет.
Тег может содержать вложенные теги.

Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader conReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = conReader.readLine();
        conReader.close();

        //Read File
        BufferedReader fileBufReader = new BufferedReader(new FileReader(fileName));
        StringBuffer content = new StringBuffer();
        while (fileBufReader.ready())
            content.append(fileBufReader.readLine());
        fileBufReader.close();
        StringBuffer text = new StringBuffer(content.toString().replaceAll("\r\n", ""));

        String tagOpen = "<" + args[0];
        String tagClose = "</" + args[0] + ">";

        int pozitionOpen = -1;
        int pozitionClose = -1;
        int shift = -1;
        Stack<Integer> openedTags = new Stack<>();
        Map<Integer, Integer> tags = new TreeMap<>(new MyComparator());
        while (true) {
            pozitionOpen = text.indexOf(tagOpen, shift);
            pozitionClose = text.indexOf(tagClose, shift);
            if (pozitionOpen < 0 && pozitionClose < 0)
                break;

            if (pozitionOpen != -1 && pozitionOpen < pozitionClose) { //Open ближе чем close
                openedTags.push(pozitionOpen);
                shift = pozitionOpen + tagOpen.length();
                continue;
            }

            if (pozitionClose != -1 && (pozitionOpen > pozitionClose || pozitionOpen == -1)) { //Close ближе чем open
                if (openedTags.isEmpty())
                    break;
                tags.put(openedTags.pop(), pozitionClose + tagClose.length());
                shift = pozitionClose + tagClose.length();
            }
        }

        for (Map.Entry<Integer, Integer> pair : tags.entrySet()) {
            System.out.println(text.substring(pair.getKey(), pair.getValue()));
        }
    }

    static class MyComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer a, Integer b) {
            return a.compareTo(b);
        }
    }
}



