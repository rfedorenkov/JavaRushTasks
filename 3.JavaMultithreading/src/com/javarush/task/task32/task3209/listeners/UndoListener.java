package com.javarush.task.task32.task3209.listeners;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

/**
 * Класс следит за правками, которые можно отменить или вернуть.
 */
public class UndoListener implements UndoableEditListener {
    private UndoManager undoManager;

    /**
     * Конструктор принимающий UndoManager.
     *
     * @param undoManager Управляющий списком отмены / возврата.
     */
    public UndoListener(UndoManager undoManager) {
        this.undoManager = undoManager;
    }

    /**
     * Метод получает из переданного события правку и добавляет ее в undoManager.
     *
     * @param e Событие.
     */
    @Override
    public void undoableEditHappened(UndoableEditEvent e) {
        undoManager.addEdit(e.getEdit());
    }
}
