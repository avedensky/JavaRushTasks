package com.javarush.task.task38.task3810;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* 
Реализуй аннотации

Проект должен компилироваться и выводить аннотацию класса Solution.
Класс Solution и его аннотацию не менять.
Аннотация Changelog должна быть видна во время выполнения.


Требования:
1. Вывод на экран должен соответствовать ожидаемому.
2. На экран должна быть выведена аннотация @Changelog класса Solution.
3. Аннотация @Changelog должна быть видна во время выполнения программы.
4. В классе Solution должен быть реализован метод main с одним параметром типа String[].
*/



//@Retention(value= RetentionPolicy.RUNTIME)
@Changelog({
        @Revision(
                revision = 4089,
                date = @Date(year = 2011, month = 5, day = 30, hour = 18, minute = 35, second = 18),
                comment = "Новый файл добавлен"),
        @Revision(
                revision = 6018,
                date = @Date(year = 2013, month = 1, day = 1, hour = 0, minute = 0, second = 1),
                authors = {@Author(value = "Серега", position = Position.MIDDLE)},
                comment = "Фикс багов"),
        @Revision(
                revision = 10135,
                date = @Date(year = 2014, month = 12, day = 31, hour = 23, minute = 59, second = 59),
                authors = {@Author(value = "Диана", position = Position.OTHER),
                        @Author("Игорь"),
                        @Author(value = "Витек", position = Position.SENIOR),
                })
})
public class Solution {
    public static void main(String[] args) {
        System.out.println(Solution.class.getAnnotation(Changelog.class).toString());
    }
}
