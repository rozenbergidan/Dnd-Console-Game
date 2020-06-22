package Tiles;

import Board.Point;
import Enemys.Monster;
import Players.Player;

public class Empty extends Tile {
    public final char ON_MAP='.';

    public Empty(Point point){
        character=ON_MAP;
        this.location=point;
    }
    @Override
    public String toString() {
        return ""+character;
    }

    @Override
    public boolean accept(Player p) {
        return true;
    }

    @Override
    public boolean accept(Monster m) {
        return true;
    }
}
