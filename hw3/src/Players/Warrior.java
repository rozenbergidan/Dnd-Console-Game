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

    public void levelUP(){
        super.levelUP();
        health.setHealthPool(health.getHealthPool()+5*level);
        attackPoint=attackPoint+2*level;
        defencePoint=defencePoint+level;
    }

    @Override
    public void castSpacialAbillity() {
        if(specialAbility.remainingCooldown>0){//print error message

        }
        else{
            List<Enemy> inRangeEnemies=Board.getBoard().enemiesInRangeWarrior(this,specialAbility.range);
            Enemy attackedEnemy=inRangeEnemies.get((int)Math.random()*inRangeEnemies.size());

            health.healthIncrease(10*defencePoint);
            attackedEnemy.health.healthDecrease((int)(health.getHealthPool()*0.1));// if dead need to do something
            specialAbility.remainingCooldown=specialAbility.coolDown;
        }
    }

    @Override
    public void onTickAct(Board board) {
        if (specialAbility.coolDown > 0) specialAbility.coolDown--;
    }

    public void print(){

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
            this.coolDown = coolDown;
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
    }
}



