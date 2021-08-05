package com.javarush.task.task30.task3008.client;

/**
 * Класс участника чата. Контроллер.
 */
public class ClientGuiController extends Client {
    private ClientGuiModel model = new ClientGuiModel();
    private ClientGuiView view = new ClientGuiView(this);

    /**
     * Метод создает новый объект класса GuiSocketThread.
     *
     * @return Возвращает новый объект класса GuiSocketThread.
     */
    @Override
    protected SocketThread getSocketThread() {
        return new GuiSocketThread();
    }

    /**
     * Главный метод класса.
     */
    @Override
    public void run() {
        // Создаем новый сокетный поток и запускаем его
        SocketThread socketThread = getSocketThread();
        socketThread.run();
    }

    /**
     * Метод запрашивает ввод адреса сервера.
     *
     * @return Возвращает адрес сервера.
     */
    @Override
    protected String getServerAddress() {
        return view.getServerAddress();
    }

    /**
     * Метод запрашивает ввод порта сервера.
     *
     * @return Возвращает порт сервера.
     */
    @Override
    protected int getServerPort() {
        return view.getServerPort();
    }

    /**
     * Метод запрашивает имя пользователя.
     *
     * @return Возвращает имя пользователя.
     */
    @Override
    protected String getUserName() {
        return view.getUserName();
    }

    /**
     * Метод возвращает модель.
     *
     * @return Модель.
     */
    public ClientGuiModel getModel() {
        return model;
    }

    /**
     * Метод запускает графический клиент.
     */
    public static void main(String[] args) {
        Client gui = new ClientGuiController();
        gui.run();
    }

    /**
     * Класс устанавливающий сокетное соединение и читающий сообщения сервера.
     */
    public class GuiSocketThread extends SocketThread {

        /**
         * Метод выводит сообщение message в консоль.
         *
         * @param message Сообщение.
         */
        @Override
        protected void processIncomingMessage(String message) {
            // Устанавливаем новое сообщение у модели
            model.setNewMessage(message);
            // Вызываем обновление вывода сообщений
            view.refreshMessages();
        }

        /**
         * Метод выводит в консоль информацию о том, что участник
         * с именем userName присоединился к чату.
         *
         * @param userName Имя пользователя.
         */
        @Override
        protected void informAboutAddingNewUser(String userName) {
            // Добавляем нового пользователя в модель
            model.addUser(userName);
            // Вызываем обновление вывода пользователей
            view.refreshUsers();
        }

        /**
         * Метод выводит в консоль, что участник с именем userName покинул чат.
         *
         * @param userName Имя пользователя.
         */
        @Override
        protected void informAboutDeletingNewUser(String userName) {
            // Удаляем пользователя из модели
            model.deleteUser(userName);
            // Вызываем обновление вывода пользователей
            view.refreshUsers();
        }

        /**
         * Метод устанавливает значение поля clientConnected внешнего
         * объекта Client в соответствии с переданным параметром.
         * Вызывает аналогичный метод у View.
         *
         * @param clientConnected Флаг подключен ли клиент.
         */
        @Override
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            view.notifyConnectionStatusChanged(clientConnected);
        }
    }
}
