package com.khstudy.tank.firestrategy;

import com.khstudy.tank.Bullet;
import com.khstudy.tank.Tank;

import java.util.List;

public class DefaultFire implements FireStrategy {

    private final static DefaultFire dff = new DefaultFire();

    private DefaultFire() {
    }

    public static DefaultFire getInstance() {
        return dff;
    }

    @Override
    public void fire(Tank t) {
        new Bullet(t.getX() + Tank.TANK_WIDTH / 5 * 2, t.getY() + Tank.TANK_HEIGHT / 2, t.getDirection(), t.gm, t.group);
    }
}
