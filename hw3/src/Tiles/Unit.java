package Tiles;

import Board.*;
import ObserverPattern.*;
import VisitorPattern.*;

public abstract class Unit  extends Tile implements Visitor {
    // FILDES
    private String name;
    protected Health health;
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




    public boolean attackMe(int attackDamage){// return true is died
        int defence = (int)(Math.random()*(defencePoint + 1));
        return health.healthDecrease(attackDamage- defence);
    }

    public boolean attack(Unit unit){
        return unit.attackMe((int)(Math.random()*(attackPoint + 1)));
    }


    protected class  Health{// nested class
        private int healthPool;
        private int healthAmount;

        public Health(int initHealthPool){
            this.healthPool = initHealthPool;
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
        public int getHealthPool(){return healthPool;}
        public void setHealthPool(int newHealthPool){this.healthPool=newHealthPool;}
    }
}
