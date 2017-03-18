package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* 
UnsupportedFileName

Измени класс TxtInputStream так, чтобы он работал только с txt-файлами (*.txt).
Например, first.txt или name.1.part3.txt.
Если передан не txt-файл, например, file.txt.exe, то конструктор
должен выбрасывать исключение UnsupportedFileNameException.
Подумай, что еще нужно сделать, в случае выброшенного исключения.
*/

public class TxtInputStream extends FileInputStream {
    FileInputStream component;

    public TxtInputStream(String fileName) throws UnsupportedFileNameException, IOException {
        super(fileName);

        if (fileName.endsWith(".txt"))
            this.component = new FileInputStream(fileName);
        else {
            super.close();
            throw new UnsupportedFileNameException();
        }
    }

    @Override
    public int read() throws IOException {
        return this.component.read();
    }

    @Override
    public int read(byte[] b) throws IOException {
        return this.component.read(b);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return this.component.read(b, off, len);
    }

    @Override
    public long skip(long n) throws IOException {
        return this.component.skip(n);
    }

    @Override
    public int available() throws IOException {
        return this.component.available();
    }

    @Override
    public void close() throws IOException {
        super.close();
        this.component.close();
    }

    @Override
    public FileChannel getChannel() {
        return this.component.getChannel();
    }

    public static void main(String[] args) {
    }
}