package com.javarush.task.task27.task2712;

/**
 * Класс планшета директора ресторана.
 */
public class DirectorTablet {

    /**
     * Метод выводит какую сумму заработали на рекламе.
     * Сгруппированно по дням.
     */
    public void printAdvertisementProfit() {

    }

    /**
     * Метод выводит загрузку (рабочее время) повара.
     * Сгруппированно по дням.
     */
    public void printCookWorkloading() {

    }

    /**
     * Метод выводит список активных роликов и оставшееся
     * количество показов по каждому.
     */
    public void printActiveVideoSet() {

    }

    /**
     * Метод выводит список неактивных роликов.
     * Количество показов равно нулю.
     */
    public void printArchivedVideoSet() {

    }
}



//
//
//Requirements:
//1. В классе DirectorTablet должны быть созданы методы перечисленные в условии задачи.
//2. В методе main класса Restaurant должен быть создан новый DirectorTablet и вызваны методы отображения статистики.
//3. В интерфейсе EventDataRow должны быть объявлены методы getDate и getTime.
//4. В классе StatisticManager должен быть реализован метод register с одним параметром типа Cook, регистрирующий полученного повара в множестве всех поваров (cooks).