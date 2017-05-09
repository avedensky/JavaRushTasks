package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.HHStrategy;
import com.javarush.task.task28.task2810.model.Provider;


/**
 * Created by Alexey on 21.04.2017.
 */

//5 Задание валидатор не пропускает
//Вызов main не должен кидать NullPointerException. Поставь заглушки в необходимых местах.
public class Aggregator {
    public static void main(String[] args) {
            Provider provider = new Provider(new HHStrategy());
            Controller controller = new Controller(provider);
            controller.scan();
    }
}
