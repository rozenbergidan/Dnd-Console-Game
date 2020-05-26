package Tiles;

import Board.*;
import ObserverPattern.*;
import VisitorPattern.*;

public abstract class Unit  extends Tile implements Visited {
    // FILDES
    private String name;
    public Health health; //changed to public for warrior specialAbility
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



    public boolean attackMe(int attackDamage,Unit unit){// return true is died TODO: add die scenario, and send player/ player detiels
        String output;
        int defence = (int)(Math.random()*(defencePoint + 1));
        output=getName()+" rolled "+defence+" defense points.\n";
        int dmgDealt=attackDamage- defence;
        output=output+unit.getName()+" dealt "+dmgDealt+"damage to "+getName()+"\n";
        //TODO print to Screen
        boolean isDead = health.healthDecrease(attackDamage- defence); //return true if this died
        if(isDead) died();
        return isDead;
    }

    public abstract void died();

    public boolean attack(Unit unit){
        String output=getName()+" engaged in combat with +"+unit.name+".\n";
        output=output+toString()+"\n";
        output=output+unit.toString()+"\n";
        int attack=(int)(Math.random()*(attackPoint + 1));
        output=output+getName()+" rolled "+ attack+" attack points.\n";
        //TODO print to screen
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
