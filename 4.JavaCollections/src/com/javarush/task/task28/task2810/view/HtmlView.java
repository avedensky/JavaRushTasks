package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by Alexey on 10.05.2017.
 */


/*1. В классе HtmlView в методе updateFile открой поток для записи в файл.
        2. Запиши в файл данные, которые метод updateFile получает аргументом.
        3. Закрой поток записи в файл.*/

public class HtmlView implements View {
    private Controller controller;

    private final String filePath;

    {
        filePath = "./src/" + this.getClass().getPackage().getName().replace('.', '/') + "/vacancies.html";
    }

    private String getUpdatedFileContent(List<Vacancy> list) {
        return null;
    }

    private void updateFile(String s) {
        try {
            OutputStream outputStream = new FileOutputStream(filePath);
            outputStream.write(s.getBytes());
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(List<Vacancy> vacancies) {
        try {
            updateFile(getUpdatedFileContent(vacancies));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Odessa");
    }
}
