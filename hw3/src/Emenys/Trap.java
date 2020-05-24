package Emenys;

import Board.*;
import ObserverPattern.Observer;
import Players.Player;
import VisitorPattern.Visited;

public class Trap extends Enemy implements Observer {
    private int visibilityTime;
    private int invisibilityTime;
    public Trap(Point point, char character, String name, int attack, int defence, int health, int visibilityTime, int invisibilityTime, int expValue ) {
        super(expValue,point, character, name, attack, defence, health);
        this.visibilityTime=visibilityTime;
        this.invisibilityTime=invisibilityTime;
    }

    @Override
    public void onTickAct(Board board) {

    }

    @Override
    public void act(Board b) {

    }

    @Override
    public void accept(Player p) {

    }

    @Override
    public void accept(Monster m) {

    }

    @Override
    public void visit(Visited V) {

    }
}
