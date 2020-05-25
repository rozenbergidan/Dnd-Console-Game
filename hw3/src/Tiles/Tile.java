package Tiles;


import Board.*;
import VisitorPattern.*;

public abstract class Tile implements Visited {
    protected Point location;
    protected char character;

    public Point getLocation() {
        return location;
    }

    protected void switchLocation(Tile t){
        location.substitute(t.location);
    }

    public char getCharacter(){
        return character;
    }
}
