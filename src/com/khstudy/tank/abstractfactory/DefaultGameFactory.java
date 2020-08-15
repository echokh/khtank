package com.khstudy.tank.abstractfactory;

import com.khstudy.tank.*;

public class DefaultGameFactory extends GameFactory {

    /**
     * 将工厂修改为单例模式
     */
    private static final DefaultGameFactory df = new DefaultGameFactory();

    private DefaultGameFactory() {
    }

    public static DefaultGameFactory getInstance() {
        return df;
    }
    @Override
    public Tank createTank(int x, int y, Direction direction, TankFrame tf, Group group) {
        return new Tank(x, y, direction, tf, group);
    }

    @Override
    public Explode createExplode(int x, int y, TankFrame tankFrame) {
        return new Explode(x, y, tankFrame);
    }

    @Override
    public Bullet createBullet(int x, int y, Direction direction, TankFrame tf, Group group) {
        return new Bullet(x, y, direction, tf, group);
    }
}
