package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;

import java.io.IOException;
import java.util.List;

/**
 * Created by Alexey on 21.04.2017.
 */
public interface Strategy {
    List<Vacancy> getVacancies(String searchString);
}
