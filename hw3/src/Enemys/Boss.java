package Enemys;

import Board.Board;
import Board.Point;
import Control.ScreenWriter;
import Interfaces.HeroicUnit;
import Players.Player;

public class Boss extends Monster implements HeroicUnit {
    private SpecialAbility specialAbility;

    public Boss(Point point, char character, String name, int attack, int defence, int health, int vision, int expValue, String abilityName, String abilityDesc, int abilityFreq) {
        super(point, character, name, attack, defence, health, vision, expValue);
        specialAbility = new SpecialAbility(abilityName, abilityDesc, vision, abilityFreq);
    }

    @Override
    public void act() {
        Player player = Board.getBoard().getPlayer();
        if (this.location.range(player.getLocation()) <= vision) {
            if (specialAbility.combatIicks == specialAbility.abilityFrequency) {//combat ticks == ability frequency then
                specialAbility.combatIicks = 0;
                castSpacialAbility();
            } else {
                specialAbility.combatIicks++;
                super.act();
            }
        }
    }

    @Override
    public void castSpacialAbility() {
        String output=getName()+" used "+ specialAbility.name;
        ScreenWriter.getScreenWriter().print(output);
        this.attack(Board.getBoard().getPlayer());
    }

    private class SpecialAbility {
//        private final String NAME="Dracarys";
//        private final String DESCRIPTION="Throwing fire missiles at the enemy position";

        private final int START_COMBAT_TICK=0;
        private String name;
        private String desc;
        private double range;
        private int abilityFrequency;
        private int combatIicks;



        public SpecialAbility(String name, String desc, double range, int abilityFrequency) {
            this.name = name;
            this.desc = desc;
            this.range = range;
            this.abilityFrequency = abilityFrequency;
            this.combatIicks = START_COMBAT_TICK;
        }

    }
}
