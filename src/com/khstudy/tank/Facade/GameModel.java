package com.khstudy.tank.Facade;

import com.khstudy.tank.*;
import com.khstudy.tank.abstractfactory.BaseExplode;
import com.khstudy.tank.cor.BulletTankCollider;
import com.khstudy.tank.cor.Collider;
import com.khstudy.tank.cor.ColliderChain;
import com.khstudy.tank.cor.TankTankCollider;
import com.khstudy.tank.mediator.GameObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {

    public Tank myTank = new Tank(200, 500, Direction.UP, this, Group.GOOD);
//    public java.util.List<Bullet> bullets = new ArrayList<>();
//    public java.util.List<Tank> enemies = new ArrayList<>();
//    public List<Explode> exploders = new ArrayList<>();

//    Collider collider = new BulletTankCollider();
//    Collider tankTankCollider = new TankTankCollider();

   ColliderChain colliderChain= new ColliderChain();

    private List<GameObject> objects = new ArrayList<>();

    public void add(GameObject go) {
        this.objects.add(go);
    }

    public void remove(GameObject go) {
        this.objects.remove(go);
    }

    public GameModel() {
        int initTankCount = Integer.parseInt(PropertyMgr.get("initTankCount").toString());
        for (int i = 0; i < initTankCount; i++) {
            objects.add(new Tank(50 + i * 60, 200, Direction.DOWN, this, Group.BAD));
        }

    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.white);
        g.setColor(c);
        myTank.paint(g);
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(g);
        }
        //碰撞
        for (int i = 0; i < objects.size(); i++) {
            for (int j = i + 1; j < objects.size(); j++) {
                GameObject o1 = objects.get(i);
                GameObject o2 = objects.get(j);
                colliderChain.collideWith(o1,o2);
            }
        }
//        for (int i = 0; i < bullets.size(); i++) {
//            bullets.get(i).paint(g);
//        }
//        for (int i = 0; i < bullets.size(); i++) {
//            for (int j = 0; j < enemies.size(); j++) {
//                bullets.get(i).collodeWith(enemies.get(j));
//            }
//        }
//        for (int i = 0; i < exploders.size(); i++) {
//            if (exploders.get(i).isLive()) {
//                exploders.get(i).paint(g);
//            } else {
//                exploders.remove(i);
//            }
//        }
    }

    public Tank getMyTank() {
        return myTank;
    }
}
