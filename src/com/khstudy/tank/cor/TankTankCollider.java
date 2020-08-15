package com.khstudy.tank.cor;

import com.khstudy.tank.Bullet;
import com.khstudy.tank.Group;
import com.khstudy.tank.Tank;
import com.khstudy.tank.mediator.GameObject;

public class TankTankCollider implements Collider {
    @Override
    public boolean collideWith(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank) {
            Tank t1 = (Tank) o1;
            Tank t2 = (Tank) o2;
            if (t1.getRect().intersects(t2.getRect())) {
                t1.setX(t1.getPrevX());
                t1.setY(t1.getPrevY());
                t2.setX(t2.getPrevX());
                t2.setY(t2.getPrevY());
            }
        }
        return true;
    }
}
