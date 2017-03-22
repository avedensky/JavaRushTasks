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


Решение в пути...
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Solution {
    //static ArrayList<Tag> tags = new ArrayList<Tag>();
    static ArrayList<Integer> p1 = new ArrayList<>();
    static ArrayList<Integer> p2 = new ArrayList<>();
    static String tagOpen;
    static String tagClose;

    public static void main(String[] args) throws IOException {
        BufferedReader conReader = new BufferedReader(new InputStreamReader(System.in));
        //String fileName = conReader.readLine();
        String fileName = "d:\\3333.txt";
        conReader.close();

        StringBuffer content = new StringBuffer();

        //Read File
        BufferedReader fileBufReader = new BufferedReader(new FileReader(fileName));
        while (fileBufReader.ready())
            content.append(fileBufReader.readLine());
        fileBufReader.close();

        //StringBuffer text = new StringBuffer(content.toString().replaceAll("\r\n", ""));


        StringBuffer text = new StringBuffer("<span>text<span>text2</span>text3<span>text4</span>text5</span>");

        tagOpen = "<" + args[0];
        tagClose = "</" + args[0] + ">";

        int pozitionOpen = -1;
        int pozitionClose = -1;
        // Type current = Type.NONE;

        while (true) {
            pozitionOpen = text.indexOf(tagOpen, pozitionOpen + 1);
            pozitionClose = text.indexOf(tagClose, pozitionClose + 1);
            if (pozitionOpen < 0 && pozitionClose < 0)
                break;

            if (pozitionOpen != -1) {
                p1.add(pozitionOpen);
                System.out.println("-Open " + text.substring(pozitionOpen, text.length()));
                //text.delete(pozitionOpen, pozitionOpen+tagOpen.length()+1 );
            }
            if (pozitionClose != -1) {
                p2.add(pozitionClose);
                System.out.println("-Close " + text.substring(pozitionOpen, text.length()));
                //text.delete(pozitionClose, pozitionClose+tagClose.length() );
            }
//            System.out.println(text);
        }

        /*System.out.println("p1.size():" + p1.size());
        System.out.println("p2.size():" + p2.size());
        System.out.println("------ p1 -------");*/
        /*for (int i = 0; i < p1.size(); i++) {
            System.out.println("p1[" + i + "]=" + p1.get(i));
        }*/

        System.out.println("------ p2 -------");
        for (int i = 0, j = p2.size()-1; i < p1.size(); i++, j--) {
            //System.out.println("p1[" + i + "]=" + p2.get(i));
            System.out.println(p1.get(i) + " " + p2.get(j));
            System.out.println(text.substring(p1.get(i),p2.get(j)+tagClose.length()));
        }


        /*
        int i = 0;
        int pozitionOpen = 0;
        int pozitionClose = 0;
        int pozitionNear = 0;
        int level = 0;
        Type last = Type.NONE;
        Type current = Type.NONE;

        while (true) {
            pozitionOpen = text.indexOf(tagOpen);
            pozitionClose = text.indexOf(tagClose);
            pozitionNear = pozitionOpen < pozitionClose ? pozitionOpen : pozitionClose;
            current = pozitionOpen < pozitionClose ? Type.OPEN : Type.CLOSE;

            if (i == 0 && current == Type.CLOSE) { //Первый тэг CLOSED :-(
                System.out.println("Ошибка в файле");
                System.exit(0);
            }

            if (last == Type.NONE &&  current == Type.OPEN) { //Первый тэг OPEN

                last = Type.OPEN;
                Tag tag = new Tag();
                tag.level = level;
                tag.ready = false;
                tag.open = true;
                tag.close = false;
                tag.stringOpenPosition = pozitionOpen;
                tags.add(tag);
            }

            if (last == Type.OPEN &&  current == Type.OPEN) { //Первый тэг OPEN

                last = Type.OPEN;
                Tag tag = new Tag();
                tag.level = level;
                tag.ready = false;
                tag.open = true;
                tag.close = false;
                tag.stringOpenPosition = pozitionOpen;
                tags.add(tag);
            }

            if (last == Type.OPEN &&  current == Type.CLOSE) { //Первый тэг OPEN

                last = Type.OPEN;
                Tag tag = new Tag();
                tag.level = level;
                tag.ready = false;
                tag.open = true;
                tag.close = false;
                tag.stringOpenPosition = pozitionOpen;
                tags.add(tag);
            }



            i++;
        }
*/
    }

    enum Type {NONE, OPEN, CLOSE}

    static class Tag {
        private boolean open;
        private boolean close;
        private int level; //Уровень вложенности, чем ваше тем больше вложенность
        private boolean ready; //true если нашелся закрывающийся тэг
        private int stringOpenPosition; //Открывающий тэг, позиция в общем тексте
        private int stringClosedPosition; //Открывающий тэг, позиция в общем тексте
    }
}