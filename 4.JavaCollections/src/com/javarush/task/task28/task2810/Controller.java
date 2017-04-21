package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.Provider;

import java.util.Arrays;

/**
 * Created by Alexey on 21.04.2017.
 */
public class Controller {
    private Provider[] providers;

    public Controller(Provider... providers) throws IllegalArgumentException {
        if (providers.length==0) throw new IllegalArgumentException ();

        this.providers = new Provider [providers.length];
        System.arraycopy(providers,0,this.providers,0,providers.length);
    }

    @Override
    public String toString() {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }
}
