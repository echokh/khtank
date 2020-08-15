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
    public Tank createTank(int x, int y, Direction direction, GameModel gameModel, Group group) {
        return new Tank(x, y, direction, gameModel, group);
    }

    @Override
    public Explode createExplode(int x, int y, GameModel gameModel) {
        return new Explode(x, y, gameModel);
    }

    @Override
    public Bullet createBullet(int x, int y, Direction direction, GameModel gameModel, Group group) {
        return new Bullet(x, y, direction, gameModel, group);
    }
}
