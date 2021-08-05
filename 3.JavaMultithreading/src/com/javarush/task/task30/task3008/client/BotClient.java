package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Класс бота.
 */
public class BotClient extends Client {

    /**
     * Метод создает новый объект класса BotSocketThread.
     *
     * @return Возвращает новый объект класса BotSocketThread.
     */
    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    /**
     * Метод возвращает true если клиент может отправлять
     * в консоль введенный текст или false если не может.
     *
     * @return Данная реализация возвращает false.
     */
    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    /**
     * Метод генерирует новое имя бота.
     * Например: date_bot_X, где X - любое число от 0 до 99.
     *
     * @return Возвращает имя бота.
     */
    @Override
    protected String getUserName() {
        return "date_bot_" + (int) (Math.random() * 100);
    }

    /**
     * Метод запускает бота.
     */
    public static void main(String[] args) {
        Client bot = new BotClient();
        bot.run();
    }

    /**
     * Класс устанавливающий сокетное соединение и читающий сообщения сервера.
     */
    public class BotSocketThread extends SocketThread {

        /**
         * Метод реализовывает главный цикл обработки сообщения сервера.
         *
         * @throws IOException            Ошибка ввода / вывода.
         * @throws ClassNotFoundException Ошибка загрузки класса.
         */
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            // Приветствие и вызов родительского метода
            sendTextMessage("Привет чатику. Я бот." +
                    " Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        /**
         * Метод выводит сообщение message в консоль.
         *
         * @param message Сообщение.
         */
        @Override
        protected void processIncomingMessage(String message) {
            // Выводим в консоль полученное сообщение
            ConsoleHelper.writeMessage(message);

            // Проверяем, что сообщение содержит ': '
            if (!message.contains(": ")) {
                return;
            }

            // Делим сообщение на имя и текст
            String[] split = message.split(": ");
            String userName = split[0];
            String text = split[1];

            // В зависимости от полученного сообщения присваиваем формат
            String format = "";
            if (text.equals("дата")) {
                format = "d.MM.YYYY";
            } else if (text.equals("день")) {
                format = "d";
            } else if (text.equals("месяц")) {
                format = "MMMM";
            } else if (text.equals("год")) {
                format = "YYYY";
            } else if (text.equals("время")) {
                format = "H:mm:ss";
            } else if (text.equals("час")) {
                format = "H";
            } else if (text.equals("минуты")) {
                format = "m";
            } else if (text.equals("секунды")) {
                format = "s";
            }

            // Если формат присвоился, то отправляем сообщение
            if (!format.isEmpty()) {
                sendTextMessage(String.format("Информация для %s: %s",
                        userName, new SimpleDateFormat(format).format(Calendar.getInstance().getTime())));
            }
        }
    }
}
