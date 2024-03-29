package com.javarush.task.task38.task3804;

/**
 * Фабрика исключений
 * Создай класс - фабрику исключений, который содержит один статический метод, возвращающий нужное исключение.
 * Этот метод должен принимать один параметр - энум.
 * Если передан энум:
 * * ApplicationExceptionMessage, верни исключение Exception
 * * DatabaseExceptionMessage, верни исключение RuntimeException
 * * UserExceptionMessage, верни Error иначе верни IllegalArgumentException без сообщения.
 *
 * В качестве сообщения (message) для каждого возвращаемого объекта используй элементы энума,
 * в которых все знаки подчеркивания замени на пробелы. Сообщение должно быть в нижнем регистре
 * за исключением первого символа.
 * Например, сообщение для ApplicationExceptionMessage.SOCKET_IS_CLOSED - "Socket is closed".
 *
 * Верни класс созданной фабрики в методе Solution.getFactoryClass.
 *
 * Энумы не меняй.
 *
 *
 * Requirements:
 * 1. Метод getFactoryClass должен возвращать фабрику исключений.
 * 2. ApplicationExceptionMessage не должен содержать никакие дополнительные методов или конструкторы.
 * 3. DatabaseExceptionMessage не должен содержать никакие дополнительные методов или конструкторы.
 * 4. UserExceptionMessage не должен содержать никакие дополнительные методов или конструкторы.
 * 5. Статический метод фабрики исключений должен возвращать исключения перечисленные в условии (включая сообщение)
 * для любых входящих параметров.
 * 6. Фабрика должна иметь один метод и он должен быть статическим.
*/
public class Solution {
    public static Class getFactoryClass() {
        return ExceptionFactory.class;
    }

    public static void main(String[] args) {
    }
}