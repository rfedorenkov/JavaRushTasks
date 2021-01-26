package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * User, Loser, Coder and Proger
 * Давай напишем программу, которая определит, чем заняться тому или иному человеку.
 * Для этого нужно:
 * Ввести [в цикле] с клавиатуры несколько строк (ключей).
 * Строки (ключи) могут быть такими: "user", "loser", "coder", "proger".
 * Ввод окончен, когда строка не совпадает ни с одной из выше указанных.
 * Для каждой введенной строки нужно:
 * Создать соответствующий объект [см. Person.java], например, для строки "user" нужно создать объект класса User.
 * Передать этот объект в метод doWork.
 * Написать реализацию метода doWork, который:
 * Вызывает метод live() у переданного объекта, если этот объект (person) имеет тип User.
 * Вызывает метод doNothing(), если person имеет тип Loser.
 * Вызывает метод writeCode(), если person имеет тип Coder.
 * Вызывает метод enjoy(), если person имеет тип Proger.
 *
 * Требования:
 * 1. Метод main должен считывать строки с клавиатуры.
 * 2. Метод main должен прекращать считывать строки с клавиатуры, как только введенная строка не совпадает
 * с одной из ожидаемых (user, loser, coder, proger).
 * 3. Для каждой корректной (user, loser, coder, proger) введенной строки должен быть вызван метод doWork
 * с соответствующим объектом класса Person в качестве параметра.
 * 4. В классе Solution должен быть реализован метод doWork с одним параметром типа Person.
 * 5. Метод doWork должен вызывать метод live() у переданного объекта, если этот объект имеет тип User.
 * 6. Метод doWork должен вызывать метод doNothing() у переданного объекта, если этот объект имеет тип Loser.
 * 7. Метод doWork должен вызывать метод writeCode() у переданного объекта, если этот объект имеет тип Coder.
 * 8. Метод doWork должен вызывать метод enjoy() у переданного объекта, если этот объект имеет тип Proger.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person;
        String key;

        String[] keys = {"user", "loser", "coder", "proger"};
        while (true){
            key = reader.readLine();
            if (!Arrays.asList(keys).contains(key)) {
                break;
            }

            switch (key) {
                case "user":
                    person = new Person.User();
                    break;
                case "loser":
                    person = new Person.Loser();
                    break;
                case "coder":
                    person = new Person.Coder();
                    break;
                case "proger":
                    person = new Person.Proger();
                    break;
                default:
                    person = null;
            }

            doWork(person);

        }
    }

    public static void doWork(Person person) {
        if (person instanceof Person.User) {
            ((Person.User) person).live();
        } else if (person instanceof Person.Loser) {
            ((Person.Loser) person).doNothing();
        } else if (person instanceof Person.Coder) {
            ((Person.Coder) person).writeCode();
        } else if (person instanceof Person.Proger) {
            ((Person.Proger) person).enjoy();
        }
    }
}
