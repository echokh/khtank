package com.khstudy.tank;

import java.awt.*;

public class Tank {
    private int x, y;
    private Direction direction = Direction.DOWN;
    private final TankFrame tf;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    private static final int tankSpeed = 5;

    public Tank(int x, int y, Direction direction,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.tf=tf;
    }


    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);
    }

    public void moveTank(boolean BL, boolean BU, boolean BR, boolean BD) {
        if (BL) {
            x -= tankSpeed;
            this.direction=Direction.LEFT;
        }
        if (BR) {
            x += tankSpeed;
            this.direction=Direction.RIGHT;
        }
        if (BU) {
            y -= tankSpeed;
            this.direction=Direction.UP;
        }
        if (BD) {
            y += tankSpeed;
            this.direction=Direction.DOWN;
        }
    }

    public void fire() {
        tf.bullet  = new Bullet(x, y, direction,tf);
        tf.bullet.moveBullet();

    }
}
