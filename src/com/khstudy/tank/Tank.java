package com.khstudy.tank;

import java.awt.*;
import java.util.Random;

public class Tank {
    private int x, y;
    private Direction direction = Direction.DOWN;
    private final TankFrame tf;

    public static int TANK_WIDTH = 50;
    public static int TANK_HEIGHT = 50;

    private Rectangle rect=new Rectangle();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private static final int tankSpeed = 2;
    private boolean live = true;
    private boolean moving = false;
    private Group group = Group.BAD;

    private Random random = new Random();

    public Tank(int x, int y, Direction direction, TankFrame tf, Group group) {
        this.x = x;
        this.y = y;
        this.tf = tf;
        this.group = group;
        if (group == Group.BAD) {
            this.moving = true;
        }

        rect.x=x;
        rect.y=y;
        rect.width=TANK_WIDTH;
        rect.height=TANK_HEIGHT;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Rectangle getRect() {
        return rect;
    }

    public void paint(Graphics g) {
        if (!live) {
            tf.enemies.remove(this);
        }
        switch (direction) {
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
        moveTank();
    }

    public Group getGroup() {
        return group;
    }

    public void moveTank() {
        if (!moving) return;
        switch (direction) {
            case RIGHT:
                x += tankSpeed;
                break;
            case LEFT:
                x -= tankSpeed;
                break;
            case UP:
                y -= tankSpeed;
                break;
            case DOWN:
                y += tankSpeed;
                break;
        }
        if (this.group == Group.BAD) {
            if (random.nextInt(150) == 8) this.fire();
            switchDir();
        }
        boundCheck();
        rect.x=this.x;
        rect.y=this.y;
    }

    private void boundCheck() {
        x = Math.min(tf.WINDOW_WIDTH - TANK_WIDTH, x);
        x = Math.max(0, x);
        y = Math.min(tf.WINDOW_HEIGHT - TANK_HEIGHT, y);
        y = Math.max(TANK_HEIGHT / 2, y);
    }

    public void switchDir() {
        switch (random.nextInt(250)) {
            case 0:
                this.direction = Direction.UP;
                break;
            case 50:
                this.direction = Direction.DOWN;
                break;
            case 150:
                this.direction = Direction.LEFT;
                break;
            case 200:
                this.direction = Direction.RIGHT;
                break;
        }
    }

    public void fire() {
        tf.bullets.add(new Bullet(x + TANK_WIDTH / 5 * 2, y + TANK_HEIGHT / 2, direction, tf, this.group));
    }

    public void die() {
        this.live = false;
    }
}
