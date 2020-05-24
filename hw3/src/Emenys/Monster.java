package Emenys;

import Board.*;
import Players.Player;
import VisitorPattern.*;

public class Monster extends Enemy implements Visitor {

    private int vision;

    public Monster(Point point, char character, String name, int attack, int defence, int health, int vision,int expValue) {
        super(expValue,point, character, name, attack, defence, health);
        this.vision=vision;
    }


    @Override
    public void act(Board b) {

    }

    public void randomWalk(Board b){

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
