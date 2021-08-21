package com.javarush.task.task32.task3209.listeners;

import com.javarush.task.task32.task3209.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 * Класс поддерживает механизм отмены / возврата (undo / redo) действий в редакторе.
 */
public class UndoMenuListener implements MenuListener {
    // Внешний вид
    private View view;
    // Пункт меню "Отменить"
    private JMenuItem undoMenuItem;
    // Пункт меню "Вернуть"
    private JMenuItem redoMenuItem;

    /**
     * Конструктор класса.
     * Устанавливает внешний вид, пункты меню отмены / возврата.
     *
     * @param view         Внешний вид.
     * @param undoMenuItem Пункт меню "Отменить".
     * @param redoMenuItem Пункт меню "Вернуть".
     */
    public UndoMenuListener(View view, JMenuItem undoMenuItem, JMenuItem redoMenuItem) {
        this.view = view;
        this.undoMenuItem = undoMenuItem;
        this.redoMenuItem = redoMenuItem;
    }

    /**
     * Метод вызывается перед показом меню.
     *
     * @param e Событие.
     */
    @Override
    public void menuSelected(MenuEvent e) {
        // Спрашиваем у представления, можем ли "отменить" / "вернуть" действие
        // Делаем доступным или не доступным в зависимости от ответа представления
        undoMenuItem.setEnabled(view.canUndo());
        redoMenuItem.setEnabled(view.canRedo());

    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
}
