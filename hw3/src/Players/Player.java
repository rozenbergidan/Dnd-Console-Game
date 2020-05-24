package Players;

import Board.*;
import ObserverPattern.Observer;
import Tiles.*;

public abstract class Player extends Unit implements Observer{
    //    public final char ON_MAP='@';
    private final int START_LEVEL=1;
    private final int START_EXP=0;
    int level;
    int exp;

    public Player(String name, int attack, int defence,int health,Point point){
        super(point,'@',name, attack, defence, health);
        level=START_LEVEL;
        exp=START_EXP;
    }

    public abstract void castSpacialAbillity();

    public void act(char action) {// get the action char from the gameController
        //if (action == 'e')

    }
}
