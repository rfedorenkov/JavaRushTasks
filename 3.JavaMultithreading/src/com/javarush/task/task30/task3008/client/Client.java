package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

/**
 * Класс участника чата.
 */
public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    /**
     * Метод запрашивает ввод адреса сервера.
     *
     * @return Возвращает адрес сервера.
     */
    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Введите адрес сервера:");
        return ConsoleHelper.readString();
    }

    /**
     * Метод запрашивает ввод порта сервера.
     *
     * @return Возвращает порт сервера.
     */
    protected int getServerPort() {
        ConsoleHelper.writeMessage("Введите порт сервера:");
        return ConsoleHelper.readInt();
    }

    /**
     * Метод запрашивает имя пользователя.
     *
     * @return Возвращает имя пользователя.
     */
    protected String getUserName() {
        ConsoleHelper.writeMessage("Введите имя пользователя:");
        return ConsoleHelper.readString();
    }

    /**
     * Метод возвращает true если клиент может отправлять
     * в консоль введенный текст или false если не может.
     *
     * @return Данная реализация возвращает true.
     */
    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    /**
     * Метод создает новый объект класса SocketThread.
     *
     * @return Возвращает новый объект класса SocketThread.
     */
    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    /**
     * Метод создает новое текстовое сообщение, используя переданный текст
     * и отправляет его серверу через соединение connection.
     *
     * @param text Текстовое сообщение.
     */
    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Ошибка отправки сообщения: " + text);
            clientConnected = false;
        }
    }

    /**
     * Главный метод класса.
     */
    public void run() {
        // Создаем новый сокетный поток, помечаем как daemon и запускаем его
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();

        // Ожадение соединение с сервером
        try {
            synchronized (this) {
                wait();
            }
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы программы.");
        }

        // Если клиент подключен
        if (clientConnected) {
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        } else {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }

        // Пока клиент подключен
        while (clientConnected) {
            // Считываем текст сообщения
            String text = ConsoleHelper.readString();
            // Если считанный текст exit, то выходим из цикла
            if (text.equals("exit")) {
                break;
            }

            // Если клиент может отправлять сообщение в консоль
            if (shouldSendTextFromConsole()) {
                // Отправляем сообщение
                sendTextMessage(text);
            }
        }
    }

    /**
     * Метод запускает клиента.
     */
    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    /**
     * Класс устанавливающий сокетное соединение и читающий сообщения сервера.
     */
    public class SocketThread extends Thread {

        /**
         * Метод выводит сообщение message в консоль.
         *
         * @param message Сообщение.
         */
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        /**
         * Метод выводит в консоль информацию о том, что участник
         * с именем userName присоединился к чату.
         *
         * @param userName Имя пользователя.
         */
        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " присоединился к чату.");
        }

        /**
         * Метод выводит в консоль, что участник с именем userName покинул чат.
         *
         * @param userName Имя пользователя.
         */
        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " покинул чат.");
        }

        /**
         * Метод устанавливает значение поля clientConnected внешнего
         * объекта Client в соответствии с переданным параметром.
         * Пробуждает ожиданиющий основной поток класса Client.
         *
         * @param clientConnected Флаг подключен ли клиент.
         */
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }

        /**
         * Метод "рукопожатия" (знакомства клиента с сервером).
         *
         * @throws IOException            Ошибка ввода / вывода.
         * @throws ClassNotFoundException Ошибка загрузки класса.
         */
        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true) {
                // Получаем сообщение и его тип
                Message receive = connection.receive();
                MessageType messageType = receive.getType();

                if (messageType == MessageType.NAME_REQUEST) {
                    // Если тип запроса NAME_REQUEST, то запрашиваем имя пользователя
                    // и отправляем его на сервер
                    String userName = getUserName();
                    connection.send(new Message(MessageType.USER_NAME, userName));
                } else if (messageType == MessageType.NAME_ACCEPTED) {
                    // Если тип запроса NAME_ACCEPTED, значит имя принято
                    // сообщаем главному потоку
                    notifyConnectionStatusChanged(true);
                    return;
                } else {
                    // В остальных случаях бросаем исключение
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        /**
         * Метод реализовывает главный цикл обработки сообщения сервера.
         *
         * @throws IOException            Ошибка ввода / вывода.
         * @throws ClassNotFoundException Ошибка загрузки класса.
         */
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (true) {
                // Получаем сообщение и его тип от сервера
                Message receive = connection.receive();
                MessageType messageType = receive.getType();

                if (messageType == MessageType.TEXT) {
                    // Если тип запроса TEXT, печатаем сообщение в чат
                    processIncomingMessage(receive.getData());
                } else if (messageType == MessageType.USER_ADDED) {
                    // Если тип запроса USER_ADDED, информируем о добавлении пользователя в чат
                    informAboutAddingNewUser(receive.getData());
                } else if (messageType == MessageType.USER_REMOVED) {
                    // Если тип запроса USER_REMOVED, информируем о удалении пользователя из чата
                    informAboutDeletingNewUser(receive.getData());
                } else {
                    // В остальных случаях бросаем исключение
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        /**
         * Главный метод.
         */
        @Override
        public void run() {
            try {
                // Запрашиваем адрес и порт сервера. Создаем соединение
                connection = new Connection(new Socket(getServerAddress(), getServerPort()));
                // Вызываем метод знакомства с сервером
                clientHandshake();
                // Вызываем метод обработки сообщений с сервером
                clientMainLoop();
            } catch (IOException | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
                ConsoleHelper.writeMessage("Произошла ошибка: " + e);
            }
        }
    }
}
