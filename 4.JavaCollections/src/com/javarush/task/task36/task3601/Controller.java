package com.javarush.task.task36.task3601;

import java.util.List;

/**
 * Created by Alexey Vedensky on 13.04.2017.
 * MAIL: avedensky@gmail.com
 */
public class Controller {
    private static Model model = new Model();

    public List<String> onDataListShow() {
        return model.getStringDataList();
    }
}
