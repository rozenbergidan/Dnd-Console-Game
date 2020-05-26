package Players;

import Board.*;
import Emenys.Enemy;
import Emenys.Monster;
import VisitorPattern.Visited;

import java.util.List;

public class Rogue extends Player{
    private Energy energy;
    private SpecialAbility specialAbility;

    public Rogue(String name, int attack, int defence, int health,int energyCost, Point point) {
        super(name, attack, defence, health, point);
        energy=new Energy();
        specialAbility=new SpecialAbility(energyCost);
    }

    public void levelUP(){
        super.levelUP();
        energy.currentEnergy=100;
        attackPoint=attackPoint+3*level;
    }

    @Override
    public void castSpacialAbillity() {
        if(energy.currentEnergy<specialAbility.energyCost){
            //print error message
        }
        else{
            energy.currentEnergy=energy.currentEnergy-specialAbility.energyCost;
            List<Enemy> inRangeEnemies=Board.getBoard().enemiesInRangeRogue(this,specialAbility.range);
            for(Enemy e: inRangeEnemies){
                //TODO continue this
                e.attackMe(attackPoint);
            }
        }
    }

    @Override
    public void onTickAct(Board board) {
        energy.currentEnergy=Math.min(energy.currentEnergy+10,100);
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

    private class Energy{
        private final int MAX_ENERGY=100;

        private int totalEnergy;
        private int currentEnergy;

        public Energy(){
            this.totalEnergy=MAX_ENERGY;
            this.currentEnergy=MAX_ENERGY;
        }
    }
    private class SpecialAbility{
        private final String NAME="Fan of Knives";
        private final String DESCRIPTION="hits everyone around the rogue for an amount equals to the\n" +
                "rogue’s attack points at the cost of energy.";
        private final int MAX_RANGE=2;

        private String name;
        private String desc;
        private int energyCost;
        private double range;

        public SpecialAbility(int energyCost){
            this.name=NAME;
            this.desc=DESCRIPTION;
            this.energyCost=energyCost;
            range=MAX_RANGE;
        }
    }
}
