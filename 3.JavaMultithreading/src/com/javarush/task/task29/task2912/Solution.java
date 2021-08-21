package com.javarush.task.task29.task2912;

/**
 * Рефакторинг паттерна Chain of Responsibility
 * Есть программа, в которой реализована система логирования по принципу:
 * - если событие уровня FATAL - происходит звонок директору, отправляется СМС-сообщение CEO,
 * выводится сообщение в консоль, происходит логирование в файл;
 * - если событие уровня ERROR - отправляется СМС-сообщение CEO,
 * выводится сообщение в консоль, происходит логирование в файл;
 * - если событие уровня WARN - выводится сообщение в консоль, происходит логирование в файл;
 * - если событие уровня INFO - происходит логирование в файл.
 *
 * В программе реализован паттерн "цепочка ответственности". Изучи его внимательно.
 * В классах FileLogger, ConsoleLogger, SmsLogger, PhoneLogger есть много повторяющегося кода.
 * Подними весь повторяющийся код в абстрактный класс AbstractLogger.
 * Подъемом в рефакторинге называется перенос полей, методов, конструкторов из всех
 * наследников в одного общего предка. Из наследников, при этом, удаляется код, который перенесен в класс предка.
 *
 * Логика работы программы не должна измениться.
 *
 *
 * Requirements:
 * 1. Класс AbstractLogger должен быть публичным и абстрактным.
 * 2. Класс AbstractLogger должен поддерживать интерфейс Logger.
 * 3. Необходимо поднять поля level и next в класс AbstractLogger.
 * 4. Необходимо поднять методы setNext(Logger) и inform(String, int) в класс AbstractLogger.
 * 5. Вывод программы должен остаться неизменным.
*/

public class Solution {
    public static void main(String[] args) {
        Logger logger3 = new PhoneLogger(Level.FATAL);
        Logger logger2 = new SmsLogger(Level.ERROR);
        Logger logger1 = new ConsoleLogger(Level.WARN);
        Logger logger0 = new FileLogger(Level.INFO);

        logger3.setNext(logger2);
        logger2.setNext(logger1);
        logger1.setNext(logger0);

        logger3.inform("Everything is OK", Level.INFO);
        logger3.inform("We found a bug", Level.WARN);
        logger3.inform("Database connection error", Level.ERROR);
        logger3.inform("System shut down", Level.FATAL);
    }
}

/* Output:
Logging to file: Everything is OK
Logging to console: We found a bug
Logging to file: We found a bug
Send SMS to CEO: Database connection error
Logging to console: Database connection error
Logging to file: Database connection error
Call to director: System shut down
Send SMS to CEO: System shut down
Logging to console: System shut down
Logging to file: System shut down
 */