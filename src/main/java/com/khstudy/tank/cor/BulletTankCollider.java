package main.java.com.khstudy.tank.cor;


import main.java.com.khstudy.tank.Bullet;
import main.java.com.khstudy.tank.Tank;
import main.java.com.khstudy.tank.mediator.GameObject;

public class BulletTankCollider implements Collider {
    @Override
    public boolean collideWith(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank) {
            return !((Bullet) o1).collideWith((Tank) o2);
        } else if (o2 instanceof Bullet && o1 instanceof Tank) {
            collideWith(o2, o1);
        }
        return true;
    }
}