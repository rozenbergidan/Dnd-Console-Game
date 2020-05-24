package Players;

import Board.*;
import Emenys.Monster;
import VisitorPattern.Visited;

public class Mage extends Player{
    private Mana mana;
    private int manaCost;
    private int spellPower;
    private int hitsCount;

    public Mage(String name, int attack, int defence, int health, Point point) {
        super(name, attack, defence, health, point);
    }

    @Override
    public void act() {

    }

    @Override
    public void onTickAct(Board board) {

    }

    @Override
    public void accept(Player p){

    }

    @Override
    public void accept(Monster m) {

    }

    @Override
    public void visit(Visited V) {

    }

    private class Mana{// nested class
        private int manaPool;
        private int currentMana;

        public Mana(int manaPool){
            this.manaPool=manaPool;
            this.currentMana=manaPool;
        }
    }

    private class SpecialAbility{

        private String name;
        private String desc;
        private int range;

    }
}
