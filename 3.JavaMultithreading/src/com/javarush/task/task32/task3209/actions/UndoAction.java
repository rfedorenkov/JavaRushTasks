package com.javarush.task.task32.task3209.actions;

import com.javarush.task.task32.task3209.View;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Класс отмены действия.
 */
public class UndoAction extends AbstractAction {
    // Внешний вид
    private View view;

    /**
     * Конструктор принимающий view.
     *
     * @param view Внешний вид.
     */
    public UndoAction(View view) {
        this.view = view;
    }

    /**
     * Метод вызывает у представления отмену.
     * @param e Событие. Не используется.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        view.undo();
    }
}


//12.3. Изучи реализацию класса StrikeThroughAction,
// которую ты получил вместе с заданием и реализуй аналогичным образом классы:
//12.3.1. SubscriptAction
//12.3.2. SuperscriptAction
//Запусти программу и убедись, что пункты меню Подстрочный знак, Надстрочный знак и Зачеркнутый работают.
//Пункты, отвечающие за отмену и возврат действия пока не подключены к контроллеру и мы не сможем их проверить.
//
//
//Requirements:
//1. Класс RedoAction должен содержать поле View view.
//2. Конструктор класса RedoAction(View view) должен инициализировать поле view.
//3. Метод actionPerformed(ActionEvent actionEvent) класса RedoAction должен вызывать метод redo() у представления.
//4. Класс UndoAction должен содержать поле View view.
//5. Конструктор класса UndoAction(View view) должен инициализировать поле view.
//6. Метод actionPerformed(ActionEvent actionEvent) класса UndoAction должен вызывать метод undo() у представления.
//7. Конструктор без параметров класса SubscriptAction должен вызывать конструктор суперкласса с параметром StyleConstants.Subscript.
//8. Метод actionPerformed(ActionEvent actionEvent) класса SubscriptAction должен использовать метод setSubscript у StyleConstants с параметрами: SimpleAttributeSet и !StyleConstants.isSubscript(mutableAttributeSet).
//9. Конструктор без параметров класса SuperscriptAction должен вызывать конструктор суперкласса с параметром StyleConstants.Superscript.
//10. Метод actionPerformed(ActionEvent actionEvent) класса SuperscriptAction должен использовать метод setSuperscript у StyleConstants с параметрами: SimpleAttributeSet и !StyleConstants.isSuperscript(mutableAttributeSet).



