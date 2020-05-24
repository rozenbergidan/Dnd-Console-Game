package VisitorPattern;

import Emenys.Monster;
import Players.Player;

public interface Visited {

    void accept (Player p);
    void accept (Monster m);

}
