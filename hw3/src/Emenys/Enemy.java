package Emenys;

import Board.*;
import Tiles.Unit;

public abstract class Enemy extends Unit {

    private int expValue;

    public Enemy(int expValue,Point point, char character, String name, int attack, int defence, int health) {
        super(point, character, name, attack, defence, health);
        this.expValue=expValue;
    }

    public int getExpValue(){
        return expValue;
    }

    @Override
    public void died() {
        Board.getBoard().unitDied(this);
    }

    public abstract void act();
}
