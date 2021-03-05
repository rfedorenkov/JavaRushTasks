package com.javarush.task.jdk13.task07.task0724;

/**
 * Семья
 * Создай класс Human с полями имя(String), пол(boolean), возраст(int), отец(Human), мать(Human).
 * Создай объекты и заполни их так, чтобы получилось:
 * Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
 * Примечание: Если написать свой метод String toString() в классе Human, то именно он будет
 * использоваться при выводе объекта на экран.
 * Пример вывода:
 * Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя Имя: Катя, пол: женский, возраст: 55
 * Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня …
 *
 * Требования:
 * 1. Программа не должна считывать данные с клавиатуры.
 * 2. Добавить в класс Human поля: имя(String), пол(boolean), возраст(int), отец(Human), мать(Human).
 * 3. Добавить в класс конструктор public Human(String name, boolean sex, int age).
 * 4. Добавить в класс конструктор public Human(String name, boolean sex, int age, Human father, Human mother).
 * 5. Создай 9 разных объектов типа Human (4 объекта без отца и матери и 5 объектов с ними)).
 * 6. Выведи созданные объекты на экран.
*/

public class Solution {
    public static void main(String[] args) {

        Human grandfatherOne = new Human("Петр", true, 61);
        Human grandfatherTwo = new Human("Василий", true, 63);

        Human grandmotherOne = new Human("Екатерина", false, 58);
        Human grandmotherTwo = new Human("Ольга", false, 56);

        Human father = new Human("Алексей", true, 36, grandfatherOne, grandmotherOne);
        Human mother = new Human("Елена", false, 33, grandfatherTwo, grandmotherTwo);

        Human firstChild = new Human("Александр", true, 14, father, mother);
        Human secondChild = new Human("Надежда", false, 10, father, mother);
        Human thirdChild = new Human("Виталий", true, 6, father, mother);

        System.out.println(grandfatherOne);
        System.out.println(grandfatherTwo);
        System.out.println(grandmotherOne);
        System.out.println(grandmotherTwo);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(firstChild);
        System.out.println(secondChild);
        System.out.println(thirdChild);

    }

    public static class Human {
        private String name;
        private boolean sex;
        private int age;
        private Human father;
        private Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        @Override
        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}