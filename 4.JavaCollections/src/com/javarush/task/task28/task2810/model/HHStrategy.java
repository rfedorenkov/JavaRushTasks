package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Этот класс будет реализовывать конкретную стратегию работы с сайтом поиска работы (https://grc.ua/ и https://hh.ru/).
public class HHStrategy implements Strategy {
    //https://grc.ua/search/vacancy?text=java+ADDITIONAL_VALUE&page=PAGE_VALUE
    //https://grc.ua/search/vacancy?text=java+Kiev&page=3
    //https://hh.ru/search/vacancy?text=java+Kiev&page=3

    private static final String URL_FORMAT = "https://grc.ua/search/vacancy?text=java+%s&page=%d";
    private static final String URL_FORMAT2 = "https://javarush.ru/testdata/big28data.html"; // Hash page
    // String.format(URL_FORMAT, "Kiev", 3);

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        int page = 0;
        try {
            do {
                Document document = getDocument(searchString, page);
                Elements elements = document.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
                if (elements.isEmpty()) {
                    break;
                }
                elements.forEach(element -> {
                    Elements title = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title");
                    Elements salary = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation");
                    Elements city = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address");
                    Elements companyName = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer");
                    Elements url = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title");

                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(title.text());
                    vacancy.setSalary(salary.text());
                    vacancy.setCity(city.text());
                    vacancy.setCompanyName(companyName.text());
                    vacancy.setSiteName("hh.ru");
                    vacancy.setUrl(url.attr("href"));
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