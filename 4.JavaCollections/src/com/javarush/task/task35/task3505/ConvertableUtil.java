package com.javarush.task.task35.task3505;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Реализуй логику метода convert в классе ConvertableUtil, который должен возвращать словарь,
значениями которого являются элементы переданного cписка, а ключами являются объекты, полученные
вызовом интерфейсного метода getKey.
*/
public class ConvertableUtil {

    public static <T extends Convertable> Map convert(List<T> list) {
        Map result = new HashMap();

        for (T item: list)
            result.put(item.getKey(), item);

        return result;
    }
}
