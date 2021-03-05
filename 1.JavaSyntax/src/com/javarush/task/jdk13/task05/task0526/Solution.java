package com.javarush.task.jdk13.task05.task0526;

/**
 * Мужчина и женщина
 * Внутри класса Solution создай public static классы Man и Woman.
 * У классов должны быть поля: name(String), age(int), address(String).
 * Создай конструкторы, в которые передаются все возможные параметры.
 * Создай по два объекта каждого класса со всеми данными, используя конструктор.
 * Объекты выведи на экран в таком формате: name + " " + age + " " + address
 *
 * Требования:
 * 1. В классе Solution создай public static класс Man.
 * 2. В классе Solution создай public static класс Woman.
 * 3. Класс Man должен содержать переменные: name(String), age(int) и address(String).
 * 4. Класс Woman должен содержать переменные: name(String), age(int) и address(String).
 * 5. У классов Man и Woman должны быть конструкторы, принимающие параметры с типами String, int и String.
 * 6. Конструкторы должны инициализировать переменные класса.
 * 7. В методе main необходимо создать по два объекта каждого типа.
 * 8. Метод main должен выводить созданные объекты на экран в указанном формате.
*/

public class Solution {
    public static void main(String[] args) {
        Man jack = new Man("Jack", 22, "London");
        Man boris = new Man("Boris", 27, "Moscow");

        Woman maria = new Woman("Maria", 20, "France");
        Woman trisha = new Woman("Trisha", 18, "Texas");

        System.out.println(jack);
        System.out.println(boris);
        System.out.println(maria);
        System.out.println(trisha);
    }

    public static class Man {
        String name;
        int age;
        String address;

        public Man(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        @Override
        public String toString() {
            return name + " " + age + " " + address;
        }
    }

    public static class Woman {
        String name;
        int age;
        String address;

        public Woman(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        @Override
        public String toString() {
            return name + " " + age + " " + address;
        }
    }
}
