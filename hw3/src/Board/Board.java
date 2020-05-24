package Board;

import Emenys.Enemy;
import ObserverPattern.*;
import Players.Player;
import Tiles.*;
import java.util.List;

public class Board implements Observable {

    private static Board instance = null;
    private Tile[][] tiles;
    String[] levels;
    //private int gameTickCount;

    Player player;
    List<Enemy> EnemeiesList;
    List<Observer> TickObserver;

    private Board(String[] levels, String player){// private singelton constractor

    }

    public static Board getBoard(){
        return instance;
    }
    public static void initBoard(String[] levels, String player){
        if(instance == null) instance = new Board(levels, player);
    }


    public Player getPlayer() {
        return player;
    }

    public Tile getTile(Point p){
        return tiles[p.getX()][p.getY()];
    }

    public void switchTile(Point p1, Point p2){
        Tile temp = tiles[p1.getX()][p1.getY()];
        tiles[p1.getX()][p1.getY()] = tiles[p2.getX()][p2.getY()];
        tiles[p2.getX()][p2.getY()] = temp;
    }

    public boolean gameTick(){
        return false;
    }

    @Override
    public void addObserver(Observer O) {

    }

    @Override
    public void callObservers() {

    }
}
