package com.khstudy.tank;

import java.awt.*;

public class Bullet {
    private static int SPEED = 6;
    private int x, y;
    private Direction dir;
    private final TankFrame tf;

    private static final int BULLET_WIDTH = 5;
    private static final int BULLET_HEIGHT = 5;

    private boolean live = true;


    public Bullet(int x, int y, Direction dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        if (!live) {
            tf.bullets.remove(this);
        }
        g.setColor(Color.red);
        switch (dir) {
            case DOWN:
                y += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
        }
        g.fillRect(x, y, BULLET_WIDTH, BULLET_HEIGHT);
        if (x < 0 || y < 0 || x > TankFrame.WINDOW_WIDTH || y > TankFrame.WINDOW_HEIGHT) {
            live = false;
        }
    }
}
