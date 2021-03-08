package com.javarush.task.task19.task1903;

import java.util.HashMap;
import java.util.Map;

/**
 * Адаптация нескольких интерфейсов
 * Адаптируй IncomeData к Customer и Contact.
 * Классом-адаптером является IncomeDataAdapter.
 * Инициализируй countries перед началом выполнения программы. Соответствие кода страны и названия:
 * UA Ukraine
 * RU Russia
 * CA Canada
 * Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры).
 * Обратите внимание на формат вывода фамилии и имени человека.
 *
 *
 * Требования:
 * 1. Класс Solution должен содержать public static поле countries типа Map<String, String>.
 * 2. В статическом блоке класса Solution инициализируй поле countries тестовыми данными согласно заданию.
 * 3. Класс IncomeDataAdapter должен реализовывать интерфейсы Customer и Contact.
 * 4. Класс IncomeDataAdapter должен содержать приватное поле data типа IncomeData.
 * 5. Класс IncomeDataAdapter должен содержать конструктор с параметром IncomeData.
 * 6. В классе IncomeDataAdapter реализуй методы интерфейсов Customer и Contact используя подсказки
 * в виде комментариев в интерфейсах.
 */

public class Solution {
    public static Map<String, String> countries = new HashMap<>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements Contact, Customer {

        private final IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return String.format("%s, %s", data.getContactLastName(), data.getContactFirstName());
        }

        @Override
        public String getPhoneNumber() {
            String phoneNumber = String.format("%010d", data.getPhoneNumber());
            return String.format("+%d(%s)%s-%s-%s", data.getCountryPhoneCode(),
                    phoneNumber.substring(0,3),
                    phoneNumber.substring(3,6),
                    phoneNumber.substring(6,8),
                    phoneNumber.substring(8,10));
        }
    }


    public interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}