package com.javarush.task.task32.task3209.listeners;

import com.javarush.task.task32.task3209.View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Класс слушателя окна.
 */
public class FrameListener extends WindowAdapter {
    // Внешний вид
    private View view;

    /**
     * Конструктор принимающий view.
     *
     * @param view Внешний вид.
     */
    public FrameListener(View view) {
        this.view = view;
    }

    /**
     * Переопледеленный метод, который вызывает view.exit().
     *
     * @param e Event (событие).
     */
    @Override
    public void windowClosing(WindowEvent e) {
        view.exit();
    }
}