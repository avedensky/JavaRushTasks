package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.view.View;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexey on 10.05.2017.
 */
/*
2. Добавь два поля — 1) вью, 2) массив провайдеров.

3. Создай конструктор с двумя параметрами — 1) вью, 2) массив провайдеров.
На неправильные данные кинь IllegalArgumentException.

4. Создай публичный метод void selectCity(String city).

5. Реализуй логику метода selectCity:
5.1. получить вакансии с каждого провайдера,
5.2. обновить вью списком вакансий из п.5.1.
*/

public class Model {
    private View view;
    private Provider[] providers;

    public Model(View view, Provider... providers) throws IllegalArgumentException {
        if (view == null || providers == null || providers.length == 0) {
            throw  new IllegalArgumentException("Illegal arguments");
        }
        this.view = view;
        this.providers = providers;
    }

    public void selectCity(String city) {
        List<Vacancy> vacancies = new ArrayList<>();
        for (Provider provider : providers) {
            vacancies.addAll(provider.getJavaVacancies(city));
        }
        view.update(vacancies);
    }
}
