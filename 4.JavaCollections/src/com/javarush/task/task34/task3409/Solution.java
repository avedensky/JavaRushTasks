package com.javarush.task.task34.task3409;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/* 
Настраиваем логгер

Дан файл log4j.properties, который содержит настройки логгера для разработчиков.
Изменились требования к логированию для продакшена.

Список изменений, которые нужно сделать:
1) Размер файла для логирования не должен превышать 5 мегабайт.
2) Файлы лога должны храниться на диске D в директории log, называться должны runApp.log.
3) Файлы лога должны содержать 6 последних файлов. Если шестой файл уже заполнен (имеет размер 5Мб), то нужно удалить самый первый и создать новый.
4) Уровень вывода сообщений в консоль нужно установить на уровне ERROR.
5) Минимальный уровень логирования выставить в WARN.

Отредактируй файл log4j.properties в соответствии с предоставленными требованиями.


Требования:
1. Размер файла для логирования не должен превышать 5 мегабайт.
2. Файлы лога должны храниться на диске D в директории log, называться должны runApp.log.
3. Файлы лога должны содержать 6 последних файлов. Если шестой файл уже заполнен(имеет размер 5Мб), то нужно удалить самый первый и создать новый.
4. Уровень вывода сообщений в консоль нужно установить на уровне ERROR.
5. Минимальный уровень логирования выставить в WARN.
*/
public class Solution {
    public static void main(String args[]) throws IOException {
        String logProperties = "src/" + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/log4j.properties";
        Path path = Paths.get(logProperties).toAbsolutePath();
        try (InputStream is = new FileInputStream(path.toFile())) {
            Properties properties = new Properties();
            properties.load(is);
        }
    }
}
