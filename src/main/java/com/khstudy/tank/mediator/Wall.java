package main.java.com.khstudy.tank.mediator;

import java.awt.*;

public class Wall extends GameObject {
    private final int WALL_WEIGHT;
    private final int WALL_HEIGHT;

    public Rectangle rec;

    public Wall(int x, int y, int WALL_WEIGHT, int WALL_HEIGHT) {
        this.x = x;
        this.y = y;
        this.WALL_WEIGHT = WALL_WEIGHT;
        this.WALL_HEIGHT = WALL_HEIGHT;
        this.rec = new Rectangle(x, y, WALL_WEIGHT, WALL_HEIGHT);
    }

    public Rectangle getRec() {
        return rec;
    }

    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.gray);
        g.fillRect(x, y, WALL_WEIGHT, WALL_HEIGHT);
        g.setColor(color);
    }
}
