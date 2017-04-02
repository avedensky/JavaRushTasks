package com.javarush.task.task32.task3212;

import com.javarush.task.task32.task3212.service.Service;

/* 
Service Locator

Прочитать о паттерне Service locator.

Реализуй логику метода getService(String jndiName) в ServiceLocator.
В нем будет реализована работа с контекстом и кэшем.

1) Верни из кэша нужный сервис.
2) Если в кэше нет нужного сервиса то:
2.1) Создай контекст.
2.2) Возьми у контекста нужный сервис.
2.3) Добавь сервис в кеш и верни его.


Требования:
1. Класс ServiceLocator должен содержать метод Service getService(String jndiName).
2. Если нужный сервис находится в кэше, метод getService(String jndiName) должен возвращать сервис из кэша.
3. Если нужный сервис НЕ находится в кэше, метод getService(String jndiName) должен создавать контекст.
4. Если нужный сервис НЕ находится в кэше, метод getService(String jndiName) должен искать нужный сервис в контексте.
5. Если нужный сервис НЕ находится в кэше, метод getService(String jndiName) должен добавлять в кэш сервис, найденный в контексте и возвращать его.

*/

public class Solution {
    public static void main(String[] args) {
        Service service = ServiceLocator.getService("EJBService");
        service.execute();
        System.out.println();
        service = ServiceLocator.getService("JMSService");
        service.execute();
        System.out.println();
        service = ServiceLocator.getService("EJBService");
        service.execute();
        System.out.println();
        service = ServiceLocator.getService("JMSService");
        service.execute();

    }

}
