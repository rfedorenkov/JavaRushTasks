package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;

/**
 * Найти класс по описанию Ӏ Java Collections: 6 уровень, 6 лекция
 * Описание класса:
 * 1. Реализует интерфейс List;
 * 2. Является приватным статическим классом внутри популярного утилитного класса;
 * 3. Доступ по индексу запрещен - кидается исключение IndexOutOfBoundsException.
 * Используя рефлекшн (метод getDeclaredClasses), верни подходящий тип в методе getExpectedClass.
 *
 *
 * Requirements:
 * 1. Метод getExpectedClass должен использовать метод getDeclaredClasses подходящего утилитного класса.
 * 2. Метод getExpectedClass должен вернуть правильный тип.
 * 3. Метод main должен вызывать метод getExpectedClass.
 * 4. Метод main должен вывести полученный класс на экран.
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class<?> getExpectedClass() {
        final Class<?>[] collectionsClasses = Collections.class.getDeclaredClasses();
        for (Class<?> clazz : collectionsClasses) {
            if (List.class.isAssignableFrom(clazz)) {
                final int modifiers = clazz.getModifiers();
                if (Modifier.isPrivate(modifiers) && Modifier.isStatic(modifiers)) {
                    try {
                        final Method get = clazz.getDeclaredMethod("get", int.class);
                        get.setAccessible(true);
                        final Constructor<?> constructor = clazz.getDeclaredConstructor();
                        constructor.setAccessible(true);
                        final List<?> list = (List<?>) constructor.newInstance();
                        list.get(1);
                    } catch (IndexOutOfBoundsException e) {
                        return clazz;
                    } catch (Exception ignored) {
                    }
                }
            }
        }
        return null;
    }
}
