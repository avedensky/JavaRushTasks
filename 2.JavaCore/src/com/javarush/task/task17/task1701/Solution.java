package com.javarush.task.task17.task1701;

import java.util.ArrayList;
import java.util.List;

/* 
Заметки

Асинхронность выполнения нитей.
1. Класс Note будет использоваться нитями.
2. Создай public static нить NoteThread (Runnable не является нитью), которая в методе run 1000 раз (index = 0-999)
сделает следующие действия:
2.1. Используя метод addNote добавит заметку с именем [getName() + «-Note» + index], например, при index=4
«Thread-0-Note4»
2.2. Используя метод removeNote удалит заметку
2.3. В качестве параметра в removeNote передай имя нити — метод getName()

*/

public class Solution {
    public static void main(String[] args) {
        new NoteThread().start();
        new NoteThread().start();
    }

    public static class Note {

        public static final List<String> notes = new ArrayList<String>();

        public static void addNote(String note) {
            notes.add(0, note);
        }

        public static void removeNote(String threadName) {
            String note = notes.remove(0);
            if (note == null) {
                System.out.println("Другая нить удалила нашу заметку");
            } else if (!note.startsWith(threadName)) {
                System.out.println("Нить [" + threadName + "] удалила чужую заметку [" + note + "]");
            }
        }
    }

    public static class NoteThread extends Thread {
        @Override
        public void run() {
            for (int i=0; i<1000; i++) {
                Note.addNote(getName() + "-Note" + i);
                Note.removeNote(getName());
                //avedensky comments: You have black screen? For use Thread.sleep here.
            }
        }
    }
}
