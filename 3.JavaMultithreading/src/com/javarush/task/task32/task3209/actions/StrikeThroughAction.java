package com.javarush.task.task32.task3209.actions;

import javax.swing.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

/**
 * Класс, который отвечает за стиль текста "Зачеркнутый".
 */
public class StrikeThroughAction extends StyledEditorKit.StyledTextAction {

    /**
     * Конструктор класса.
     */
    public StrikeThroughAction() {
        super(StyleConstants.StrikeThrough.toString());
    }

    /**
     * Метод изменяет стиль текста на "Зачеркнутый".
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
            // Устанавливаем атрибут "зачеркивания", используем множество атрибутов
            // Проверяем, что установлен атрибут "зачеркивания".
            StyleConstants.setStrikeThrough(simpleAttributeSet, !StyleConstants.isStrikeThrough(mutableAttributeSet));
            // Устанавливаем атрибуты редактора
            setCharacterAttributes(editor, simpleAttributeSet, false);
        }
    }
}
