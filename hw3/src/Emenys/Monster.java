package Emenys;

import Board.*;
import Players.Player;
import VisitorPattern.*;

public class Monster extends Enemy implements ActiveCharacter, Visitor {

    private int vision;
    @Override
    public void onTickAct(Board board) {

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
    public void visit(Visited V) {

    }
}
