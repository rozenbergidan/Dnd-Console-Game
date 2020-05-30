package Players;

import Board.*;
import Emenys.Enemy;
import Emenys.Monster;
import VisitorPattern.Visited;

import java.util.List;

public class Mage extends Player{
    private Mana mana;
    private SpecialAbility specialAbility;

    public Mage(String name, int attack, int defence, int health,int mana, int manaCost,int spellPower, int hitsCount, int range, Point point) {
        super(name, attack, defence, health, point);
        this.mana = new Mana(mana);
        specialAbility=new SpecialAbility(manaCost,spellPower,hitsCount,range);
    }

    public void levelUP(){
        super.levelUP();
        mana.currentMana=Math.min(mana.currentMana+mana.manaPool/4,mana.manaPool);
        mana.manaPool=mana.manaPool+25*level;
        specialAbility.spellPower=specialAbility.spellPower+10*level;
        String output = getName() + " reached level " + level +  ": +" + (level * 15) + " Health, +"+ (level * 6) + " Attack, + " + (level * 2) + " Defense +" + (level * 25) + " maximum mana, +" + (level * 10) + " spell power";

    }

    @Override
    public void castSpacialAbillity() {
        if(mana.currentMana<specialAbility.manaCost){ //print error message
            String output=getName()+" tried to cast "+specialAbility.name+", but there was not enough "+mana.toString()+".\n";//Melisandre tried to cast Blizzard, but there was not enough mana: 9/30.
        }
        else{
            mana.currentMana=mana.currentMana-specialAbility.manaCost;
            int hits=specialAbility.hitsCount;
            List<Enemy> inRangeEnemies=Board.getBoard().enemiesInRangeMage(this,specialAbility.range);
            String output=getName()+" cast "+specialAbility.name+".\n";
            for(Enemy e: inRangeEnemies){
                if(hits==0){ // do nothing

                }
                else{
                    hits--;
                    e.attackMe(specialAbility.spellPower,this);
                }
            }
        }
    }

    @Override
    public void onTickAct(Board board) {
        mana.currentMana=(Math.min(mana.manaPool,mana.currentMana+level));
    }


    public String toString(){
        return super.toString()+"\t\t"+mana.toString()+"\t\t"+"SpellPower: "+specialAbility.spellPower;
    }
    private class Mana{// nested class
        private int manaPool;
        private int currentMana;

        public Mana(int manaPool){
            this.manaPool=manaPool;
            this.currentMana=manaPool/4;
        }

        public String toString(){
            String output="";
            output="Mana: "+currentMana+"/"+manaPool;
            return output;
        }
    }

    private class SpecialAbility{ //nested class
        private final String NAME="Blizzard";
        private final String DESCRIPTION="randomly hit enemies within range for an amount equals to the mage’s\n" +
                "spell power at the cost of mana.";

        private String name;
        private String desc;
        private double range;
        private int manaCost;
        private int spellPower;
        private int hitsCount;

        public SpecialAbility(int manaCost, int spellPower, int hitsCount,int range){
            this.name=NAME;
            this.desc=DESCRIPTION;
            this.manaCost=manaCost;
            this.spellPower=spellPower;
            this.hitsCount=hitsCount;
            this.range=range;
        }
    }

}
