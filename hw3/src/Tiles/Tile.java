package Tiles;


import Board.*;
import Interfaces.VisitorPattern.*;

public abstract class Tile implements Visited {
    //====================FIELDS==================
    protected Point location;
    protected char character;
    //================PUBLIC_METHODS===============
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
