package com.javarush.task.task19.task1917;

/* 
Свой FileWriter

Реализовать логику FileConsoleWriter.
Класс FileConsoleWriter должен содержать приватное поле FileWriter fileWriter.
Класс FileConsoleWriter должен содержать все конструкторы, которые инициализируют fileWriter для записи.

При записи данных в файл, должен дублировать эти данные на консоль.
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;


public class FileConsoleWriter {
    private FileWriter fileWriter;

    public FileConsoleWriter(String fileName) throws IOException {
        fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        fileWriter = new FileWriter(fd);
    }

    public String getEncoding() {
        return fileWriter.getEncoding();
    }

    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.print(c);
    }

    public void write(String str) throws IOException {
        fileWriter.write(str);
        System.out.print(str);
    }

    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        System.out.print(cbuf);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        System.out.print(new String(cbuf, off, len));
    }

    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
        System.out.print(str.substring(off, off + len));
    }

    public void flush() throws IOException {
        fileWriter.flush();
    }

    public void close() throws IOException {
        fileWriter.close();
    }

    public static void main(String[] args) {

    }
}
