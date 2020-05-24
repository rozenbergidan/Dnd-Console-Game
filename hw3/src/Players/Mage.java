package Players;

import Board.Board;
import Emenys.Monster;
import VisitorPattern.Visited;

public class Mage extends Player{
    @Override
    public void act() {

    }

    @Override
    public void onTickAct(Board board) {

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

    private class Mana{// nested class

    }
}
