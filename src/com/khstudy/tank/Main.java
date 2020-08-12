package com.khstudy.tank;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame frame = new TankFrame();

        for (int i = 0; i < 5; i++) {
            frame.enemies.add(new Tank(50 + i * 60, 200, Direction.DOWN, frame,Group.BAD));
        }

        while (true) {
            Thread.sleep(50);
            frame.repaint();
        }
    }
}
