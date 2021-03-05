package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * CRUD
 * CrUD - Create, Update, Delete.
 *
 * Программа запускается с одним из следующих наборов параметров:
 * -c name sex bd
 * -u id name sex bd
 * -d id
 * -i id
 *
 * Значения параметров:
 * name - имя, String
 * sex - пол, "м" или "ж", одна буква
 * bd - дата рождения в следующем формате 15/04/1990
 * -c - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
 * -u - обновляет данные человека с данным id
 * -d - производит логическое удаление человека с id, заменяет все его данные на null
 * -i - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)
 *
 * id соответствует индексу в списке.
 * Все люди должны храниться в allPeople.
 * Используй Locale.ENGLISH в качестве второго параметра для SimpleDateFormat.
 *
 * Пример параметров:
 * -c Миронов м 15/04/1990
 *
 * Пример вывода для параметра -і:
 * Миронов м 15-Apr-1990
 *
 *
 * Требования:
 * 1. Класс Solution должен содержать public static поле allPeople типа List<Person>.
 * 2. Класс Solution должен содержать статический блок, в котором добавляются два человека в список allPeople.
 * 3. При запуске программы с параметром -с программа должна добавлять человека с заданными параметрами
 * в конец списка allPeople, и выводить id (index) на экран.
 * 4. При запуске программы с параметром -u программа должна обновлять данные человека
 * с заданным id в списке allPeople.
 * 5. При запуске программы с параметром -d программа должна логически удалять человека
 * с заданным id в списке allPeople.
 * 6. При запуске программы с параметром -i программа должна выводить на экран данные о человеке
 * с заданным id по формату указанному в задании.
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {

        if (args.length < 2) {
            System.exit(0);
        }

        switch (args[0]) {
            case "-c" :
                create(args);
                break;
            case "-u" :
                update(args);
                break;
            case "-d" :
                int id = Integer.parseInt(args[1]);
                delete(id);
                break;
            case "-i" :
                id = Integer.parseInt(args[1]);
                info(id);
                break;
        }
    }

    private static void create(String[] args) throws ParseException {
        String name = args[1];
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date birthday = sdf.parse(args[3]);
        Person person = args[2].equals("м")
                ? Person.createMale(name, birthday) : Person.createFemale(name, birthday);
        allPeople.add(person);
        System.out.println(allPeople.size() - 1);
    }

    private static void update(String[] args) throws ParseException {
        int id = Integer.parseInt(args[1]);
        String name = args[2];
        Sex sex = args[3].equals("м") ? Sex.MALE : Sex.FEMALE;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date birthday = sdf.parse(args[4]);

        Person person = allPeople.get(id);
        person.setName(name);
        person.setSex(sex);
        person.setBirthDate(birthday);
    }

    private static void delete(int id) {
        Person person = allPeople.get(id);
        person.setName(null);
        person.setSex(null);
        person.setBirthDate(null);
    }

    private static void info(int id) {
        Person person = allPeople.get(id);
        String name = person.getName();
        String sex = person.getSex() == Sex.MALE ? "м" : "ж";
        Date birthday = person.getBirthDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        System.out.printf("%s %s %s%n", name, sex, sdf.format(birthday));
    }
}
