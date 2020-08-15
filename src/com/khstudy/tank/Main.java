package com.khstudy.tank;

import com.khstudy.tank.abstractfactory.DefaultGameFactory;
import com.khstudy.tank.abstractfactory.GameFactory;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame frame = new TankFrame();
        //工厂模式
        //GameFactory gameFactory = DefaultGameFactory.getInstance();
        while (true) {
            Thread.sleep(50);
            frame.repaint();
        }
    }
}
