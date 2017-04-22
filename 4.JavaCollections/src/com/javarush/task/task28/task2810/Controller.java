package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alexey on 21.04.2017.
 */
public class Controller {
    private Provider[] providers;

    public Controller(Provider... providers) throws IllegalArgumentException {
        if (providers.length == 0)
            throw new IllegalArgumentException();

        this.providers = new Provider[providers.length];
        System.arraycopy(providers, 0, this.providers, 0, providers.length);
    }

    @Override
    public String toString() {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }

    public void scan() {
        try {
            int total = 0;
            for (Provider provider : providers) {
                List<Vacancy> vacancy = provider.getJavaVacancies("java");
                total += vacancy.size();
            }
            System.out.println(total);
        } catch (NullPointerException e) {
            return;
        }

    }
}
