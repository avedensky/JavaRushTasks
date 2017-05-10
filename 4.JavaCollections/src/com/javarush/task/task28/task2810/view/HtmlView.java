package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.List;

/**
 * Created by Alexey on 10.05.2017.
 */

//2. В пакете view создай класс HtmlView от View.
//3. В классе HtmlView создай поле контроллер, используй его для реализации одного из методов интерфейса.
public class HtmlView implements View {
    private Controller controller;

    @Override
    public void update(List<Vacancy> vacancies) {

    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }
}
