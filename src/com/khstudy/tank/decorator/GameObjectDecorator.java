package com.khstudy.tank.decorator;

import com.khstudy.tank.mediator.GameObject;

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
