package Players;

import Board.*;
import Control.ScreenWriter;
import Emenys.Enemy;
import Emenys.Monster;
import VisitorPattern.Visited;

import java.util.List;

public class Hunter extends Player{
    private int arrows;
    private int tickCount;
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
        String output = getName() + " add here level up hunter output";
        ScreenWriter.getScreanWriter().print(output);
    }

    @Override
    public void castSpacialAbillity() {
        String output="";
        if(arrows ==0){//print error message
            output=getName()+" tried to cast "+specialAbility.name+", add here spacial abbilety error message.\n";
            ScreenWriter.getScreanWriter().print(output);
        }
        else{
            List<Enemy> inRangeEnemies =Board.getBoard().enemiesInRange(this,specialAbility.range);

//            if(toAtack != null) {
//                toAtack.attackMe(attackPoint, this);
//                arrows = arrows -1;
//            }
        }

    }

    @Override
    public void onTickAct(Board board) {

        if (tickCount == 10) {
            arrows = arrows + 10*level;
            tickCount = 0;
        }
        else tickCount = tickCount + 1;
    }


    public String toString(){
        return super.toString() + "add hunter toString";
    }


    private class SpecialAbility{ //nested class
        private final String NAME="Shoot";
       private final String DESCRIPTION="add hunter ability description here...";

        private String name;
        private String desc;
        private double range;




        public SpecialAbility(int range){
            this.name=NAME;
            this.desc=DESCRIPTION;
            this.range=range;
        }
    }

}
