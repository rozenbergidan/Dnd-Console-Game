package Players;

import Board.*;
import Emenys.Monster;
import VisitorPattern.Visited;

public class Rogue extends Player{

    public Rogue(String name, int attack, int defence, int health, Point point) {
        super(name, attack, defence, health, point);
    }

    @Override
    public void act() {

    }

    @Override
    public void onTickAct(Board board) {

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

    private class SpecialAbility{
        private String name;
    }
}
