package com.khstudy.tank;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame frame = new TankFrame();

        int initTankCount= Integer.parseInt(PropertyMgr.get("initTankCount").toString());

        for (int i = 0; i < initTankCount; i++) {
            frame.enemies.add(new Tank(50 + i * 60, 200, Direction.DOWN, frame,Group.BAD));
        }

        while (true) {
            Thread.sleep(50);
            frame.repaint();
        }
    }
}
