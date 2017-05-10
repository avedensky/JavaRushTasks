package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexey on 10.05.2017.
 */



public class MoikrugStrategy implements Strategy {
    //private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java&page=2";
    private static final String URL_FORMAT= "https://moikrug.ru/vacancies?q=java+%s&page=%d";
    //private static final String URL_FORMAT = "http://javarush.ru/testdata/big28data2.html";

    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        List<Vacancy> Vacancies = new ArrayList<>();
        int pageNum = 0;
        Document doc = null;
        while(true)
        {
            try {
                doc = getDocument(searchString, pageNum);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Elements vacancies = doc.getElementsByClass("job");
            if (vacancies.size()==0) break;
            for (Element element: vacancies)
            {
                if (element != null)
                {
                    Vacancy vac = new Vacancy();
                    vac.setTitle(element.getElementsByAttributeValue("class", "title").text());
                    vac.setCompanyName(element.getElementsByAttributeValue("class", "company_name").text());
                    vac.setSiteName(URL_FORMAT);
                    vac.setUrl("https://moikrug.ru" + element.select("a[class=job_icon]").attr("href"));
                    String salary = element.getElementsByAttributeValue("class", "salary").text();
                    String city = element.getElementsByAttributeValue("class", "location").text();
                    vac.setSalary(salary.length()==0 ? "" : salary);
                    vac.setCity(city.length()==0 ? "" : city);
                    Vacancies.add(vac);
                }
            }
            pageNum++;
        }
        return Vacancies;
    }

/*    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        try {
            int page = 0;
            while (true) {
                //System.out.println("--------------------- moikrug.ru ----------------------");
                Document document = getDocument(searchString, page);
                if (document == null) { break; }

                Elements pageElements = document.select("[class=job  ]");
                pageElements.addAll(document.select("[class=job marked]"));
                if (pageElements.size() == 0) { break; }

                String siteName = "https://moikrug.ru";
                for (Element pageElement : pageElements) {
                    Element title = pageElement.select("[class=title]").first();
                    Element companyName = pageElement.select("[class=company_name]").first();
                    Element salary = pageElement.select("[class=salary").first();
                    Element city = pageElement.select("[class=location]").first();
                    String url = siteName + title.select("a[href]").attr("href");

                    Vacancy vacancy = new Vacancy();
                    vacancy.setSiteName("https://moikrug.ru");
                    vacancy.setTitle(title.text());
                    vacancy.setCompanyName(companyName.text());
                    vacancy.setCity( (city != null) ? city.text() : "");
                    vacancy.setUrl(url);
                    vacancy.setSalary( (salary != null) ? salary.text() : "");
                    vacancies.add(vacancy);
                }

                //Next Page
                int oldPage = page;
                String nextPageHref = document.body().getElementsByAttributeValue("data-qa", "pager-next").attr("href");
                if (nextPageHref.contains("page"))
                    page = Integer.parseInt(nextPageHref.substring(nextPageHref.indexOf("page=")).split("=")[1]);
                else
                    break;

                if (oldPage == page)
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vacancies;
    }*/

    protected Document getDocument(String searchString, int page) throws IOException {
        //String url = String.format("%s?q==%s&page=%s",URL_FORMAT, searchString, page);
        String url = String.format(URL_FORMAT, searchString, page);
        return Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36")
                .timeout(5000)
                .referrer("http://google.ru")
                .get();
    }
}

