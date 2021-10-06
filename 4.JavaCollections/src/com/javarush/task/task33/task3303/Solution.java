package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Десериализация JSON объекта
 * НЕОБХОДИМО: подключенные библиотеки Jackson Core, Bind и Annotation версии 2.6.1
 *
 * В метод convertFromJsonToNormal первым параметром приходит имя файла, который содержит один ДЖЕЙСОН объект.
 * Вторым параметром приходит имя класса, объект которого находится в файле.
 * Метод convertFromJsonToNormal должен вычитать объект из файла, преобразовать его из JSON и вернуть.
 *
 *
 * Requirements:
 * 1. В методе convertFromJsonToNormal должен быть создан объект типа ObjectMapper
 * с помощью конструктора без параметров.
 * 2. Объект возвращаемый методом convertFromJsonToNormal должен быть получен
 * с помощью метода readValue класса ObjectMapper.
 * 3. Метод convertFromJsonToNormal должен быть статическим.
 * 4. Метод convertFromJsonToNormal должен быть публичным.
*/

public class Solution {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        return new ObjectMapper().readValue(new File(fileName), clazz);
    }

    public static void main(String[] args) {

    }
}
