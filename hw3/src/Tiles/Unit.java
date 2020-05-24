package Tiles;

import Board.*;
import ObserverPattern.*;
import VisitorPattern.*;

public abstract class Unit  extends Tile implements Observer, Visitor {

    // FILDES
    private String name;
    private Health health;
    private int attackPoint;
    private int deffencePoint;


    public abstract void onTickAct(Board board);

    private class  Health{// nested class
        int healthPool;
        int HealthAmount;
    }
}
