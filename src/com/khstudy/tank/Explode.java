package com.khstudy.tank;

import com.khstudy.tank.Facade.GameModel;
import com.khstudy.tank.abstractfactory.BaseExplode;
import com.khstudy.tank.mediator.GameObject;

import java.awt.*;

public class Explode extends GameObject {
    private int x, y;
    GameModel gameModel = null;

    private boolean live = true;

    public boolean isLive() {
        return live;
    }

    private int step = 0;

    public Explode(int x, int y, GameModel gameModel) {
        this.x = x;
        this.y = y;
        this.gameModel = gameModel;
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
