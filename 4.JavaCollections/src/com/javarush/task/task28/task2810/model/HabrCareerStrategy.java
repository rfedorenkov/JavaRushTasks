package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HabrCareerStrategy implements Strategy {

    private static final String URL_FORMAT = "https://career.habr.com/vacancies?q=java+%s&page=%d";
    private static final String URL_FORMAT2 = "https://javarush.ru/testdata/big28data2.html"; // hash

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        int page = 0;
        try {
            do {
                Document document = getDocument(searchString, page);
                Elements elements = document.getElementsByClass("job");
                if (elements.isEmpty()) {
                    break;
                }
                elements.forEach(element -> {
                    Elements title = element.getElementsByClass("title");
                    Elements salary = element.getElementsByClass("salary");
                    Elements city = element.getElementsByClass("location");
                    Elements companyName = element.getElementsByAttributeValue("class", "company_name");
                    Elements url = element.getElementsByTag("a");
//
                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(title.text());
                    vacancy.setSalary(salary.text());
                    vacancy.setCity(city.text());
                    vacancy.setCompanyName(companyName.text());
                    vacancy.setSiteName("career.habr.com");
                    vacancy.setUrl("https://career.habr.com" + url.get(0).attr("href"));
                    vacancies.add(vacancy);
                });
                page++;
            } while (true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        return Jsoup.connect(String.format(URL_FORMAT, searchString, page))
                .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.1 Safari/605.1.15")
                .referrer("https://grc.ua/")
                .get();
    }
}