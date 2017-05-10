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
ВНИМАНИЕ: ОСОБЕННОСТИ ТЕСТИРОВАНИЯ!
HTML код странички ХэдХантера может меняться, чтобы эта задача продолжила работать стабильно
не меняя тесты воспользуйся закешированной версией http://javarush.ru/testdata/big28data.html
Это только для этого пункта, в следующих заданиях используй реальные страницы.

1. В классе HHStrategy создай protected метод Document getDocument(String searchString, int page) throws IOException.

2. Реализуй следующую логику метода getVacancies в классе HHStrategy:
2.1. Приконнекться к закешированной страничке ХэдХантера используя метод getDocument, нумерация начинается с 0.
2.2. Получи список элементов с атрибутом «vacancy-serp__vacancy«. Должно быть до 20 вакансий на странице.
2.3. Если данные в списке из п.2.2 есть, то для каждого элемента:
2.3.1. создать вакансию и заполнить все ее данные, получив данные из текущего элемента.
Если тег с зарплатой присутствует, то заполнить и поле salary, иначе инициализировать поле пустой строкой.
2.4. Выполнить п.2.1-2.3 для следующей страницы ХэдХантера.
2.5. Если закончились страницы с вакансиями, то выйти из цикла.

Исключения игнорировать.
Все вакансии добавить в общий список и вернуть в качестве результата метода.

Подсказка по зарплате:
Поиграйся с URL_FORMAT, добавь туда еще один параметр, чтобы получить вакансии с зарплатами.
Проанализируй полученный html и найди тег для зарплаты.
Не забудь потом вернуть значение URL_FORMAT обратно.


Требования:
1. В классе HHStrategy создай protected метод getDocument(String searchString, int page). Перенеси туда логику
по получению объекта html-страницы Document.
2. Метод getVacancies класса HHStrategy должен получать содержимое страниц с помощью метода getDocument.
Начни с 0 страницы.
3. Из объекта Document получи список html-элементов с атрибутом "vacancy-serp__vacancy". Для каждого элемента
создай объект вакансии и добавь его в возвращающий методом список.
4. Нужно последовательно обработать все страницы результатов поиска. Как только страницы с вакансиями закончатся,
прерви цикл и верни список найденных вакансий.
5. У каждой вакансии должно быть заполнено поле title полученными из html-элемента данными о названии вакансии.
6. У каждой вакансии должно быть заполнено поле url полученной из html-элемента ссылкой на вакансию.
7. У каждой вакансии должно быть заполнено поле city полученными из html-элемента данными о городе.
8. У каждой вакансии должно быть заполнено поле companyName полученными из html-элемента данными о компании.
9. У каждой вакансии должно быть заполнено поле siteName значением сайта, на котором вакансия была найдена.
10. Поле salary у вакансии должно быть заполнено, если в html-элементе присутствовал тег с зарплатой. Иначе поле
должно быть инициализировано пустой строкой.
11. Если ты менял значение поля URL_FORMAT, не забудь вернуть его обратно.

 */
public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";
    //private static final String URL_FORMAT = "http://javarush.ru/testdata/big28data.html";
    String userAgent = "Mozilla/5.0";
    String referrer = "http://google.ru";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> list = new ArrayList<>();
        int page = 0;
        try {
            while (true) {
                Document document = getDocument(searchString, page);
                if (document == null)
                    break;
                page++;
                Elements elements = document.body().getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
                if (!elements.isEmpty()) {
                    for (Element element : elements) {
                        Vacancy vacancy = new Vacancy();
                        vacancy.setSiteName("http://hh.ua");
                        vacancy.setUrl(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").attr("href"));
                        vacancy.setCity(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address").text());
                        vacancy.setCompanyName(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").text());
                        vacancy.setTitle(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").text());
                        String salary = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").text();
                        vacancy.setSalary(salary != null ? salary : "");
                        list.add(vacancy);
                    }
                } else break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        String url = String.format(URL_FORMAT, searchString, page);
        return Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36")
                .timeout(5000)
                .referrer("http://google.ru")
                .get();
    }

//    protected Document getDocument(String searchString, int page) throws IOException {
//        return Jsoup.connect(URL_FORMAT)
//                .userAgent(userAgent)
//                .referrer(referrer)
//                .get();
//    }
}
