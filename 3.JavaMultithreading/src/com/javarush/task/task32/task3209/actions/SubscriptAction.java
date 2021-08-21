package com.javarush.task.task32.task3209.actions;

import javax.swing.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

/**
 * Класс, который отвечает за стиль текста "Подстрочный знак".
 */
public class SubscriptAction extends StyledEditorKit.StyledTextAction {

    /**
     * Конструктор класса.
     */
    public SubscriptAction() {
        super(StyleConstants.Subscript.toString());
    }

    /**
     * Метод изменяет стиль текста на "Подстрочный знак".
     *
     * @param actionEvent Событие.
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        // Получаем редактор
        JEditorPane editor = getEditor(actionEvent);
        // Проверяем на null
        if (editor != null) {
            // Получаем входные атрибуты для панели
            MutableAttributeSet mutableAttributeSet = getStyledEditorKit(editor).getInputAttributes();
            // Создаем простое множество атрибутов
            SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet();
            // Устанавливаем атрибут "подстрочного знака", используем множество атрибутов
            // Проверяем, что установлен атрибут "подстрочного знака".
            StyleConstants.setSubscript(simpleAttributeSet, !StyleConstants.isSubscript(mutableAttributeSet));
            // Устанавливаем атрибуты редактора
            setCharacterAttributes(editor, simpleAttributeSet, false);
        }
    }
}