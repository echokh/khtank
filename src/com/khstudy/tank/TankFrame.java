package com.khstudy.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {

    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;

    public TankFrame() {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        setTitle("Tank War");
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.addKeyListener(new MyKeyListener());
    }

    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(WINDOW_WIDTH, WINDOW_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.black);
        gOffScreen.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    Tank myTank = new Tank(200, 500, Direction.UP, this, Group.GOOD);
    List<Bullet> bullets = new ArrayList<>();
    List<Tank> enemies = new ArrayList<>();
    List<Explode> exploders = new ArrayList<>();


    /**
     * 窗口需要重新绘制的时候
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        Color c=g.getColor();
        g.setColor(Color.white);
        g.drawString("子弹的数量"+bullets.size(),10,60);
        g.drawString("敌人的数量"+enemies.size(),10,80);
        g.drawString("爆炸的数量"+exploders.size(),10,100);
        g.setColor(c);
        myTank.paint(g);
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }
        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).paint(g);
        }
        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < enemies.size(); j++) {
                bullets.get(i).collodeWith(enemies.get(j));
            }
        }
        for (int i = 0; i < exploders.size(); i++) {
            if (exploders.get(i).isLive()) {
                exploders.get(i).paint(g);
            } else {
                exploders.remove(i);
            }
        }
    }


    class MyKeyListener extends KeyAdapter {

        boolean BL = false, BU = false, BR = false, BD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT: {
                    myTank.setDirection(Direction.LEFT);
                    break;
                }
                case KeyEvent.VK_UP: {
                    myTank.setDirection(Direction.UP);
                    break;
                }
                case KeyEvent.VK_DOWN: {
                    myTank.setDirection(Direction.DOWN);
                    break;
                }
                case KeyEvent.VK_RIGHT: {
                    myTank.setDirection(Direction.RIGHT);
                    break;
                }
            }
            myTank.setMoving(true);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT: {
                    BL = false;
                    break;
                }
                case KeyEvent.VK_UP: {
                    BU = false;
                    break;
                }
                case KeyEvent.VK_DOWN: {
                    BD = false;
                    break;
                }
                case KeyEvent.VK_RIGHT: {
                    BR = false;
                    break;
                }
                case KeyEvent.VK_SPACE: {
                    myTank.fire();
                    break;
                }
            }
        }
    }
}
