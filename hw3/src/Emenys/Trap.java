package Emenys;

import Board.*;
import ObserverPattern.Observer;
import Players.Player;
import VisitorPattern.Visited;

public class Trap extends Enemy implements Observer {
    private int visibilityTime;
    private int invisibilityTime;
    int count;
    boolean visible;

    public Trap(Point point, char character, String name, int attack, int defence, int health, int visibilityTime, int invisibilityTime, int expValue ) {
        super(expValue,point, character, name, attack, defence, health);
        this.visibilityTime=visibilityTime;
        this.invisibilityTime=invisibilityTime;
    }

    @Override
    public void onTickAct(Board board) {
        if(visibilityTime>0) visibilityTime--;
        if(invisibilityTime>0) invisibilityTime--;
    }

    @Override
    public void act(Board b) {

    }

    @Override
    public boolean accept(Player p) {
        return false;
    }

    @Override
    public boolean accept(Monster m) {
        return false;
    }

    @Override
    public boolean visit(Visited V) {
        return false;
    }
}
