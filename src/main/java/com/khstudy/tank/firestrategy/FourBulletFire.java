package main.java.com.khstudy.tank.firestrategy;


import main.java.com.khstudy.tank.Bullet;
import main.java.com.khstudy.tank.Direction;
import main.java.com.khstudy.tank.Tank;

public class FourBulletFire implements FireStrategy {
    private final static FourBulletFire fbf = new FourBulletFire();

    private FourBulletFire() {
    }

    public static FourBulletFire getInstance() {
        return fbf;
    }

    @Override
    public void fire(Tank t) {
        new Bullet(t.getX() + Tank.TANK_WIDTH / 5 * 2, t.getY() + Tank.TANK_HEIGHT / 2, Direction.UP, t.group);
        new Bullet(t.getX() + Tank.TANK_WIDTH / 5 * 2, t.getY() + Tank.TANK_HEIGHT / 2, Direction.DOWN, t.group);
        new Bullet(t.getX() + Tank.TANK_WIDTH / 5 * 2, t.getY() + Tank.TANK_HEIGHT / 2, Direction.LEFT, t.group);
        new Bullet(t.getX() + Tank.TANK_WIDTH / 5 * 2, t.getY() + Tank.TANK_HEIGHT / 2, Direction.RIGHT, t.group);
    }
}
