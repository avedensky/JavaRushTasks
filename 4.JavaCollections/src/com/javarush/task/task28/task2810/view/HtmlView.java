package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.List;

/**
 * Created by Alexey on 10.05.2017.
 */

public class HtmlView implements View {
    private Controller controller;

    @Override
    public void update(List<Vacancy> vacancies) {
        System.out.println(vacancies.size());

    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Odessa");
    }
}
