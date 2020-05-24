package Board;

import ObserverPattern.*;
import Tiles.*;
import java.util.List;

public class Board implements Observable {
    private Tile[][] tiles;
    //private int gameTickCount;
    //List<ActiveCharacter> ActiveList;
    List<Observer> TickObserver;


    @Override
    public void addObserver(Observer O) {

    }

    @Override
    public void callObservers() {

    }
}
