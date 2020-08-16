package com.khstudy.tank.cor;

import com.khstudy.tank.mediator.GameObject;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ColliderChain implements Collider {

    private List<Collider> colliders = new LinkedList<>();

    public ColliderChain() {
        add(new BulletTankCollider());
        add(new TankTankCollider());
        add(new TankWallCollider());
        add(new BulletWallCollider());
    }

    public void add(Collider c) {
        colliders.add(c);
    }


    public boolean collideWith(GameObject o1, GameObject o2) {
        Iterator<Collider> iterator = colliders.iterator();
        while (iterator.hasNext()) {
            Collider next = iterator.next();
            if (!next.collideWith(o1, o2)) {
                return false;
            }
        }
        return true;
    }
}
