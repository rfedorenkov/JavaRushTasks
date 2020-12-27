package com.javarush.task.pro.task06.task0610;

/**
 * Борьба за доступ
 * Перед тобой программа, которая выводит информацию о человеке в консоли. К сожалению, она не компилируется.
 * Измени минимальное необходимое количество модификаторов доступа в классе Person, чтобы код скомпилировался.
 *
 *
 * Требования:
 * 1. Код должен компилироваться.
 * 2. Нужно изменить минимальное необходимое количество модификаторов доступа в классе Person.
*/

public class Solution {
    public static void main(String[] args) {
        Person person = new Person("Иван", "Иванов");
        System.out.println("Досье.");
        System.out.println("Имя : " + person.getName());
        System.out.println("Фамилия : " + person.getSurname());
        System.out.println("Полное имя : " + person.getFullName());
    }
}
