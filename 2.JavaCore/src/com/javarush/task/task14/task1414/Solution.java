package com.javarush.task.task14.task1414;

import java.util.Scanner;

/**
 * MovieFactory
 * У нас есть кинофабрика, но она работает не в полную силу.
 * Давай расширим ее функционал по аналогии с тем, что уже есть, и добавим чтение с консоли.
 * Вот что тебе нужно сделать для успешного решения:
 * Разобраться, что программа умеет делать.
 * Все классы должны быть внутри класса Solution.
 * Добавить классы Cartoon, Thriller.
 * Разобраться, как мы получаем объект класса SoapOpera по ключу "soapOpera".
 * Аналогично получению объекта SoapOpera сделать:
 * добавить в MovieFactory.getMovie получение объекта Cartoon для ключа "cartoon".
 * добавить в MovieFactory.getMovie получение объекта Thriller для ключа "thriller".
 * Считать с консоли несколько ключей (строк).
 * Важно: ввод заканчивается, как только вводится строка не совпадающая с одной из:
 * "cartoon", "thriller", "soapOpera".
 *
 * Создать переменную movie типа Movie и для каждой введенной строки (ключа):
 * получить объект используя MovieFactory.getMovie и присвоить его переменной movie.
 * вывести на экран movie.getClass().getSimpleName().
 *
 * Требования:
 * 1. Классы Cartoon и Thriller должны быть статическими и существовать внутри класса Solution.
 * 2. Метод MovieFactory.getMovie должен возвращать объект типа Cartoon при передаче ему
 * строки "cartoon" в качестве параметра.
 * 3. Метод MovieFactory.getMovie должен возвращать объект типа Thriller при передаче ему
 * строки "thriller" в качестве параметра.
 * 4. Метод main должен считывать строки с клавиатуры.
 * 5. Метод main должен прекращать считывать строки с клавиатуры, если была введена некорректная строка
 * (не "cartoon", не "thriller" или не "soapOpera").
 * 6. Для каждой введенной строки (в том числе для некорректной) необходимо вызвать метод MovieFactory.getMovie().
 * 7. Для всех введенных корректных строк необходимо вывести на экран простые имена
 * (movie.getClass().getSimpleName()) типов объектов, возвращаемых методом MovieFactory.getMovie().
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Movie movie = MovieFactory.getMovie(scanner.next());
            if (movie == null) {
                break;
            }
            System.out.println(movie.getClass().getSimpleName());
        }
        scanner.close();

    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            if ("soapOpera".equals(key)) {
                return new SoapOpera();
            } else if ("cartoon".equals(key)) {
                return new Cartoon();
            } else if ("thriller".equals(key)) {
                return new Thriller();
            }

            return null;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    static class Cartoon extends Movie {

    }

    static class Thriller extends Movie {

    }
}
