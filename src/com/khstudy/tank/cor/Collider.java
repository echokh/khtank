package com.khstudy.tank.cor;

import com.khstudy.tank.mediator.GameObject;

public interface Collider {

    abstract boolean  collideWith(GameObject o1, GameObject o2);

}
