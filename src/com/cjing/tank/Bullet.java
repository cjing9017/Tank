package com.cjing.tank;

import java.awt.*;

public class Bullet {
    private static final int SPEED = 10;
    private static final int WIDTH = 30;
    private static final int HEIGHT = 30;

    private int x;
    private int y;
    private Dir dir;
    private TankFrame tf;

    private boolean live = true;

    public Bullet(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        if (!live) {
            tf.getBullets().remove(this);
        }

        Color c = g.getColor();
        g.setColor(Color.red);
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(c);

        move();
    }

    private void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }

        if (x < 0 || y < 0 || x > TankFrame.getGameWidth() || y > TankFrame.getGameHeight()) {
            live = false;
        }
    }
}
