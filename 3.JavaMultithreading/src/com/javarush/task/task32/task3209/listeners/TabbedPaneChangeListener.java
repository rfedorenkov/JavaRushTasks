package com.javarush.task.task32.task3209.listeners;

import com.javarush.task.task32.task3209.View;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Класс слушает и обрабатывает изменения состояния панели вкладок.
 */
public class TabbedPaneChangeListener implements ChangeListener {
    // Внешний вид
    private View view;

    /**
     * Конструктор принимающий view.
     *
     * @param view Представление.
     */
    public TabbedPaneChangeListener(View view) {
        this.view = view;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        view.selectedTabChanged();
    }
}
