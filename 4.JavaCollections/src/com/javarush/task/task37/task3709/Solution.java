package com.javarush.task.task37.task3709;

import com.javarush.task.task37.task3709.connectors.Connector;
import com.javarush.task.task37.task3709.connectors.SecurityProxyConnector;
import com.javarush.task.task37.task3709.connectors.SimpleConnector;

/* 
Security Proxy

Необходимо создать класс SecurityProxyConnector в пакете connectors, который будет производить проверку безопасности
перед подключением. В случае, если проверка не пройдена, соединение не должно быть установлено.

Для клиента (в данном случае класс Solution) использование SecurityProxyConnector ничем не должно отличаться
от использования класса SimpleConnector.

P.S. Тебе понадобятся поля типов SecurityChecker и SimpleConnector в классе SecurityProxyConnector.


Требования:
1. В классе SecurityProxyConnector должно быть создано поле типа SimpleConnector.
2. В классе SecurityProxyConnector должно быть создано поле типа SecurityChecker.
3. Конструктор класса SecurityProxyConnector должен принимать один параметр типа String и инициализировать
поле типа SimpleConnector.
4. Метод connect класса SecurityProxyConnector должен выполнять проверку безопасности с помощью вызова
метода performSecurityCheck у объекта типа SecurityChecker.
5. Если проверка безопасности была пройдена, должно быть выполнено подключение.
6. Если проверка безопасности не была пройдена, подключение не должно быть выполнено.
7. Класс SecurityProxyConnector должен поддерживать интерфейс Connector.
*/
public class Solution {
    public static void main(String[] args) {
        Connector securityProxyConnector = new SecurityProxyConnector("google.com");
        Connector simpleConnector = new SimpleConnector("javarush.ru");

        System.out.println("Connecting with SimpleConnector...");
        simpleConnector.connect();

        System.out.println("----------------------------------------------------");

        System.out.println("Connecting with SecurityProxyConnector...");
        securityProxyConnector.connect();
    }
}
