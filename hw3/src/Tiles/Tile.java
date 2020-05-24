package Tiles;


import Board.*;
import VisitorPattern.*;

public abstract class Tile implements Visited {
    protected Point location;
    char character;

    public Point getLocation() {
        return location;
    }
}
