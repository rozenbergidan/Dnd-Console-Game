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
        count=0;
        visible=true;
    }

    @Override
    public void onTickAct(Board board) {
        count++;
        if(count>visibilityTime && visible) {
            visible = false;
            count=0;
        }
        else if(!visible && count>invisibilityTime){
            visible=true;
            count=0;
        }

    }

    @Override
    public void act() {

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
    public char getCharacter(){
        if (visible) return character;
        else return '.';
    }

}
