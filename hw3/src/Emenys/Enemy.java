package Emenys;

import Board.*;
import Tiles.Unit;

public abstract class Enemy extends Unit {
    private int expValue;


    public Enemy(Point point, char character, String name, int attack, int defence, int health) {
        super(point, character, name, attack, defence, health);
    }
}
