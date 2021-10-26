package com.javarush.task.task28.task2810.model;

//Этот класс будет реализовывать конкретную стратегию работы с сайтом поиска работы (https://grc.ua/ и https://hh.ru/).
public class HHStrategy implements Strategy {
    //https://grc.ua/search/vacancy?text=java+ADDITIONAL_VALUE&page=PAGE_VALUE
    //https://grc.ua/search/vacancy?text=java+Kiev&page=3
    //https://hh.ru/search/vacancy?text=java+Kiev&page=3

    private static final String URL_FORMAT = "https://grc.ua/search/vacancy?text=java+%s&page=%s";
    // String.format(URL_FORMAT, "Kiev", 3);
}