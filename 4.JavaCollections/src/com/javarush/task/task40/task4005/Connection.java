package com.javarush.task.task40.task4005;


import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Сокетный сервер и клиент
 * Есть сервер, он принимает входящие сообщения от клиентов и отвечает им echo.
 * Есть клиенты, они считывают сообщения с клавиатуры и отправляют их серверу.
 * Программа запускается, но не работает.
 * Разберись в чем проблема, внеси минимальные изменения в код, чтобы все заработало.
 *
 *
 * Requirements:
 * 1. Класс Client не изменяй.
 * 2. Класс Server не изменяй.
 * 3. Внеси необходимые изменения в класс Connection.
 * 4. Поля в классе Connection не изменяй.
*/
public class Connection implements Closeable {
    private final Socket socket;
    private final ObjectInputStream in;
    private final ObjectOutputStream out;

    public Connection(Socket socket) throws Exception {
        this.socket = socket;
        this.out = new ObjectOutputStream(socket.getOutputStream());
        this.in = new ObjectInputStream(socket.getInputStream());
    }

    public void send(String message) throws Exception {
        out.writeObject(message);
    }

    public String receive() throws Exception {
        return (String) in.readObject();
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
        socket.close();
    }
}
