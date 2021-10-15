package com.javarush.task.task35.task3507;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * ClassLoader - что это такое?
 * Реализуй логику метода getAllAnimals.
 * Аргумент метода pathToAnimals - это абсолютный путь к директории, в которой хранятся скомпилированные классы.
 * Путь не обязательно содержит / в конце.
 * НЕ все классы наследуются от интерфейса Animal.
 * НЕ все классы имеют публичный конструктор без параметров.
 * Только для классов, которые наследуются от Animal и имеют публичный конструктор без параметров, - создать по одному объекту.
 * Добавить созданные объекты в результирующий сет и вернуть.
 * Метод main не участвует в тестировании.
 *
 *
 * Requirements:
 * 1. Размер множества возвращаемого методом getAllAnimals должен быть равен количеству классов
 * поддерживающих интерфейс Animal и имеющих публичный конструктор без параметров
 * (среди классов расположенных в директории переданной в качестве параметра).
 * 2. В множестве возвращаемом методом getAllAnimals должны присутствовать все классы поддерживающие
 * интерфейс Animal и имеющие публичный конструктор без параметров (среди классов расположенных
 * в директории переданной в качестве параметра).
 * 3. В множестве возвращаемом методом getAllAnimals НЕ должен присутствовать ни один класс не
 * поддерживающий интерфейс Animal или не имеющий публичного конструктора без параметров
 * (среди классов расположенных в директории переданной в качестве параметра).
 * 4. Метод getAllAnimals должен быть статическим.
 */

public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<Animal> animals = new HashSet<>();
        try {
            final List<Path> list = Files.list(Paths.get(pathToAnimals)).collect(Collectors.toList());
            for (Path path : list) {
                if (path.toString().endsWith(".class")) {
                    final Class<?> clazz = loadClassFromPath(path);
                    if (Animal.class.isAssignableFrom(clazz)) {
                        if (hasPublicConstructor(clazz)) {
                            animals.add((Animal) clazz.newInstance());
                        }
                    }
                }
            }
        } catch (IOException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return animals;
    }

    private static boolean hasPublicConstructor(Class<?> clazz) {
        return Arrays.stream(clazz.getConstructors())
                .anyMatch(constructor -> constructor.getParameterTypes().length == 0);
    }

    private static Class<?> loadClassFromPath(Path path) throws IOException {
        try {
            final byte[] bytes = Files.readAllBytes(path);
            final ClassLoader classLoader = new ClassLoader() {
                @Override
                protected Class<?> findClass(String name) throws ClassNotFoundException {
                    return defineClass(null, bytes, 0, bytes.length);
                }
            };
            return classLoader.loadClass(path.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        throw new RuntimeException("Not class downloaded");
    }
}
