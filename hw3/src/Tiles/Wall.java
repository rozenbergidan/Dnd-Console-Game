package Tiles;

import Board.Point;
import Emenys.Monster;
import Players.Player;
import Tiles.Tile;

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
    public void accept(Player p) {
        //DO NOTHING
    }

    @Override
    public void accept(Monster m) {
        //DO NOTHING
    }
}
