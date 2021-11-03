package com.javarush.task.task40.task4011;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Свойства URL
 * Метод decodeURLString должен принимать URL ссылку в виде строки и выводить ее свойства на экран:
 * - protocol
 * - authority
 * - file
 * - host
 * - path
 * - port
 * - default port
 * - query
 * - ref
 *
 * Если переданная строка не является валидной URL ссылкой, на экран должно быть выведено сообщение формата:
 * "Parameter s is not a valid URL.", где s - полученная в качестве параметра строка.
 *
 * P.S. Парсить строку не нужно, создай объект типа URL и вызови необходимые тебе методы.
 *
 *
 * Requirements:
 * 1. В методе decodeURLString должен быть создан новый объект типа URL.
 * 2. На экран должно быть выведено свойство protocol ссылки полученной в качестве параметра.
 * 3. На экран должно быть выведено свойство authority ссылки полученной в качестве параметра.
 * 4. На экран должно быть выведено свойство file ссылки полученной в качестве параметра.
 * 5. На экран должно быть выведено свойство host ссылки полученной в качестве параметра.
 * 6. На экран должно быть выведено свойство path ссылки полученной в качестве параметра.
 * 7. На экран должно быть выведено свойство port ссылки полученной в качестве параметра.
 * 8. На экран должно быть выведено свойство default port ссылки полученной в качестве параметра.
 * 9. На экран должно быть выведено свойство query ссылки полученной в качестве параметра.
 * 10. На экран должно быть выведено свойство ref ссылки полученной в качестве параметра.
 * 11. Метод decodeURLString должен выводить сообщение об ошибке на экран для некорректных URL ссылок.
*/
public class Solution {
    public static void main(String[] args) {
        decodeURLString("https://www.amrood.com/index.htm?language=en#j2se");
    }

    public static void decodeURLString(String s) {
        try {
            URL url = new URL(s);
            System.out.println("protocol - " + url.getProtocol());
            System.out.println("authority - " + url.getAuthority());
            System.out.println("file - " + url.getFile());
            System.out.println("host - " + url.getHost());
            System.out.println("path - " + url.getPath());
            System.out.println("port - " + url.getPort());
            System.out.println("default port - " + url.getDefaultPort());
            System.out.println("query - " + url.getQuery());
            System.out.println("ref - " + url.getRef());
        } catch (MalformedURLException e) {
            System.out.printf("Parameter %s is not a valid URL.%n", s);
        }
    }
}

