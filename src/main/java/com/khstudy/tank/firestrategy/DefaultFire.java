package main.java.com.khstudy.tank.firestrategy;


import main.java.com.khstudy.tank.Bullet;
import main.java.com.khstudy.tank.Tank;

public class DefaultFire implements FireStrategy {

    private final static DefaultFire dff = new DefaultFire();

    private DefaultFire() {
    }

    public static DefaultFire getInstance() {
        return dff;
    }

    @Override
    public void fire(Tank t) {
        new Bullet(t.getX() + Tank.TANK_WIDTH / 5 * 2, t.getY() + Tank.TANK_HEIGHT / 2, t.getDirection(),  t.group);
    }
}
