package com.javarush.task.jdk13.task08.task0824;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Вся семья в сборе
 * 1. У класса Human должны быть поля имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
 * 2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
 * 3. Выведи все объекты Human на экран (Подсказка: используй метод toString() класса Human).
 *
 * Требования:
 * 1. Программа должна выводить текст на экран.
 * 2. Класс Human должен содержать четыре поля.
 * 3. Класс Human должен содержать один метод.
 * 4. Класс Solution должен содержать один метод.
 * 5. Программа должна создавать объекты и заполнять их так, чтобы получилось:
 * два дедушки, две бабушки, отец, мать, трое детей и выводить все объекты Human на экран.
*/

public class Solution {
    public static void main(String[] args) {
        Human firstChild = new Human("Alexey", true, 8);
        Human secondChild = new Human("Alexander", true, 4);
        Human thirdChild = new Human("Maria", false, 2);

        Human father = new Human("Igor", true, 30, firstChild, secondChild, thirdChild);
        Human mother = new Human("Ekaterina", false, 26, firstChild, secondChild, thirdChild);

        Human paternalGrandfather = new Human("Ivan", true, 55, father);
        Human paternalGrandmother = new Human("Olga", false, 52, father);

        Human maternalGrandfather = new Human("Pavel", true, 60, mother);
        Human maternalGrandmother = new Human("Elena", false, 56, mother);

        System.out.println(paternalGrandfather);
        System.out.println(paternalGrandmother);
        System.out.println(maternalGrandfather);
        System.out.println(maternalGrandmother);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(firstChild);
        System.out.println(secondChild);
        System.out.println(thirdChild);


    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        List<Human> children = new ArrayList<>();

        public Human(String name, boolean sex, int age, Human... children) {
            this.name = name;
            this.sex = sex;
            this.age = age;

            Collections.addAll(this.children, children);
        }

        @Override
        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
