package com.khstudy.tank;

import com.khstudy.tank.firestrategy.FourBulletFire;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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

    GameModel gameModel=new GameModel();

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



//    GameFactory gameFactory = DefaultGameFactory.getInstance();
//    GameFactory gameFactory = null;
//
//    //获取工厂
//    {
//        String gfStr = PropertyMgr.get("gameFactory").toString();
//        try {
//            gameFactory = (DefaultGameFactory) Class.forName(gfStr).newInstance();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

    /**
     * 窗口需要重新绘制的时候
     */
    @Override
    public void paint(Graphics g) {
        gameModel.paint(g);
    }


    class MyKeyListener extends KeyAdapter {

        boolean BL = false, BU = false, BR = false, BD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT: {
                    gameModel.getMyTank().setDirection(Direction.LEFT);
                    break;
                }
                case KeyEvent.VK_UP: {
                    gameModel.getMyTank().setDirection(Direction.UP);
                    break;
                }
                case KeyEvent.VK_DOWN: {
                    gameModel.getMyTank().setDirection(Direction.DOWN);
                    break;
                }
                case KeyEvent.VK_RIGHT: {
                    gameModel.getMyTank().setDirection(Direction.RIGHT);
                    break;
                }
            }
            gameModel.getMyTank().setMoving(true);
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
                    gameModel.getMyTank().fire(FourBulletFire.getInstance());
                    break;
                }
            }
        }
    }
}
