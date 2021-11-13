package com.javarush.task.task34.task3410.view;

import com.javarush.task.task34.task3410.controller.EventListener;
import com.javarush.task.task34.task3410.model.Direction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.*;

public class Field extends JPanel {
    private View view;
    private EventListener eventListener;

    public Field(View view) {
        this.view = view;
        addKeyListener(new KeyHandler());
        setFocusable(true);
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 500, 500);

        view.getGameObjects().getAll().forEach(gameObject -> gameObject.draw(g));
    }

    public class KeyHandler extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == VK_LEFT) {
                eventListener.move(Direction.LEFT);
            } else if (keyCode == VK_RIGHT) {
                eventListener.move(Direction.RIGHT);
            } else if (keyCode == VK_UP) {
                eventListener.move(Direction.UP);
            } else if (keyCode == VK_DOWN) {
                eventListener.move(Direction.DOWN);
            } else if (keyCode == VK_R) {
                eventListener.restart();
            }
            super.keyPressed(e);
        }
    }
}
