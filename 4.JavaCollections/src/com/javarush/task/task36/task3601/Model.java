package com.javarush.task.task36.task3601;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexey Vedensky on 13.04.2017.
 * MAIL: avedensky@gmail.com
 */
public class Model {
    private static Service service = new Service();

    public List<String> getStringDataList() {
        return service.getData();
    }
}
