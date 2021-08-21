package com.javarush.task.task32.task3209.actions;

import com.javarush.task.task32.task3209.View;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Класс отмены действия.
 */
public class RedoAction extends AbstractAction  {
    // Внешний вид
    private View view;

    /**
     * Конструктор принимающий view.
     *
     * @param view Внешний вид.
     */
    public RedoAction(View view) {
        this.view = view;
    }

    /**
     * Метод вызывает у представления возврат.
     * @param e Событие. Не используется.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        view.redo();
    }
}


