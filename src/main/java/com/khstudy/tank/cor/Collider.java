package main.java.com.khstudy.tank.cor;


import main.java.com.khstudy.tank.mediator.GameObject;

public interface Collider {

    abstract boolean  collideWith(GameObject o1, GameObject o2);

}
