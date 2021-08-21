package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Класс фильтра HTML файлов.
 * Позволяет отображать только html/htm файлы или папки.
 */
public class HTMLFileFilter extends FileFilter {

    /**
     * Проверяет, что переданный файл является HTML или директорией.
     *
     * @param f Файл.
     * @return Возвращает true, если расширение файла ".html", ".htm" или директория.
     */
    @Override
    public boolean accept(File f) {
        String fileName = f.getName().toLowerCase();
        return f.isDirectory() || fileName.endsWith(".html") || fileName.endsWith(".htm");
    }

    /**
     * Метод отображает описание доступных типов файлов.
     *
     * @return Возвращает описание.
     */
    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
