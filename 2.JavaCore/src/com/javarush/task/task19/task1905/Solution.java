package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/**
 * Закрепляем адаптер
 * Адаптировать Customer и Contact к RowItem.
 * Классом-адаптером является DataAdapter.
 *
 * Инициализируй countries перед началом выполнения программы. Соответствие кода страны и названия:
 * UA Ukraine
 * RU Russia
 * CA Canada
 *
 *
 * Требования:
 * 1. Класс Solution должен содержать public static поле countries типа Map<String, String>.
 * 2. В статическом блоке класса Solution инициализируй поле countries тестовыми данными согласно заданию.
 * 3. Класс Solution должен содержать интерфейс RowItem.
 * 4. Класс Solution должен содержать интерфейс Contact.
 * 5. Класс Solution должен содержать интерфейс Customer.
 * 6. Класс DataAdapter должен реализовывать интерфейс RowItem.
 * 7. Класс DataAdapter должен содержать два приватных поля: customer типа Customer и contact Contact.
 * 8. Класс DataAdapter должен содержать конструктор с параметрами (Customer customer, Contact contact),
 * который инициализирует поля contact и customer.
 * 9. В классе DataAdapter реализуй методы интерфейса RowItem используя подсказки в виде комментариев в интерфейсах.
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

    public static class DataAdapter implements RowItem {
        private final Customer customer;
        private final Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            return countries.entrySet().stream()
                    .filter(entry -> entry.getValue().equals(customer.getCountryName()))
                    .findFirst().map(Map.Entry::getKey)
                    .orElse(null);
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            return contact.getName().split(", ")[1];
        }

        @Override
        public String getContactLastName() {
            return contact.getName().split(", ")[0];
        }

        @Override
        public String getDialString() {
            return "callto://+" + contact.getPhoneNumber().replaceAll("\\D", "");
        }
    }

    public interface RowItem {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        String getDialString();         //For example: callto://+380501234567
    }

    public interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}