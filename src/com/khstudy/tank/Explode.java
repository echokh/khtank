package com.khstudy.tank;

import com.khstudy.tank.abstractfactory.BaseExplode;

import java.awt.*;

public class Explode extends BaseExplode {
    private int x, y;
    TankFrame tf = null;

    private boolean live = true;

    @Override
    public boolean isLive() {
        return live;
    }

    private int step = 0;

    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
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
