package main.java.com.khstudy.tank;


import main.java.com.khstudy.tank.Facade.GameModel;
import main.java.com.khstudy.tank.firestrategy.DefaultFire;
import main.java.com.khstudy.tank.firestrategy.FireStrategy;
import main.java.com.khstudy.tank.mediator.GameObject;

import java.awt.*;
import java.util.Random;

public class Tank extends GameObject {
    private int x, y;
    private Direction direction = Direction.DOWN;

    public static int TANK_WIDTH = 50;
    public static int TANK_HEIGHT = 50;

    private Rectangle rect = new Rectangle();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }


    private static final int tankSpeed = 2;
    private boolean live = true;
    private boolean moving = false;
    public Group group = Group.BAD;

    private Random random = new Random();

    public Tank(int x, int y, Direction direction, Group group) {
        this.x = x;
        this.y = y;
        this.group = group;
        if (group == Group.BAD) {
            this.moving = true;
        }

        rect.x = x;
        rect.y = y;
        rect.width = TANK_WIDTH;
        rect.height = TANK_HEIGHT;
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

    @Override
    public void paint(Graphics g) {
        if (!live) {
            GameModel.getInstance().remove(this);
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

    private int prevX, prevY;

    public void setX(int x) {
        this.x = x;
        this.rect.x = x;
    }

    public void setY(int y) {
        this.y = y;
        this.rect.y = y;
    }

    public int getPrevX() {
        return prevX;
    }

    public int getPrevY() {
        return prevY;
    }

    public void moveTank() {
        prevX = x;
        prevY = y;
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
            if (random.nextInt(150) == 8) this.fire(DefaultFire.getInstance());
            switchDir();
        }
        boundCheck();
        rect.x = this.x;
        rect.y = this.y;
    }

    private void boundCheck() {
        x = Math.min(TankFrame.WINDOW_WIDTH - TANK_WIDTH, x);
        x = Math.max(0, x);
        y = Math.min(TankFrame.WINDOW_HEIGHT - TANK_HEIGHT, y);
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

    /**
     * 使用策略设计模式
     *
     * @param f
     */
    public void fire(FireStrategy f) {
        f.fire(this);
    }

    public void die() {
        this.live = false;
    }
}
