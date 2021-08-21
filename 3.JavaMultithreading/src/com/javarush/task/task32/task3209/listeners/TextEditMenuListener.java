package com.javarush.task.task32.task3209.listeners;

import com.javarush.task.task32.task3209.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.util.Arrays;

/**
 * Класс слушателя отвечающий за пункты меню (стиль, шрифт, цвет и т.д), которые
 * доступны только тогда, когда в редакторе выбрана первая вкладка (HTML).
 */
public class TextEditMenuListener implements MenuListener {
    // Внешний вид
    private View view;

    /**
     * Конструктор принимающий view.
     *
     * @param view Внешний вид.
     */
    public TextEditMenuListener(View view) {
        this.view = view;
    }

    /**
     * Метод вызывается перед показом меню.
     * Делает доступными пункты меню, когда активна вкладка HTML.
     *
     * @param e Событие.
     */
    @Override
    public void menuSelected(MenuEvent e) {
        // Получаем объект, над которым было совершено действие.
        JMenu menu = (JMenu) e.getSource();
        // Получаем список пунктов меню
        Component[] components = menu.getMenuComponents();
        // Активируем пункт меню, если включена вкладка HTML
        Arrays.stream(components).forEach(component -> component.setEnabled(view.isHtmlTabSelected()));
    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
}