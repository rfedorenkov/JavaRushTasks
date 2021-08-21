package com.javarush.task.task32.task3209;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

/**
 * Класс контроллера.
 */
public class Controller {
    // Внешний вид
    private View view;
    private HTMLDocument document;
    private File currentFile;

    /**
     * Конструктор принимающий view.
     *
     * @param view Внешний вид.
     */
    public Controller(View view) {
        this.view = view;
    }

    /**
     * Геттер document.
     *
     * @return Возвращает HTMLDocument.
     */
    public HTMLDocument getDocument() {
        return document;
    }

    /**
     * Метод инициализации контроллера.
     */
    public void init() {
        createNewDocument();
    }

    /**
     * Метод сбрасывает текущий document.
     */
    public void resetDocument() {
        // Удаляем у текущего document слушателя правок
        if (document != null) {
            document.removeUndoableEditListener(view.getUndoListener());
        }
        // Создаем новый документ по умолчанию
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        // Добавляем новому документу слушателя правок
        document.addUndoableEditListener(view.getUndoListener());
        // Вызываем у представления update()
        view.update();
    }

    /**
     * Метод записывает переданный текст с html тегами в document.
     *
     * @param text Текст, который будет записан.
     */
    public void setPlainText(String text) {
        // Сбрасываем документ
        resetDocument();
        // Создаем новый reader на базе переданного текста
        StringReader reader = new StringReader(text);

        try {
            // Вычитываем все данные из reader в document
            new HTMLEditorKit().read(reader, document, 0);
        } catch (IOException | BadLocationException e) {
            // Логируем полученные исключения
            ExceptionHandler.log(e);
        }
    }

    /**
     * Метод получает текст из документа со всеми html тегами.
     *
     * @return Текст из документа со всеми html тегами.
     */
    public String getPlainText() {
        // Создаем writer
        StringWriter writer = new StringWriter();
        try {
            // Переписываем все содержимое из document в writer
            new HTMLEditorKit().write(writer, document, 0, document.getLength());
        } catch (BadLocationException | IOException e) {
            // Логируем полученные исключения
            ExceptionHandler.log(e);
        }
        return writer.toString();
    }

    /**
     * Метод создает новый document.
     */
    public void createNewDocument() {
        // Выбираем HTML вкладку
        view.selectHtmlTab();
        // Сбрасываем текущий document
        resetDocument();
        // Устанавливаем нвоый заголовок окна
        view.setTitle("HTML редактор");
        // Обнуляем currentFile
        currentFile = null;
    }

    /**
     * Метод открывает HTML файл и читает в document.
     */
    public void openDocument() {
        // Выбираем HTML вкладку
        view.selectHtmlTab();
        // Создаем выбор файлов
        JFileChooser fileChooser = new JFileChooser();
        // Устанавливаем фильтр
        fileChooser.setFileFilter(new HTMLFileFilter());

        // Показываем диалогове окно "Open File" для выбора файла
        // Если пользователь подтвердит выбор файла
        if (fileChooser.showOpenDialog(view) == JFileChooser.APPROVE_OPTION) {
            // Устанавливаем новое значение
            currentFile = fileChooser.getSelectedFile();
            // Сбрасываем документ
            resetDocument();
            // Устанавливаем имя файла в качестве заголовка окна view
            view.setTitle(currentFile.getName());
            // Создаем FileReader на базе currentFile
            try (FileReader reader = new FileReader(currentFile)) {
                // Считываем данные в document
                new HTMLEditorKit().read(reader, document, 0);
                // Сбрасываем правки
                view.resetUndo();
            } catch (IOException | BadLocationException e) {
                // Логируем полученные исключения
                ExceptionHandler.log(e);
            }
        }
    }

    /**
     * Метод для сохранения открытого файла document.
     */
    public void saveDocument() {
        // Если текущий файл ранее был сохранен
        if (currentFile != null) {
            // Выбираем HTML вкладку
            view.selectHtmlTab();
            // Создаем FileWriter на базе currentFile
            try (FileWriter writer = new FileWriter(currentFile)) {
                // Преписываем данные из document
                new HTMLEditorKit().write(writer, document, 0, document.getLength());
            } catch (IOException | BadLocationException e) {
                // Логируем полученные исключения
                ExceptionHandler.log(e);
            }
        } else {
            // В противном случае, узнаем у пользователя куда сохранить файл
            saveDocumentAs();
        }
    }

    /**
     * Метод выбирает как сохранить в файл document.
     */
    public void saveDocumentAs() {
        // Выбираем HTML вкладку
        view.selectHtmlTab();
        // Создаем выбор файлов
        JFileChooser fileChooser = new JFileChooser();
        // Устанавливаем фильтр
        fileChooser.setFileFilter(new HTMLFileFilter());

        // Показываем диалогове окно "Save File" для выбора файла
        // Если пользователь подтвердит выбор файла
        if (fileChooser.showSaveDialog(view) == JFileChooser.APPROVE_OPTION) {
            // Сохраняем выбранный файл
            currentFile = fileChooser.getSelectedFile();
            // Устанавливаем имя файла в качестве заголовка окна view
            view.setTitle(currentFile.getName());
            // Создаем FileWriter на базе currentFile
            try (FileWriter writer = new FileWriter(currentFile)) {
                // Преписываем данные из document
                new HTMLEditorKit().write(writer, document, 0, document.getLength());
            } catch (IOException | BadLocationException e) {
                // Логируем полученные исключения
                ExceptionHandler.log(e);
            }
        }
    }

    /**
     * Метод завершает работу программы.
     */
    public void exit() {
        System.exit(0);
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }
}

//Что можно улучшить в разработанном редакторе:
//- Добавить панель инструментов, повторяющую функционал меню.
//- Добавить подсветку html тегов на второй вкладке.
//- Добавить возможность загрузки документа из Интернет.
//- Расширить возможности редактора (вставка картинки, ссылки и т.д.)