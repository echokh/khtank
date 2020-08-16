package com.khstudy.tank;

import com.khstudy.tank.Facade.GameModel;
import com.khstudy.tank.mediator.GameObject;

import java.awt.*;

public class Explode extends GameObject {
    private int x, y;
    GameModel gameModel = GameModel.getInstance();

    private boolean live = true;

    public boolean isLive() {
        return live;
    }

    private int step = 0;

    public Explode(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void paint(Graphics g) {
        if (step >= ResourceMgr.explode.length) {
            live = false;
            return;
        }
        g.drawImage(ResourceMgr.explode[step++], x, y, null);
    }
}
