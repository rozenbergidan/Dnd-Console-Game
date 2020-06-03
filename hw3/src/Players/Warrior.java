package Players;

import Board.*;
import Emenys.Enemy;
import Emenys.Monster;
import Tiles.Unit;
import VisitorPattern.Visited;

import java.util.List;

public class Warrior extends Player {

    private SpecialAbility specialAbility;

    public Warrior(String name, int attack, int defence, int cooldown, int health, Point point) {
        super(name, attack, defence, health, point);
        specialAbility = new SpecialAbility(cooldown);
    }

    @Override
    public void levelUP(){
        super.levelUP();
        health.setHealthPool(health.getHealthPool()+5*level);
        attackPoint=attackPoint+2*level;
        defencePoint=defencePoint+level;

        String output = getName() + " reached level " + level +  ": +" + (level * 15) + " Health, +"+ (level * 6) + " Attack, +"+ (level * 2) + "Defense";
    }

    @Override
    public void castSpacialAbillity() {
        if(specialAbility.remainingCooldown>0){//print error message
            String output=getName()+" tried to cast "+specialAbility.name+", but there is a cooldown: "+specialAbility.remainingCooldown+".\n";
            //TODO print to Screen
        }
        else{
            List<Enemy> inRangeEnemies=Board.getBoard().enemiesInRangeWarrior(this,specialAbility.range);
            Enemy attackedEnemy=inRangeEnemies.get((int)Math.random()*inRangeEnemies.size()); /////////////////////////// TODO: this line throws exeption if no enemy is in the range
            health.healthIncrease(10*defencePoint);
            String output=getName()+" used "+specialAbility.name+", healing for "+10*defencePoint+".\n";
            attackedEnemy.attackMe((int)(health.getHealthPool()*0.1),this);
            specialAbility.remainingCooldown=specialAbility.coolDown;
            //TODO print to Screen
        }
    }

    @Override
    public void onTickAct(Board board) {
        if (specialAbility.remainingCooldown > 0) specialAbility.remainingCooldown--;
    }

    public String toString(){
        return super.toString()+"\t\t"+specialAbility.toString();
    }

    private class SpecialAbility{
        private final String NAME = "Avenger’s Shield";
        private final String DESCRIPTION = "randomly hits one enemy withing range < 3 for an amount\n" +
                "equals to 10% of the warrior’s max health and heals the warrior for amount equals to (10\u0002defense)\n" +
                "(but will not exceed the total amount of health pool).";
        private final double MAX_RANGE = 3;

        private String name;
        private String description;
        private int coolDown;
        private int remainingCooldown;
        private boolean available;
        private double range;

        public SpecialAbility(int cd) {
            this.name = NAME;
            this.description = DESCRIPTION;
            this.coolDown = cd;
            remainingCooldown = 0;
            available = true;
            range = MAX_RANGE;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public double getRange() {
            return range;
        }

        public int getCoolDown() {
            return remainingCooldown;
        }

        public void setCoolDown() {
            remainingCooldown = coolDown;
        }

        public boolean isAvailable() {
            return available;
        }

        public String toString(){
            String output="";
            output="CoolDown: "+remainingCooldown+"/"+coolDown;
            return output;
        }
    }
}



