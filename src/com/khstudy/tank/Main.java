package com.khstudy.tank;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame frame = new TankFrame();
        while (true) {
            Thread.sleep(60);
            frame.repaint();
        }
    }
}
