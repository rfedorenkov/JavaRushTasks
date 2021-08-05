package com.javarush.task.task30.task3008.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Класс участника чата. Отображение.
 */
public class ClientGuiView {
    // Контроллер
    private final ClientGuiController controller;

    // Создаем графическое окно
    private JFrame frame = new JFrame("Чат");
    private JTextField textField = new JTextField(50);
    private JTextArea messages = new JTextArea(10, 50);
    private JTextArea users = new JTextArea(10, 10);

    /**
     * Конструктор, принимаем контроллер и инициализируем View.
     *
     * @param controller Контроллер
     */
    public ClientGuiView(ClientGuiController controller) {
        this.controller = controller;
        initView();
    }

    /**
     * Инициализация отображения.
     */
    private void initView() {
        // Запрещаем редактирование полей
        textField.setEditable(false);
        messages.setEditable(false);
        users.setEditable(false);

        // Устанавливаем поля в окно, делаем видимым
        frame.getContentPane().add(textField, BorderLayout.NORTH);
        frame.getContentPane().add(new JScrollPane(messages), BorderLayout.WEST);
        frame.getContentPane().add(new JScrollPane(users), BorderLayout.EAST);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Добавляем слушатель
        textField.addActionListener(e -> {
            // Отправляем сообщение
            controller.sendTextMessage(textField.getText());
            textField.setText("");
        });
    }

    /**
     * Окно с вводом адресом сервера.
     *
     * @return Возвращает адрес сервера.
     */
    public String getServerAddress() {
        return JOptionPane.showInputDialog(
                frame,
                "Введите адрес сервера:",
                "Конфигурация клиента",
                JOptionPane.QUESTION_MESSAGE);
    }

    /**
     * Окно с вводом порта сервера.
     *
     * @return Возвращает порт сервера.
     */
    public int getServerPort() {
        while (true) {
            String port = JOptionPane.showInputDialog(
                    frame,
                    "Введите порт сервера:",
                    "Конфигурация клиента",
                    JOptionPane.QUESTION_MESSAGE);
            try {
                return Integer.parseInt(port.trim());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(
                        frame,
                        "Был введен некорректный порт сервера. Попробуйте еще раз.",
                        "Конфигурация клиента",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Окно с вводом имя пользователя.
     *
     * @return Возврашает имя пользователя.
     */
    public String getUserName() {
        return JOptionPane.showInputDialog(
                frame,
                "Введите ваше имя:",
                "Конфигурация клиента",
                JOptionPane.QUESTION_MESSAGE);
    }

    /**
     * Уведомление о подключении к серверу.
     *
     * @param clientConnected Если клиент подключен, то соединение установлено.
     */
    public void notifyConnectionStatusChanged(boolean clientConnected) {
        textField.setEditable(clientConnected);
        if (clientConnected) {
            JOptionPane.showMessageDialog(
                    frame,
                    "Соединение с сервером установлено",
                    "Чат",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(
                    frame,
                    "Клиент не подключен к серверу",
                    "Чат",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * Обновление окна сообщений.
     */
    public void refreshMessages() {
        messages.append(controller.getModel().getNewMessage() + "\n");
    }

    /**
     * Обновление окна пользователей.
     */
    public void refreshUsers() {
        ClientGuiModel model = controller.getModel();
        StringBuilder sb = new StringBuilder();
        for (String userName : model.getAllUserNames()) {
            sb.append(userName).append("\n");
        }
        users.setText(sb.toString());
    }
}
