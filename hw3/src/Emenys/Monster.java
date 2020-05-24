package Emenys;

import Board.*;
import Players.Player;
import VisitorPattern.*;

public class Monster extends Enemy implements Visitor {

    private int vision;


    @Override
    public void act(Board b) {

    }

    public void randomWalk(Board b){

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
    public void visit(Visited V) {

    }
}
