package com.khstudy.tank.cor;

import com.khstudy.tank.Bullet;
import com.khstudy.tank.Tank;
import com.khstudy.tank.mediator.GameObject;
import com.khstudy.tank.mediator.Wall;

public class BulletWallCollider implements Collider {

    @Override
    public boolean collideWith(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Wall) {
            Bullet t1 = (Bullet) o1;
            Wall w2 = (Wall) o2;
            if (t1.getRect().intersects(w2.getRec())) {
                t1.die();
            }
        } else if (o1 instanceof Wall && o2 instanceof Bullet) {
            collideWith(o2, o1);
        }
        return true;
    }
}
