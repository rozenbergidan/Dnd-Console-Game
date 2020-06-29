package Test;

import Board.*;
import Enemys.Enemy;
import Players.Player;

import java.util.List;

public class TestPlayer extends Player {
    public TestPlayer(String name, int attack, int defence, int health, Point point) {
        super(name, attack, defence, health, point);
    }

    @Override
    public void castSpecialAbility() {

    }

    @Override
    public List<Enemy> filter(List<Enemy> list) {
        return null;
    }

    @Override
    public void onTickAct(Board board) {

    }

    @Override
    public void died() {

    }
}
