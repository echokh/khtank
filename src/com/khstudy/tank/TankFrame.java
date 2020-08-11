package com.khstudy.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

    public static final int WINDOW_WIDTH=800;
    public static final int WINDOW_HEIGHT=600;

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

    Image offScreenImage=null;

    @Override
    public void update(Graphics g) {
        super.update(g);
        if(offScreenImage==null){
            offScreenImage=this.createImage(WINDOW_WIDTH,WINDOW_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.white);
        gOffScreen.fillRect(0,0,WINDOW_WIDTH,WINDOW_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage,0,0,null);
    }

    Tank myTank = new Tank(200, 200, Direction.DOWN,this);
    Bullet bullet=new Bullet(300,300,Direction.DOWN,this);
    /**
     * 窗口需要重新绘制的时候
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
//        super.paint(g);
        myTank.paint(g);
        bullet.paint(g);
    }


    class MyKeyListener extends KeyAdapter {

        boolean BL = false, BU = false, BR = false, BD = false;
        boolean bulletMove=false;

        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT: {
                    BL = true;
                    break;
                }
                case KeyEvent.VK_UP: {
                    BU = true;
                    break;
                }
                case KeyEvent.VK_DOWN: {
                    BD = true;
                    break;
                }
                case KeyEvent.VK_RIGHT: {
                    BR = true;
                    break;
                }

            }
            myTank.moveTank(BL, BU, BR, BD);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);
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
                case KeyEvent.VK_SPACE:{
                    myTank.fire();
                   break;
                }
            }
        }
    }
}
