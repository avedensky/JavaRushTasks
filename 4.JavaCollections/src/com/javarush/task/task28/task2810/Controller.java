package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.Model;
import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.vo.Vacancy;

import javax.jws.WebParam;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alexey on 21.04.2017.
 */

/*
1. Добавь в Controller новое поле Model model.

2. Удали метод scan() из Controller, его логика переместилась в модель.

3. Удали конструктор, toString и поле providers из контроллера.

4. Создай конструктор в Controller с аргументом Model.
На некорректные данные брось IllegalArgumentException

5. В Controller создай публичный метод void onCitySelect(String cityName), в котором вызови нужный метод модели.

6. Удали код из метода main. Этот код уже не валидный.
*/
public class Controller {
    private Model model;

    public Controller(Model model) {
        if (model == null)
            throw new IllegalArgumentException();
        this.model = model;
    }

    public void onCitySelect(String cityName) {
        model.selectCity(cityName);
    }
}
