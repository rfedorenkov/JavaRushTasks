package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Класс графического представления. (Внешний вид)
 */
public class View extends JFrame implements ActionListener {
    // Контроллер
    private Controller controller;
    // Панель с двумя вкладками
    private JTabbedPane tabbedPane = new JTabbedPane();
    // Вкладка для визуального редактирования html
    private JTextPane htmlTextPane = new JTextPane();
    // Вкладка для редактирования html в виде текста (отображает html код)
    private JEditorPane plainTextPane = new JEditorPane();

    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    /**
     * Конструктор класса.
     * Устанавливает внешний вид и поведение приложения
     * такими же, как это определено в системе.
     * Конструктор не кидает исключений, только логирует их.
     */
    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (IllegalAccessException | InstantiationException |
                UnsupportedLookAndFeelException | ClassNotFoundException e) {
            ExceptionHandler.log(e);
        }
    }

    /**
     * Геттер controller.
     *
     * @return Возвращает controller.
     */
    public Controller getController() {
        return controller;
    }

    /**
     * Сеттек controller.
     *
     * @param controller Устанавливает данный controller.
     */
    public void setController(Controller controller) {
        this.controller = controller;
    }

    /**
     * Геттер undoListener.
     *
     * @return Возвращает undoListener.
     */
    public UndoListener getUndoListener() {
        return undoListener;
    }

    /**
     * Метод инициализации представления.
     */
    public void init() {
        initGui();
        addWindowListener(new FrameListener(this));
        setVisible(true);
    }

    /**
     * Метод инициализирует меню.
     */
    public void initMenuBar() {
        // Создаем новый объект JMenuBar (панель меню)
        JMenuBar menuPanel = new JMenuBar();

        // Инициализация меню (Файл, Редактировать, Стиль, Выравнивание,
        // Цвет, Шрифт, Помощь)
        MenuHelper.initFileMenu(this, menuPanel);
        MenuHelper.initEditMenu(this, menuPanel);
        MenuHelper.initStyleMenu(this, menuPanel);
        MenuHelper.initAlignMenu(this, menuPanel);
        MenuHelper.initColorMenu(this, menuPanel);
        MenuHelper.initFontMenu(this, menuPanel);
        MenuHelper.initHelpMenu(this, menuPanel);

        // Добавляем в верхнюю часть панели контента текущего фрейма панель меню
        getContentPane().add(menuPanel, BorderLayout.NORTH);
    }

    /**
     * Метод инициализирует поля редактора.
     */
    public void initEditor() {
        // Устанавливаем значение контента для компонента
        htmlTextPane.setContentType("text/html");
        // Создаем новый локальный компонент и добавляем во вкладку
        JScrollPane htmlScrollPane = new JScrollPane(htmlTextPane);
        tabbedPane.add("HTML", htmlScrollPane);

        // Создаем новый локальный компонент и добавляем во вкладку
        JScrollPane textScrollPane = new JScrollPane(plainTextPane);
        tabbedPane.add("Текст", textScrollPane);

        // Устанавливаем предпочтительный размер панели
        tabbedPane.setPreferredSize(new Dimension(600, 400));

        // Устанавливаем слушателя изменений
        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));

        // Добавляем по центру панели контента текущего фрейма панель с вкладками
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

    /**
     * Метод инициализирует графический интерфейс.
     */
    public void initGui() {
        initMenuBar();
        initEditor();
        pack();
    }

    /**
     * Метод вызывает у controller.exit().
     */
    public void exit() {
        controller.exit();
    }

    /**
     * Метод вызывается, когда произошла смена выбранной вкладки.
     */
    public void selectedTabChanged() {
        // Проверяем, какая вкладка сейчас выбрана
        int selectedIndex = tabbedPane.getSelectedIndex();
        if (selectedIndex == 0) {
            // Если выбрана вкладка HTML, получаем текст из plainTextPane и устанавливаем его в контроллер
            controller.setPlainText(plainTextPane.getText());
        } else if (selectedIndex == 1) {
            // Если выбрана вкладка TEXT, получаем текст у контроллера и устанавливаем его в plainTextPane
            plainTextPane.setText(controller.getPlainText());
        }
        // Сбрасываем правки
        resetUndo();
    }

    /**
     * Метод отвечает за возможность отмены действия.
     *
     * @return Возвращает возможность отмены действия.
     */
    public boolean canUndo() {
        return undoManager.canUndo();
    }

    /**
     * Метод отвечает за возможность возврата действия.
     *
     * @return Возвращает возможность возврата действия.
     */
    public boolean canRedo() {
        return undoManager.canRedo();
    }

    /**
     * Метод отменяет последнее действие.
     * Исключения логируются.
     */
    public void undo() {
        try {
            undoManager.undo();
        } catch (CannotUndoException e) {
            ExceptionHandler.log(e);
        }
    }

    /**
     * Метод возвращает ранее отмененное действие.
     * Исключения логируются.
     */
    public void redo() {
        try {
            undoManager.redo();
        } catch (CannotRedoException e) {
            ExceptionHandler.log(e);
        }
    }

    /**
     * Метод сбрасывает все правки в менеджере undoManager.
     */
    public void resetUndo() {
        undoManager.discardAllEdits();
    }

    /**
     * Метод проверяет, выбрана ли вкладка HTML.
     *
     * @return Возвращает true, если выбрана вкладка, отображающая HTML в панели вкладок.
     */
    public boolean isHtmlTabSelected() {
        return tabbedPane.getSelectedIndex() == 0;
    }

    /**
     * Метод переключается на HTML вкладку.
     * Сбрасывает все правки.
     */
    public void selectHtmlTab() {
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    /**
     * Метод получает document у controller и устанавливает его
     * в панель редактирования htmlTextPane.
     */
    public void update() {
        htmlTextPane.setDocument(controller.getDocument());
    }

    /**
     * Метод показывает диалоговое окно с информацией о программе.
     */
    public void showAbout() {
        JOptionPane.showMessageDialog(this, "HTML редактор от JavaRush.",
                "О Программе", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Метод вызывается при выборе пунктов меню,
     * у которых указано в виде слушателя событий.
     *
     * @param e Событие.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Получаем из события команду
        String actionCommand = e.getActionCommand();

        switch (actionCommand) {
            case "Новый":
                // Если команда "Новый", создаем новый document
                controller.createNewDocument();
                break;
            case "Открыть":
                // Если команда "Открыть", открываем document
                controller.openDocument();
                break;
            case "Сохранить":
                // Если команда "Сохранить", сохраняем document
                controller.saveDocument();
                break;
            case "Сохранить как...":
                // Если команда "Сохранить как...", выбираем как будем сохранять document
                controller.saveDocumentAs();
                break;
            case "Выход":
                // Если команда "Выход", завершаем работу программы
                exit();
                break;
            case "О программе":
                // Если команда "О программе", открываем диалоговое окно
                showAbout();
                break;
        }

    }
}


