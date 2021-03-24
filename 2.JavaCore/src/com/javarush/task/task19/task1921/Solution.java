package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Хуан Хуанович
 * В метод main первым параметром приходит имя файла.
 * В этом файле каждая строка имеет следующий вид:
 * имя день месяц год
 * где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
 * [день] - int, [месяц] - int, [год] - int
 * данные разделены пробелами.
 *
 * Заполнить список PEOPLE используя данные из файла.
 * Закрыть потоки.
 *
 * Пример входного файла:
 * Иванов Иван Иванович 31 12 1987
 * Вася 15 5 2013
 *
 *
 * Требования:
 * 1. Класс Solution должен содержать публичную константу PEOPLE типа List<Person>, которая должна
 * быть сразу проинициализирована.
 * 2. Программа НЕ должна считывать данные с консоли.
 * 3. Программа должна считывать содержимое файла (используй FileReader).
 * 4. Поток чтения из файла (FileReader) должен быть закрыт.
 * 5. Программа должна заполнить список PEOPLE данными из файла.
 * 6. Программа должна правильно работать с двойными именами, например Анна-Надежда.
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<>();

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("USE args filename");
            System.exit(1);
        }

        fillListWithPeople(args[0]);
    }

    public static void fillListWithPeople(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            SimpleDateFormat format  = new SimpleDateFormat("dd MM yyyy");
            while (reader.ready()) {
                String line = reader.readLine();
                String name = line.replaceAll("\\p{Digit}", "").trim();
                String data = line.replaceAll("\\P{Digit}", " ").trim();
                Date birthday = format.parse(data);
                PEOPLE.add(new Person(name, birthday));
            }
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
