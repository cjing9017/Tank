package com.cjing.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

    private int x = 200;
    private int y = 200;

    public TankFrame() throws HeadlessException {
        setSize(800, 600);
        setResizable(false);
        setTitle("tank war");
        setVisible(true);

        this.addKeyListener(new MyKeyListener());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);
        x += 50;
    }

    class MyKeyListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            // x += 200;
            // repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("key release");
        }
    }

}
