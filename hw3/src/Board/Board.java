package Board;

import Emenys.Enemy;
import ObserverPattern.*;
import Players.Player;
import Tiles.*;
import java.util.List;

public class Board implements Observable {
    private Tile[][] tiles;
    //private int gameTickCount;
    List<Player> PlayersList;
    List<Enemy> EnemeiesList;
    List<Observer> TickObserver;

    @Override
    public void addObserver(Observer O) {

    }

    @Override
    public void callObservers() {

    }
}
