package Players;

import Board.*;
import Control.ScreenWriter;
import Enemys.Enemy;

import java.util.LinkedList;
import java.util.List;

public class Warrior extends Player {
    //====================FIELDS==================
    private SpecialAbility specialAbility;
    private boolean castedOnCurrentTick;
    //=================CONSTRUCTOR=================
    public Warrior(String name, int attack, int defence, int cooldown, int health, Point point) {
        super(name, attack, defence, health, point);
        specialAbility = new SpecialAbility(cooldown);
        castedOnCurrentTick = false;
    }
    //================PUBLIC_METHODS===============
    @Override
    public void levelUP(){
        super.levelUP();
        health.setHealthPool(health.getHealthPool()+5*level);
        attackPoint=attackPoint+2*level;
        defencePoint=defencePoint+level;
        String output = getName() + " reached level " + level +  ": +" + (level * 15) + " Health, +"+ (level * 6) + " Attack, +"+ (level * 2) + " Defense ";
        ScreenWriter.getScreenWriter().print(output);
    }

    public String toString(){
        return super.toString()+"\t\t"+specialAbility.toString();
    }
    @Override
    public List<Enemy> filter(List<Enemy> list) {
        List<Enemy> lst=new LinkedList<>();
        for(Enemy e:list){
            if(this.location.range(e.getLocation())<specialAbility.range)
                lst.add(e);
        }
        return lst;
    }

    //==================INTERFACES===============
    @Override
    public void onTickAct(Board board) {
        if (specialAbility.remainingCooldown > 0 & !castedOnCurrentTick) specialAbility.remainingCooldown--;
        castedOnCurrentTick = false;
    }
    @Override
    public void castSpacialAbility() {
        String output="";
        if(specialAbility.remainingCooldown>0){//print error message
            output=getName()+" tried to cast "+specialAbility.name+", but there is a cooldown: "+specialAbility.remainingCooldown+".\n";
            ScreenWriter.getScreenWriter().print(output);
        }
        else{
            castedOnCurrentTick = true;
            //List<Enemy> inRangeEnemies=sort(Board.getBoard().enemiesInRangeWarrior(this,specialAbility.range));
            List<Enemy> inRangeEnemies= filter(Board.getBoard().enemiesInRange(this,specialAbility.range));
            if(inRangeEnemies.size()>0) {
                Enemy attackedEnemy = inRangeEnemies.get((int) Math.random() * inRangeEnemies.size());
                health.healthIncrease(10 * defencePoint);
                output = getName() + " used " + specialAbility.name + ", healing for " + 10 * defencePoint + ".\n";
                ScreenWriter.getScreenWriter().print(output);
                attackedEnemy.attackMe((int) (health.getHealthPool() * 0.1), this);
                specialAbility.remainingCooldown = specialAbility.coolDown;
            }
            else{
                output=getName()+" tried to cast "+specialAbility.name+", but there was no munster in range.\n";
                ScreenWriter.getScreenWriter().print(output);
            }
        }
    }

    //================NESTED_CLASSES===============
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



