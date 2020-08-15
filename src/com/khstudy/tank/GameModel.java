package com.khstudy.tank;

import com.khstudy.tank.abstractfactory.BaseExplode;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {

    Tank myTank = new Tank(200, 500, Direction.UP, this, Group.GOOD);
    java.util.List<Bullet> bullets = new ArrayList<>();
    java.util.List<Tank> enemies = new ArrayList<>();
    List<BaseExplode> exploders = new ArrayList<>();

    public GameModel() {
        int initTankCount = Integer.parseInt(PropertyMgr.get("initTankCount").toString());
        for (int i = 0; i < initTankCount; i++) {
            enemies.add(new Tank(50 + i * 60, 200, Direction.DOWN, this, Group.BAD));
        }

    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.white);
        g.drawString("子弹的数量" + bullets.size(), 10, 60);
        g.drawString("敌人的数量" + enemies.size(), 10, 80);
        g.drawString("爆炸的数量" + exploders.size(), 10, 100);
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

    public Tank getMyTank() {
        return myTank;
    }
}
