package Test;

import Board.Point;
import Enemys.Monster;

public class TestMonster extends Monster {

    public TestMonster(Point point, char character, String name, int attack, int defence, int health, int vision, int expValue){
        super(point, character, name, attack, defence,  health, vision, expValue);
    }

    public void died(){

    }
}
