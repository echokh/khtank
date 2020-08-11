package com.khstudy.tank;

import java.awt.*;

public class Tank {
    private int x, y;
    private Direction direction = Direction.DOWN;
    private final TankFrame tf;

    private static int TANK_WIDTH = 50;
    private static int TANK_HEIGHT = 50;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    private static final int tankSpeed = 5;

    public Tank(int x, int y, Direction direction, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.tf = tf;
    }


    public void paint(Graphics g) {
        switch (direction){
            case RIGHT:
                g.drawImage(ResourceMgr.tankR, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceMgr.tankL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD, x, y, null);
                break;
        }

    }



    public void moveTank(boolean BL, boolean BU, boolean BR, boolean BD) {
        if (BL) {
            x -= tankSpeed;
            this.direction = Direction.LEFT;
        }
        if (BR) {
            x += tankSpeed;
            this.direction = Direction.RIGHT;
        }
        if (BU) {
            y -= tankSpeed;
            this.direction = Direction.UP;
        }
        if (BD) {
            y += tankSpeed;
            this.direction = Direction.DOWN;
        }
    }

    public void fire() {
        tf.bullets.add(new Bullet(x + TANK_WIDTH / 5*2, y + TANK_HEIGHT / 2, direction, tf));
    }
}
