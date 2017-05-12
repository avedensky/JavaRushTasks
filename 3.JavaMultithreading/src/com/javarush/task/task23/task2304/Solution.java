package com.javarush.task.task23.task2304;

import java.util.List;
import java.util.Map;

/*
Inner 3

Внутри класса Solution:
1) реализуйте private class TaskDataProvider используя Task и DbMock, цель которого — обновить поле tasks.
2) реализуйте private class NameDataProvider используя String и DbMock, цель которого — обновить поле names.


Требования:
1. Класс TaskDataProvider должен быть создан внутри класса Solution и быть приватным.
2. Класс NameDataProvider должен быть создан внутри класса Solution и быть приватным.
3. Класс TaskDataProvider должен реализовывать интерфейс DbDataProvider с параметром типа Task.
4. Класс NameDataProvider должен реализовывать интерфейс DbDataProvider с параметром типа String.
5. Метод refreshAllData в классе TaskDataProvider должен сохранять в список tasks результат работы
метода getFakeTasks класса DbMock.
6. Метод refreshAllData в классе NameDataProvider должен сохранять в список names результат работы
метода getFakeNames класса DbMock.
*/
public class Solution {

    private List<Task> tasks;
    private List<String> names;

    private DbDataProvider taskDataProvider = new TaskDataProvider();
    private DbDataProvider nameDataProvider = new NameDataProvider();

    public void refresh() {
        Map taskCriteria = ViewMock.getFakeTasksCriteria();
        taskDataProvider.refreshAllData(taskCriteria);

        Map nameCriteria = ViewMock.getFakeNamesCriteria();
        nameDataProvider.refreshAllData(nameCriteria);
    }

    private interface DbDataProvider<T> {
        void refreshAllData(Map criteria);
    }

    class Task {
    }



    private class TaskDataProvider implements DbDataProvider<Task>{
        @Override
        public void refreshAllData(Map criteria) {
            tasks = DbMock.getFakeTasks(criteria);
        }
    }

    private class NameDataProvider implements DbDataProvider<String>{
        @Override
        public void refreshAllData(Map criteria) {
            names = DbMock.getFakeNames(criteria);
        }
    }

    public static void main(String[] args) {

    }

}
