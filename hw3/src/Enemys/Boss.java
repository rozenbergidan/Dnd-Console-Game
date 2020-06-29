package Enemys;

import Board.Board;
import Board.Point;
import Control.ScreenWriter;
import Interfaces.HeroicUnit;
import Players.Player;

public class Boss extends Monster implements HeroicUnit {
    //====================FIELDS==================
    private SpecialAbility specialAbility;

    //=================CONSTRUCTOR=================
    public Boss(Point point, char character, String name, int attack, int defence, int health,
                int vision, int expValue, String abilityName, String abilityDesc, int abilityFreq) {
        super(point, character, name, attack, defence, health, vision, expValue);
        specialAbility = new SpecialAbility(abilityName, abilityDesc, vision, abilityFreq);
    }
    //================PUBLIC_METHODS===============
    @Override
    public void act() {
        Player player = Board.getBoard().getPlayer();
        if (this.location.range(player.getLocation()) <= vision) {
            if (specialAbility.combatIicks == specialAbility.abilityFrequency) {//combat ticks == ability frequency then
                specialAbility.combatIicks = 0;
                castSpecialAbility();
            } else {
                specialAbility.combatIicks++;
                super.act();
            }
        }
    }

    //==================INTERFACES===============
    @Override
    public void castSpecialAbility() {
        String output=getName()+" used "+ specialAbility.name;
        ScreenWriter.getScreenWriter().print(output);
        this.attack(Board.getBoard().getPlayer());
    }

    //================NESTED_CLASSES===============
    private class SpecialAbility {
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
