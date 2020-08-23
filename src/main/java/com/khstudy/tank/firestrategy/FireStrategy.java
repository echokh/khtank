package main.java.com.khstudy.tank.firestrategy;


import main.java.com.khstudy.tank.Tank;

public interface FireStrategy<T> {
    void fire(Tank t);
}
