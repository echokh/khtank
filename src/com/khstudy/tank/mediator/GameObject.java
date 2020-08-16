package com.khstudy.tank.mediator;

import java.awt.*;

/**
 * 作为游戏中所有商品的父类
 */
public abstract class GameObject {

    protected int x,y;

    public abstract void paint(Graphics g);
}
