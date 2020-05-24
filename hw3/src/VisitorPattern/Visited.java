package VisitorPattern;

import Emenys.Monster;
import Players.Player;

public interface Visited {

    boolean accept (Player p);
    boolean accept (Monster m);

}
