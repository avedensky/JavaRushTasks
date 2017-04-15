package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/*
Первая стратегия готова, пришло время ее протестить. Для этого:
6.1. Создай класс Solution, если ты не сделал это раньше.
6.2. Добавь в класс Solution реализации вспомогательных статических методов:
6.2.1. Set<Long> getIds(Shortener shortener, Set<String> strings).
Этот метод должен для переданного множества строк возвращать множество идентификаторов.
Идентификатор для каждой отдельной строки нужно получить, используя shortener.
6.2.2. Set<String> getStrings(Shortener shortener, Set<Long> keys).
Метод будет возвращать множество строк, которое соответствует переданному множеству идентификаторов.
При реальном использовании Shortener, задача получить из множества строк множество идентификаторов и наоборот скорее всего не встретится, это нужно исключительно для тестирования.
6.2.3. testStrategy(StorageStrategy strategy, long elementsNumber). Метод будет тестировать работу переданной стратегии на определенном количестве элементов elementsNumber. Реализация метода должна:
6.2.3.1. Выводить имя класса стратегии. Имя не должно включать имя пакета.
6.2.3.2. Генерировать тестовое множество строк, используя Helper и заданное количество элементов elementsNumber.
6.2.3.3. Создавать объект типа Shortener, используя переданную стратегию.
6.2.3.4. Замерять и выводить время необходимое для отработки метода getIds для заданной стратегии и заданного множества элементов. Время вывести в миллисекундах. При замере времени работы метода можно пренебречь переключением процессора на другие потоки, временем, которое тратится на сам вызов, возврат значений и вызов методов получения времени (даты). Замер времени произведи с использованием объектов типа Date.
6.2.3.5. Замерять и выводить время необходимое для отработки метода getStrings для заданной стратегии и полученного в предыдущем пункте множества идентификаторов.
6.2.3.6. Сравнивать одинаковое ли содержимое множества строк, которое было сгенерировано и множества, которое было возвращено методом getStrings. Если множества одинаковы, то выведи «Тест пройден.«, иначе «Тест не пройден.«.
6.2.4. Добавь метод main(). Внутри метода протестируй стратегию HashMapStorageStrategy с помощью 10000 элементов.
6.3. Проверь, что программа работает и тест пройден.


Требования:
1. Метод getIds должен для переданного множества строк возвращать множество идентификаторов.
2. Метод getStrings должен для переданного множества идентификаторов возвращать множество строк.
3. Метод testStrategy должен выводить на экран имя класса стратегии.
4. Метод testStrategy должен генерировать тестовое множество строк используя метод getRandomString класса Helper (количество элементов должно быть равно параметру elementsNumber).
5. Метод testStrategy должен создавать объект типа Shortener используя переданную стратегию.
6. Метод testStrategy должен замерять количество времени выполнения методов getIds и getStrings используя объекты типа Date.
7. Метод testStrategy должен сравнивать количество сгенерированных строк и строк в множестве полученном в результате работы метода getStrings и выводить на экран результат прохождения теста.
8. В методе main должен быть вызван метод testStrategy.
 */


/**
 * Created by Alexey Vedensky on 14.04.2017.
 * MAIL: avedensky@gmail.com
 */
public class Solution {
    public static void main(String[] args) {
        StorageStrategy strategy = new HashMapStorageStrategy();
        testStrategy(strategy, 10000);


    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> result = new HashSet<>();
        for (String s : strings)
            result.add(shortener.getId(s));

        return result;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> result = new HashSet<>();
        for (Long id : keys)
            result.add(shortener.getString(id));

        return result;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        //6.2.3.1. Выводить имя класса стратегии. Имя не должно включать имя пакета.
        System.out.println(strategy.getClass().getSimpleName());


        //6.2.3.2. Генерировать тестовое множество строк
        Set<String> strings = new HashSet<>();
        Long[] elements = new Long[(int) elementsNumber];

        for (int i = 0; i < elementsNumber; i++)
            strings.add(Helper.generateRandomString());

        //6.2.3.3. Создавать объект типа Shortener, используя переданную стратегию.
        Shortener shortener = new Shortener(strategy);

        //6.2.3.4. Замерять и выводить время необходимое для отработки метода getIds для заданной стратегии
        Date startDateTime = new Date();
        Set<Long> ids = getIds(shortener, strings);
        Date finishDateTime = new Date();

        long deltaTime = finishDateTime.getTime() - startDateTime.getTime();
        Helper.printMessage(Long.toString(deltaTime));

        //6.2.3.5. Замерять и выводить время необходимое для отработки метода getStrings для заданной стратегии
        startDateTime = new Date();
        Set<String> strs = getStrings(shortener, ids);
        finishDateTime = new Date();

        deltaTime = finishDateTime.getTime() - startDateTime.getTime();
        Helper.printMessage(Long.toString(deltaTime));


        //6.2.3.6. Сравнивать одинаковое ли содержимое множества строк, которое было сгенерировано и множества, которое было возвращено методом getStrings.
        if (strings.equals(strs))
            Helper.printMessage("Тест пройден.");
        else
            Helper.printMessage("Тест не пройден.");


    }
}
