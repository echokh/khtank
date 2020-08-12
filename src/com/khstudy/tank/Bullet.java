package com.khstudy.tank;

import java.awt.*;

public class Bullet {
    private static int SPEED = 6;
    private int x, y;
    private Direction dir;
    private final TankFrame tf;

    private static final int BULLET_WIDTH = 5;
    private static final int BULLET_HEIGHT = 5;
    private Group group;

    private boolean live = true;


    public Bullet(int x, int y, Direction dir, TankFrame tf, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;
    }

    public void paint(Graphics g) {
        if (!live) {
            tf.bullets.remove(this);
        }
        switch (dir) {
            case DOWN:
                y += SPEED;
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
            case UP:
                y -= SPEED;
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case LEFT:
                x -= SPEED;
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                x += SPEED;
                break;
        }

        if (x < 0 || y < 0 || x > TankFrame.WINDOW_WIDTH || y > TankFrame.WINDOW_HEIGHT) {
            live = false;
        }
    }

    public void collodeWith(Tank tank) {
        if (this.group == tank.getGroup()) return;
        Rectangle rect = new Rectangle(this.x, this.y, BULLET_WIDTH, BULLET_HEIGHT);
        Rectangle rect2 = new Rectangle(tank.getX(), tank.getY(), Tank.TANK_WIDTH, Tank.TANK_HEIGHT);
        if (rect.intersects(rect2)) {
            tank.die();
            this.die();
            tf.exploders.add(new Explode(tank.getX(), tank.getY(), tf));
        }
    }

    private void die() {
        this.live = false;
    }
}
