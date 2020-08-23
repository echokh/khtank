package main.java.com.khstudy.tank.decorator;


import main.java.com.khstudy.tank.mediator.GameObject;

import java.awt.*;

public class RectDecorator extends GameObjectDecorator {
    public RectDecorator(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Color color = g.getColor();
        g.setColor(Color.yellow);
        g.drawRect(x, y, 10, 10);
        g.setColor(color);
    }
}
