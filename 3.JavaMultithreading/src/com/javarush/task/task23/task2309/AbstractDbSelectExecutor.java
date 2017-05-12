package com.javarush.task.task23.task2309;

import com.javarush.task.task23.task2309.vo.*;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDbSelectExecutor<T extends NamedItem> {

    public abstract String getQuery();

    /**
     * It's fake method
     *
     * @return a list of 5 fake items
     */
    public List<T> execute() {
        List<T> result = new ArrayList<>();
        //assert the query is not null
        String query = getQuery();
        if (query == null) return result;

        try {
            //generate 5 fake items
            for (int i = 1; i <= 5; i++) {
                T newItem = getNewInstanceOfGenericType();
                newItem.setId(i);
                newItem.setName(newItem.getClass().getSimpleName() + "-" + i);
                newItem.setDescription("Got by executing '" + query + "'");
                result.add(newItem);
            }
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }

    //reflection
    //you have to know that it is possible to create new instance of T (generic type) class by using its default constructor
    private T getNewInstanceOfGenericType() throws InstantiationException, IllegalAccessException {
        return (T) ((Class) ((ParameterizedType) this.getClass().
                getGenericSuperclass()).getActualTypeArguments()[0]).newInstance();
    }
}
