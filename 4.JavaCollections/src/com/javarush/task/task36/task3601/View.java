package com.javarush.task.task36.task3601;

import java.util.List;

/**
 * Created by Alexey Vedensky on 13.04.2017.
 * MAIL: avedensky@gmail.com
 */
public class View {
    private static Controller controller = new Controller();

    public void fireEventShowData() {
        System.out.println(controller.onDataListShow());
    }
}
