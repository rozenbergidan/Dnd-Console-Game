package Players;

import Board.*;
import Emenys.Monster;
import VisitorPattern.Visited;

public class Warrior extends Player{

    private SpecialAbility specialAbility;

    public Warrior(String name, int attack, int defence, int cooldown,int health,Point point){
        super(name, attack, defence, health,point);
        specialAbility=new SpecialAbility(cooldown);
    }

    @Override
    public void onTickAct(Board board) {

    }

    @Override
    public void act(Board b) {

    }

    @Override
    public boolean accept(Player p) {
        return false;
    }

    @Override
    public boolean accept(Monster m) {
        return false;
    }

    @Override
    public boolean visit(Visited V) {
        return false;
    }

    private class SpecialAbility{
        private final String NAME = "Avenger’s Shield";
        private final String DESCRIPTION ="randomly hits one enemy withing range < 3 for an amount\n" +
                "equals to 10% of the warrior’s max health and heals the warrior for amount equals to (10\u0002defense)\n" +
                "(but will not exceed the total amount of health pool).";
        private final int MAX_RANGE = 3;

        private String name;
        private String description;
        private CoolDown coolDown;
        private int range;

        public SpecialAbility(int cd){
            this.name = NAME;
            this.description=DESCRIPTION;
            coolDown=new CoolDown(cd);
            range = MAX_RANGE;
        }

        private class CoolDown{
            private int coolDown;
            private int remainingCooldown;
            private boolean available;

            public CoolDown(int coolDown){
                this.coolDown=coolDown;
                remainingCooldown=0;
                available=true;
            }
        }
    }


}
