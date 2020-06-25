package Tiles;

import Board.*;
import Control.ScreenWriter;
import Interfaces.VisitorPattern.*;

public abstract class Unit  extends Tile implements Visited {
    // FILDES
    private String name;
    protected Health health; //changed to public for warrior specialAbility
    protected int attackPoint;
    protected int defencePoint;

    public Unit(Point point,char character, String name, int attack, int defence, int health) {
        this.location = point;
        this.character = character;
        this.name = name;
        this.attackPoint = attack;
        this.defencePoint = defence;
        this.health = new Health(health);
    }

    public boolean attackMe(int attackDamage,Unit unit){// return true if the attacker should move to the defender location
        String output;
        int defence = (int)(Math.random()*(defencePoint + 1));
        output=getName()+" rolled "+defence+" defense points.\n";
        int dmgDealt=Math.max(0,attackDamage- defence);
        output=output+unit.getName()+" dealt "+dmgDealt+" damage to "+getName()+"\n";
        ScreenWriter.getScreenWriter().print(output);
        boolean isDead = health.healthDecrease(dmgDealt); //return true if this died
        if(isDead) {
            died();
        }
        return isDead;
    }

    public abstract void died();

    public boolean attack(Unit unit){
        String output=getName()+" engaged in combat with "+unit.name+".\n";
        output=output+toString()+"\n";
        output=output+unit.toString()+"\n";
        int attack=(int)(Math.random()*(attackPoint + 1));
        output=output+getName()+" rolled "+ attack+" attack points.\n";
        ScreenWriter.getScreenWriter().print(output);
        return unit.attackMe(attack,this);

    }

    public String getName() {
        return name;
    }

    protected class  Health{// nested class
        private int healthPool;
        private int healthAmount;

        public Health(int initHealthPool){
            this.healthPool = initHealthPool;
            this.healthAmount = healthPool;
        }

        public void levelUP(int level){
            healthPool = healthPool + 10*level;
            healthAmount = healthPool;
        }

        //return true if the Unit died
        public boolean healthDecrease(int x){
            if(x > 0) {
                healthAmount = healthAmount - x;
                if (healthAmount <= 0) return true;
            }
            return false;
        }

        public void healthIncrease(int x){
            healthAmount=healthAmount+x;
            if(healthAmount>healthPool)
                healthAmount=healthPool;
        }
        public int getHealthPool(){return healthPool;}
        public void setHealthPool(int newHealthPool){this.healthPool=newHealthPool;}
        @Override
        public String toString(){
            String output="";
            output="Health: "+healthAmount+"/"+healthPool;
            return output;
        }
    }
}
