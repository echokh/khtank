package com.khstudy.tank;

import com.khstudy.tank.abstractfactory.DefaultGameFactory;
import com.khstudy.tank.abstractfactory.GameFactory;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame frame = new TankFrame();

        int initTankCount = Integer.parseInt(PropertyMgr.get("initTankCount").toString());
        GameFactory gameFactory = DefaultGameFactory.getInstance();
        for (int i = 0; i < initTankCount; i++) {
            frame.enemies.add(new Tank(50 + i * 60, 200, Direction.DOWN, frame, Group.BAD));
        }

        while (true) {
            Thread.sleep(50);
            frame.repaint();
        }
    }
}
