package com.khstudy.tank.abstractfactory;

import com.khstudy.tank.Direction;
import com.khstudy.tank.Group;
import com.khstudy.tank.TankFrame;

public abstract class GameFactory {
    public abstract BaseTank createTank(int x, int y, Direction direction, TankFrame tf, Group group);

    public abstract BaseExplode createExplode(int x, int y, TankFrame tankFrame);

    public abstract BaseBullet createBullet(int x, int y, Direction direction, TankFrame tf, Group group);
}
