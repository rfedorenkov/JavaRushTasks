package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

//Этот класс будет реализовывать конкретную стратегию работы с сайтом поиска работы (https://grc.ua/ и https://hh.ru/).
public class HHStrategy implements Strategy {
    //https://grc.ua/search/vacancy?text=java+ADDITIONAL_VALUE&page=PAGE_VALUE
    //https://grc.ua/search/vacancy?text=java+Kiev&page=3
    //https://hh.ru/search/vacancy?text=java+Kiev&page=3

    private static final String URL_FORMAT = "https://grc.ua/search/vacancy?text=java+%s&page=%d";
    // String.format(URL_FORMAT, "Kiev", 3);

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        try {
            Document document = Jsoup.connect(String.format(URL_FORMAT, "Moscow", 0))
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.1 Safari/605.1.15")
                    .referrer("https://grc.ua/")
                    .get();
//            System.out.println(document.html());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}