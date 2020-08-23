package main.java.com.khstudy.tank.decorator;


import main.java.com.khstudy.tank.mediator.GameObject;

import java.awt.*;

public class GameObjectDecorator extends GameObject {

    GameObject gameObject;

    public GameObjectDecorator(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    @Override
    public void paint(Graphics g) {
        gameObject.paint(g);
    }
}
