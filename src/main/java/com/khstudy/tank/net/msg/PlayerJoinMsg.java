package main.java.com.khstudy.tank.net.msg;


import main.java.com.khstudy.tank.Direction;
import main.java.com.khstudy.tank.Group;

import java.util.UUID;

public class PlayerJoinMsg extends Msg {
    int x,y;
    Direction dir;
    Group group;
    public UUID id;
    String name;

    public PlayerJoinMsg() {
    }
}
