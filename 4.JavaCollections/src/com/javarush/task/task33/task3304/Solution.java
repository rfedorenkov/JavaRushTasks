package com.javarush.task.task33.task3304;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Конвертация из одного класса в другой используя JSON Ӏ 3304
 * НЕОБХОДИМО: подключенные библиотеки Jackson Core, Bind и Annotation версии 2.6.1
 *
 * Два класса имеют одинаковые поля, но не имеют общий суперкласс. Пример, классы First и Second.
 * Реализовать логику метода convertOneToAnother, который должен возвращать объект класса resultClassObject,
 * значения полей которого равны значениям полей в объекте one.
 * Используй объект типа ObjectMapper.
 * Известно, что у классов есть JSON аннотация, у которой значение property равно имени класса в нижнем регистре.
 * На примере класса First, это className="first"
 * Классы First и Second не участвуют в тестировании, они предоставлены в качестве тестовых данных.
 *
 *
 * Requirements:
 * 1. Метод convertOneToAnother должен возвращать объект класса resultClassObject значения полей
 * которого равны значениям полей объекта one.
 * 2. В методе convertOneToAnother должен быть создан объект типа ObjectMapper.
 * 3. Метод convertOneToAnother должен быть статическим.
 * 4. Метод convertOneToAnother должен быть публичным.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Second s = (Second) convertOneToAnother(new First(), Second.class);
        First f = (First) convertOneToAnother(new Second(), First.class);

        System.out.println(s);
        System.out.println(f);
    }

    public static Object convertOneToAnother(Object one, Class<?> resultClassObject) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(MapperFeature.USE_ANNOTATIONS);
        return mapper.convertValue(one, resultClassObject);
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")
    @JsonSubTypes(@JsonSubTypes.Type(value = First.class, name = "first"))
    public static class First {
        public int i;
        public String name;
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")
    @JsonSubTypes(@JsonSubTypes.Type(value = Second.class, name = "second"))
    public static class Second {
        public int i;
        public String name;
    }
}
