package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.List;

/**
 * Externalizable Person
 * Класс Person должен сериализовываться с помощью интерфейса Externalizable.
 * Исправь ошибку сериализации.
 * Сигнатуры методов менять нельзя.
 *
 *
 * Требования:
 * 1. В классе Solution.Person должен быть создан публичный конструктор без параметров.
 * 2. В классе Solution.Person должен быть создан конструктор с тремя параметрами
 * (String firstName, String lastName, int age).
 * 3. Класс Solution.Person должен поддерживать интерфейс Externalizable.
 * 4. Методы readExternal и writeExternal должны позволять корректно сериализовывать
 * и десериализовывать объекты типа Person.
*/

public class Solution {
    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public Person() {
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(mother);
            out.writeObject(father);
            out.writeUTF(firstName);
            out.writeUTF(lastName);
            out.writeInt(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            mother = (Person) in.readObject();
            father = (Person) in.readObject();
            firstName = in.readUTF();
            lastName = in.readUTF();
            age = in.readInt();
            children = (List<Person>) in.readObject();
        }
    }

    public static void main(String[] args) {

    }
}
