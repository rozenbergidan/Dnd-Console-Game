package Players;

import Board.*;
import Control.ScreenWriter;
import Emenys.Enemy;
import Emenys.Monster;
import VisitorPattern.Visited;

import java.util.List;

public class Hunter extends Player{
    private int arrows;
    private SpecialAbility specialAbility;

    public Hunter(String name, int attack, int defence, int health, int range, Point point) {
        super(name, attack, defence, health, point);
        specialAbility=new SpecialAbility(range);
    }

    public void levelUP(){
        super.levelUP();
        arrows = arrows + 10*level;
        attackPoint = attackPoint + 2*level;
        defencePoint = defencePoint + level;
        String output = getName() + " reached level " + level +  ": +" + (level * 10) + " Health, +"+ (level * 6) + " Attack, +"+ (level * 2) + " Defense ";
        ScreenWriter.getScreanWriter().print(output);
    }

    @Override
    public void castSpacialAbillity() {
        String output="";
        if(arrows ==0){//print error message
            output=getName()+" tried to cast "+specialAbility.name+", but there are no arrows left.\n";
            ScreenWriter.getScreanWriter().print(output);
        }
        else{
            List<Enemy> inRangeEnemies =Board.getBoard().enemiesInRange(this,specialAbility.range);
            Enemy toAttack = null;
            for (Enemy enemy: inRangeEnemies) {
                if (toAttack == null) toAttack = enemy;
                else {
                    if (this.location.range(enemy.getLocation()) < this.location.range(toAttack.getLocation()))
                        toAttack = enemy;

                }
            }
                if (toAttack != null) {
                    output = getName() + " fired an arrow at " + toAttack.getName();
                    ScreenWriter.getScreanWriter().print(output);
                    toAttack.attackMe(attackPoint, this);
                    arrows = arrows - 1;
                }
                else{
                    output = getName()+" tried to shoot an arrow but there were no enemies in range.";
                    ScreenWriter.getScreanWriter().print(output);
                }
        }
    }


    @Override
    public void onTickAct(Board board) {

        if (specialAbility.tickCount == 10) {
            arrows = arrows + level;
            specialAbility.tickCount = 0;
        }
        else specialAbility.tickCount++;
    }


    public String toString(){
        return super.toString() + "\t\t" + specialAbility.toString();
    }


    private class SpecialAbility{ //nested class
        private final String NAME="Shoot";
       private final String DESCRIPTION="add hunter ability description here...";


        private int tickCount;
        private String name;
        private String desc;
        private double range;


        public SpecialAbility(int range){
            this.name=NAME;
            this.desc=DESCRIPTION;
            this.range=range;
            this.tickCount = 0;
        }

        @Override
        public String toString() {
            return "Arrows: "+ arrows +"\t\t Range: " + (int)range;
        }
    }

}
