package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Генератор паролей
 * Реализуй логику метода getPassword, который должен возвращать ByteArrayOutputStream,
 * в котором будут байты пароля.
 * Требования к паролю:
 * 1) 8 символов.
 * 2) только цифры и латинские буквы разного регистра.
 * 3) обязательно должны присутствовать цифры, и буквы разного регистра.
 * Все сгенерированные пароли должны быть уникальные.
 *
 * Пример правильного пароля:
 * wMh7smNu
 *
 *
 * Requirements:
 * 1. Класс Solution должен содержать метод getPassword().
 * 2. Длина пароля должна составлять 8 символов.
 * 3. Пароль должен содержать хотя бы одну цифру.
 * 4. Пароль должен содержать хотя бы одну латинскую букву нижнего регистра.
 * 5. Пароль должен содержать хотя бы одну латинскую букву верхнего регистра.
 * 6. Пароль не должен содержать других символов, кроме цифр и латинских букв разного регистра.
 * 7. Сгенерированные пароли должны быть уникальными.
*/

public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        List<Byte> list = getRandomCharList();
        list.forEach(baos::write);
        return baos;
    }

    private static List<Byte> getRandomCharList() {
        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(rand('a', 'z'));
            list.add(rand('0', '9'));
            list.add(rand('A', 'Z'));
        }
        Collections.shuffle(list);
        list.remove(0);
        return list;
    }

    private static byte rand(char min, char max) {
        return (byte) ((Math.random() * (max - min + 1) + min));
    }

}
