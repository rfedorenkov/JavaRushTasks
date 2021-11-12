package com.javarush.task.task40.task4006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.URL;

/**
 * Отправка GET-запроса через сокет
 * Перепиши реализацию метода getSite, он должен явно создавать и использовать сокетное соединение Socket с сервером.
 * Адрес сервера и параметры для GET-запроса получи из параметра url.
 * Порт используй дефолтный для http (80).
 * Классы HttpURLConnection, HttpClient и т.д. не использовать.
 * Не оставляй закомементированный код.
 *
 * 
 * Requirements:
 * 1. Метод getSite должен создавать объект класса Socket с правильными параметрами (String host, int port).
 * 2. Метод getSite должен записать в OutputStream правильный запрос.
 * 3. Метод getSite должен выводить на экран InputStream сокета.
 * 4. Метод getSite не должен использовать HttpURLConnection или HttpClient.
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        getSite(new URL("http://javarush.ru/social.html"));
    }

    public static void getSite(URL url) {
        final String host = url.getHost();
        final String path = url.getPath();
        try (Socket socket = new Socket(host, 80);
             PrintStream ps = new PrintStream(socket.getOutputStream());
             BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            ps.println("GET " + path);
            ps.println();

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

