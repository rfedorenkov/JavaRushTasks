package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Основной класс сервера.
 *
 * Что можно добавить или улучшить:
 * • Можно добавить поддержку приватных сообщений (когда сообщение отправляется не всем, а какому-то конкретному участнику).
 * • Можно расширить возможности бота, попробовать научить его отвечать на простейшие вопросы или время от времени отправлять шутки.
 * • Добавить возможность пересылки файлов между пользователями.
 * • Добавить контекстное меню в графический клиент, например, для отправки приватного сообщения кому-то из списка участников.
 * • Добавить раскраску сообщений в графическом клиенте в зависимости от отправителя.
 * • Добавить блокировку сервером участников за что-либо, например, ненормативную лексику в сообщениях.
 * • Добавить еще миллион фич и полезностей!
 */
public class Server {
    private final static String ERROR_SENDING_MESSAGE = "Сообщение не было отправлено";
    private final static String ERROR_SERVER = "Ошибка в работе сервера.";
    private final static String ERROR_SEND_MESSAGE = "Ошибка отправки сообщения.";

    /**
     * Список участников чата.
     * Ключом имя клиента, значением - соединение с ним.
     */
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    /**
     * Метод запускает сервер.
     */
    public static void main(String[] args) {
        // Запрашивает порт сервера
        ConsoleHelper.writeMessage("Введите порт сервера:");
        int port = ConsoleHelper.readInt();

        // Создает серверный сокет используя полученный порт
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            ConsoleHelper.writeMessage("Сервер запущен.");

            // Слушает и принимает входящие сокетные соединения
            while (true) {
                // Запускаем новый поток слушателя
                new Handler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            ConsoleHelper.writeMessage(ERROR_SERVER);
        }
    }

    /**
     * Метод отправляет сообщение всем соединениям из connectionMap.
     *
     * @param message Отправляемое сообщение.
     */
    public static void sendBroadcastMessage(Message message) {
        for (Connection connection : connectionMap.values()) {
            try {
                connection.send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage(ERROR_SENDING_MESSAGE);
            }
        }
    }

    /**
     * Класс отвечающий за обработку соединений.
     */
    private static class Handler extends Thread {
        private Socket socket;

        /**
         * Конструктор принимающий Socket в качестве параметра и иницилализирует поля класса.
         */
        public Handler(Socket socket) {
            this.socket = socket;
        }

        /**
         * Метод "рукопожатия" (знакомства сервера с клиентом).
         *
         * @param connection Соединиение.
         * @return Возвращает имя нового клиента.
         * @throws IOException            Ошибка ввода / вывода.
         * @throws ClassNotFoundException Ошибка загрузки класса.
         */
        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST, "Введите имя пользователя:"));
                Message receive = connection.receive();

                // Проверяем, что полученный тип сообщения USER_NAME
                if (receive.getType() == MessageType.USER_NAME) {
                    String userName = receive.getData();
                    // Проверяем, что имя не пустое и не содержится в connectionMap
                    if (!userName.isEmpty() && !connectionMap.containsKey(userName)) {
                        connectionMap.put(userName, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED, "Имя принято."));
                        return userName;
                    }
                }
            }
        }

        /**
         * Метод информацирует новому участнику информации об остальных участниках чата.
         *
         * @param connection Соединение.
         * @param userName   Имя пользователя.
         * @throws IOException Ошибка ввода / вывода.
         */
        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (String name : connectionMap.keySet()) {
                if (!name.equals(userName)) {
                    Message message = new Message(MessageType.USER_ADDED, name);
                    connection.send(message);
                }
            }
        }

        /**
         * Метод обработки сообщений сервером.
         *
         * @param connection Соединение.
         * @param userName   Имя пользователя.
         * @throws IOException            Ошибка ввода / вывода.
         * @throws ClassNotFoundException Ошибка загрузки класса.
         */
        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message receive = connection.receive();
                if (receive.getType() == MessageType.TEXT) {
                    String message = String.format("%s: %s", userName, receive.getData());
                    sendBroadcastMessage(new Message(MessageType.TEXT, message));
                } else {
                    ConsoleHelper.writeMessage(ERROR_SEND_MESSAGE);
                }
            }
        }

        /**
         * Главный метод.
         */
        @Override
        public void run() {
            // Устанавливаем соединение с новым удаленным адресом
            SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
            ConsoleHelper.writeMessage("Соединение установлено c " + remoteSocketAddress);
            String userName = "";
            try (Connection connection = new Connection(socket)) {
                // Получаем имя пользователя
                userName = serverHandshake(connection);
                // Отправляем всем участникам чата, что добавлен новый пользователь
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                // Сообщаем новому участнику о существующих участниках чата
                notifyUsers(connection, userName);
                // Запускаем главный цикл обработки сообщений сервером.
                serverMainLoop(connection, userName);
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с " + remoteSocketAddress);
            }

            if (!userName.isEmpty()) {
                // Удаляем пользователя из чата и уведомляем об этом других участников
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
            }
            ConsoleHelper.writeMessage("Соединение с " + remoteSocketAddress + " закрыто.");
        }
    }
}
