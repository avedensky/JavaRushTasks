package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;


import java.util.List;

/**
 * Created by Alexey on 10.05.2017.
 */

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
