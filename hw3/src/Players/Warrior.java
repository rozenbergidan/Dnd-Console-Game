package Players;

import Board.*;
import Emenys.Monster;
import VisitorPattern.Visited;

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
    public void onTickAct(Board board) {
        if (specialAbility.coolDown > 0) specialAbility.coolDown--;
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

    private class SpecialAbility {
        private final String NAME = "Avenger’s Shield";
        private final String DESCRIPTION = "randomly hits one enemy withing range < 3 for an amount\n" +
                "equals to 10% of the warrior’s max health and heals the warrior for amount equals to (10\u0002defense)\n" +
                "(but will not exceed the total amount of health pool).";
        private final int MAX_RANGE = 3;

        private String name;
        private String description;
        private int coolDown;
        private int remainingCooldown;
        private boolean available;
        private int range;

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

        public int getRange() {
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



