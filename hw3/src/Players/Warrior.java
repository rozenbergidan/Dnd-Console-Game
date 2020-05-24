package Players;

import Board.*;
import Emenys.Monster;
import VisitorPattern.Visited;

public class Warrior extends Player{

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
