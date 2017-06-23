package com.javarush.task.task24.task2409;

import java.util.List;

/*
Интернет-магазин продажи джинсов

Интернет-магазин продажи джинсов
1. Создай 2 интерфейса в отдельных файлах:
1.1) Item с методами int getId(), double getPrice(), String getTM()
1.2) Jeans extends Item с методами int getLength() и int getSize()

2. В классе Util в методе getAllJeans добавь пропущенную часть java-кода:
2.1) разберись в том, что уже есть в методе getAllJeans класса Util
2.2) создай абстрактный class AbstractJeans от интерфейса Jeans с одним абстрактным методом, реализуй остальные методы
2.3) создай классы Levis и Denim от AbstractJeans, реализуй оставшийся метод
2.4) в классе AbstractJeans реализуй метод toString() (можешь воспользоваться Alt+Insert -> toString())
2.5) метод toString класса AbstractJeans должен начинаться с имени сабкласса, например, Levis{id=1, length=34, size=6, price=150.0}


Требования:
1. Интерфейс Item должен быть создан в отдельном файле.
2. Интерфейс Jeans должен расширять интерфейс Item и быть создан в отдельном файле.
3. В интерфейсе Item должны присутствовать все методы перечисленные в условии.
4. В классе Jeans должны присутствовать все методы перечисленные в условии.
5. В методе getAllJeans класса Util должен быть создан локальный абстрактный класс AbstractJeans, поддерживающий интерфейс Jeans.
6. В методе getAllJeans класса Util должен быть создан локальный класс Levis, унаследованный от класса AbstractJeans.
7. В методе getAllJeans класса Util должен быть создан локальный класс Denim, унаследованный от класса AbstractJeans.
*/
public class Solution {

    public static List<Jeans> allJeans = Util.getAllJeans();

    public static void main(String[] args) {
        for (Jeans jeans : allJeans) {
            System.out.println(jeans);
        }
    }

}
