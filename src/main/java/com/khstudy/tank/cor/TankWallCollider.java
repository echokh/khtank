package main.java.com.khstudy.tank.cor;


import main.java.com.khstudy.tank.Tank;
import main.java.com.khstudy.tank.mediator.GameObject;
import main.java.com.khstudy.tank.mediator.Wall;

public class TankWallCollider implements Collider {
    @Override
    public boolean collideWith(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Wall) {
            Tank t1 = (Tank) o1;
            Wall w2 = (Wall) o2;
            if (t1.getRect().intersects(w2.getRec())) {
                t1.setX(t1.getPrevX());
                t1.setY(t1.getPrevY());
            }
        } else if (o1 instanceof Wall && o2 instanceof Tank) {
            collideWith(o2, o1);
        }
        return true;
    }
}
