package Tiles;

import Board.*;
import ObserverPattern.*;
import VisitorPattern.*;

public abstract class Unit  extends Tile implements Observer, Visitor {

    // FILDES
    private String name;
    private Health health;
    private int attackPoint;
    private int defencePoint;

    public Unit(Point point,char character, String name, int attack, int defence, int health){
        this.location=point;
        this.character=character;
        this.name=name;
        this.attackPoint=attack;
        this.defencePoint=defence;
        this.health=new Health(health);
    }

    public abstract void onTickAct(Board board);

    private class  Health{// nested class
        int healthPool;
        int healthAmount;
    }
}
