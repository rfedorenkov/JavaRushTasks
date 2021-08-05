package com.javarush.task.task30.task3008;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Класс соединения между клиентом и сервером.
 */
public class Connection implements Closeable {
    private final Socket socket;
    private final ObjectOutputStream out;
    private final ObjectInputStream in;

    /**
     * Конструктор принимающий Socket в качестве параметра и иницилализирует поля класса.
     *
     * @param socket Socket.
     * @throws IOException Ошибка ввода / вывода.
     */
    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
    }

    /**
     * Метод записывает (сериализовывает) сообщение в ObjectOutputStream.
     *
     * @param message Пересылаемое сообщение.
     * @throws IOException Ошибка ввода / вывода.
     */
    public void send(Message message) throws IOException {
        synchronized (out) {
            out.writeObject(message);
        }
    }

    /**
     * Метод читает (десериализовывает) данные из ObjectInputStream.
     *
     * @return Возвращает прочитанное сообщение.
     * @throws IOException Ошибка ввода / вывода.
     * @throws ClassNotFoundException Ошибка загрузки класса.
     */
    public Message receive() throws IOException, ClassNotFoundException {
        synchronized (in) {
            return (Message) in.readObject();
        }
    }

    /**
     * Метод возвращающий удаленный адрес сокетного соединения.
     *
     * @return Удаленный адрес сокетного соединения.
     */
    public SocketAddress getRemoteSocketAddress() {
        return socket.getRemoteSocketAddress();
    }

    /**
     * Метод закрывает все ресурсы класса.
     *
     * @throws IOException Ошибка ввода / вывода.
     */
    @Override
    public void close() throws IOException {
        socket.close();
        out.close();
        in.close();
    }
}
