package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;



/**
 * Created by Alexey on 21.04.2017.
 */

/*
Открой сайт ХэдХантер — http://hh.ua/ или http://hh.ru/
В строке поиска набери «java Киев«, снизу перейди на вторую страницу, т.к. урлы часто отличаются на первой
странице и далее.
У меня получилась такая ссылка:
http://hh.ua/search/vacancy?text=java+Киев&page=1
Из этого следует, что
1) если тебе нужно будет фильтровать по городу, то ты добавишь его после слова java, разделив их знаком «+«,
2) нумерация страниц начинается с 0.

Итак, ссылка будет примерно такой:
http://hh.ua/search/vacancy?text=java+ADDITIONAL_VALUE&page=PAGE_VALUE

1. Из полученной ссылки в HHStrategy создай приватную строковую константу URL_FORMAT, которая
будет передаваться в String.format.
String.format(URL_FORMAT, «Kiev», 3) должно равняться
«http://hh.ua/search/vacancy?text=java+Kiev&page=3»
или
«http://hh.ru/search/vacancy?text=java+Kiev&page=3»
Для этого скопируйте ссылку в код и нажмите на ней нужную комбинацию клавиш.
Ctrl+Alt+C(Constant) — создание констант,
Ctrl+Alt+M(Method) — создание методов,
Ctrl+Alt+V(Variable) — создание переменных.

2. Тебе нужно программно получить исходный код страницы. Это HTTP запрос. Тебе понадобится Java HTML Parser.
Хороший парсер jsoup, будешь использовать его.
Найди сайт jsoup — Java HTML Parser, скачай с него либу версии и 1.9.2 и ее сорцы(sources). Класть их внутрь проекта не нужно!

3. Подключи новые либы:
В IDEA открой Project Structure (в меню File).
Слева выбери Project Settings -> Libraries, в окошке справа сверху нажми «+«.
Выбери «Java«, если либы еще не нет, либо «Attach Files or Directories«, чтоб добавить джарники к существующей либе.
В диалоговом окне открой путь к папке из п.2, открой саму папку и выбери все либы — *.jar файлы.

4. Прочитай дополнительный материал к лекции в Сообществе.


Требования:
1. В классе HHStrategy создай приватную строковую константу URL_FORMAT.
2. Результат команды String.format(URL_FORMAT, String, int) должен генерироваться согласно заданию.
3. Для выполнения дальнейших указаний, подключи библиотеку jsoup версии 1.9.2 (проверка этого требования не выполняется).
 */


public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";
    String userAgent = "Mozilla/5.0";
    String referrer = "http://google.ru";

    @Override
    public List<Vacancy> getVacancies(String searchString){
        List<Vacancy> list = new ArrayList<>();
        int page = 1;
        try {
            Document document = Jsoup.connect(URL_FORMAT).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
