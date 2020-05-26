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


    public boolean attackMe(int attackDamage){// TODO: add die scenario, and send player/ player detiels
        int defence = (int)(Math.random()*(defencePoint + 1));
        return health.healthDecrease(attackDamage- defence); //return true if this died
    }

    public boolean attack(Unit unit){
        return unit.attackMe((int)(Math.random()*(attackPoint + 1))); // return true if unit died
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
    }
}
