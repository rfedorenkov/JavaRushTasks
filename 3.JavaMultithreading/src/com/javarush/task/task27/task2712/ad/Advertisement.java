package com.javarush.task.task27.task2712.ad;

/**
 * Класс с рекламным объявлением.
 * Реклама - это видео определенной продолжительности.
 * Так же, кто-то оплатил количество показов.
 * Известно общая стоимость всех показов и сам рекламный ролик.
 */
public class Advertisement implements Comparable<Advertisement> {
    // Видео
    private Object content;
    // Имя
    private String name;
    // Начальная сумма, стоимость рекламы в копейках
    private long initialAmount;
    // Количество оплаченных показов
    private int hits;
    // Продолжительность в секундах
    private int duration;
    // Стоимость одного показа рекламы в копейках
    private long amountPerOneDisplaying;

    /**
     * Конструктор рекламного объявления.
     *
     * @param content       Видео.
     * @param name          Имя / название.
     * @param initialAmount Начальная сумма, стоимость рекламы в копейках.
     * @param hits          Количество оплаченных показов.
     * @param duration      Продолжительность в секундах.
     */
    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        //Проверяем, что не возникает исключения деления на ноль, если количество показов (hits) равно нулю.
        if (hits > 0) {
            this.amountPerOneDisplaying = initialAmount / hits;
        }
    }

    /**
     * Геттер поля name.
     *
     * @return Возвращает имя рекламного ролика.
     */
    public String getName() {
        return name;
    }

    /**
     * Геттер поля duration.
     *
     * @return Возвращает продолжительность рекламного ролика.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Геттер поля amountPerOneDisplaying.
     *
     * @return Возвращает стоимость 1 ролика в копейках.
     */
    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    /**
     * Метод вычисляет стоимость показа одной секунды рекламного ролика.
     *
     * @return Возвращает стоимость (в тысячных частях копейки).
     */
    public long getCostOfShowingOneSecondInPenny() {
        return amountPerOneDisplaying * 1000 / duration;
    }

    /**
     * Метод уменьшает количество показов.
     *
     * @throws UnsupportedOperationException Если количество показов не положительное число;
     */
    public void revalidate() throws UnsupportedOperationException {
        if (hits <= 0) {
            throw new UnsupportedOperationException();
        }
        hits--;
    }

    /**
     * Метод сравнивает две рекламы 2 раза.
     * 1) В порядке уменьшения стоимости показа одного рекламного ролика (в копейках).
     * 2) По увеличению стоимости показа одной секунды рекламного ролика (в тысячных частях копейки).
     *
     * @param other Рекламный ролик.
     * @return Возвращает число сравнений (0 если равны)
     */
    @Override
    public int compareTo(Advertisement other) {
        final int result = Long.compare(other.amountPerOneDisplaying, this.amountPerOneDisplaying);
        return result != 0 ? result :
                Long.compare(this.getCostOfShowingOneSecondInPenny(), other.getCostOfShowingOneSecondInPenny());
    }

    @Override
    public String toString() {
        return String.format("%s is displaying... %d, %d",
                            name, amountPerOneDisplaying, getCostOfShowingOneSecondInPenny());
    }
}


