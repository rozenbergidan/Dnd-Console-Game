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
        String output = getName() + " reached level " + level +  ": +" + (level * 10) + " Health, +"+ (level * 7) + " Attack, +"+ (level * 1) + "Defense";
    }

    @Override
    public void castSpacialAbillity() {
        String output="";
        if(energy.currentEnergy<specialAbility.energyCost){
            output=getName()+" tried to cast "+specialAbility.name+", but there was not enough "+energy.toString()+".\n";
        }
        else{
            energy.currentEnergy=energy.currentEnergy-specialAbility.energyCost;
            List<Enemy> inRangeEnemies=Board.getBoard().enemiesInRangeRogue(this,specialAbility.range);
            output=getName()+" cast "+specialAbility.name+".\n";
            for(Enemy e: inRangeEnemies){
                //TODO continue this
                e.attackMe(attackPoint,this);
            }
        }
    }

    @Override
    public void onTickAct(Board board) {
        energy.currentEnergy=Math.min(energy.currentEnergy+10,100);
    }


    public String toString(){
        return super.toString()+"\t\t"+energy.toString();
    }

    private class Energy{
        private final int MAX_ENERGY=100;

        private int totalEnergy;
        private int currentEnergy;

        public Energy(){
            this.totalEnergy=MAX_ENERGY;
            this.currentEnergy=MAX_ENERGY;
        }

        public String toString(){
            String output="";
            output="Energy: "+currentEnergy+"/"+totalEnergy;
            return output;
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
