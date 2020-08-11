package com.khstudy.tank;

import java.awt.*;

public class Bullet {
    private static int SPEED = 10;
    private int x, y;
    private Direction dir;
    private final TankFrame tf;

    private boolean move = true;

    public void setMove() {
        if (x <= tf.WINDOW_WIDTH && y <=tf.WINDOW_HEIGHT) {
            this.move = true;
        }else{
            this.move=false;
        }
    }

    public Bullet(int x, int y, Direction dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf=tf;
    }

    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 5, 5);
    }

    public void moveBullet() {
        while (move) {
            switch (dir) {
                case DOWN:
                    y += SPEED;
                    setMove();
                    break;
                case UP:
                    y -= SPEED;
                    setMove();
                    break;
                case LEFT:
                    x -= SPEED;
                    setMove();
                    break;
                case RIGHT:
                    x += SPEED;
                    setMove();
                    break;
            }
        }
    }
}
