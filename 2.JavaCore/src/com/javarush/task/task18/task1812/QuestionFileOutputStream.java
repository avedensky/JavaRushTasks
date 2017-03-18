package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream

Используя шаблон проектирования Wrapper (Decorator) расширь функциональность AmigoOutputStream.
В классе QuestionFileOutputStream при вызове метода close() должна быть реализована следующая функциональность:
1. Вывести в консоль фразу «Вы действительно хотите закрыть поток? Д/Н«.
2. Считайте строку.
3. Если считанная строка равна «Д«, то закрыть поток.
4. Если считанная строка не равна «Д«, то не закрывать поток.
*/

public class QuestionFileOutputStream implements AmigoOutputStream {

    AmigoOutputStream component;

    QuestionFileOutputStream(AmigoOutputStream component) {
        this.component = component;
    }


    @Override
    public void flush() throws IOException {
        component.flush();
    }

    @Override
    public void write(int b) throws IOException {
        component.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        component.write(b);

    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        component.write(b, off, len);

    }

    @Override
    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s= reader.readLine();

        if (s.equals("Д"))
            component.close();

        reader.close();
    }
}

