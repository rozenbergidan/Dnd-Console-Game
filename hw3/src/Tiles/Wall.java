package Tiles;

import Board.Point;
import Enemys.Monster;
import Players.Player;

public class Wall extends Tile {
    public final char ON_MAP='#';

    public Wall(Point point){
        character=ON_MAP;
        this.location=point;
    }

    @Override
    public String toString() {
        return ""+character;
    }

    @Override
    public boolean accept(Player p) {
        return false;
    }

    @Override
    public boolean accept(Monster m) {
        return false;
    }
}
