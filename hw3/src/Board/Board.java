package Board;

import Emenys.*;
import ObserverPattern.*;
import Players.*;
import Tiles.*;

import java.util.List;

public class Board implements Observable {

    private static Board instance = null;
    private Tile[][] tiles;
    String[] levels;
    //private int gameTickCount;

    Player player;
    List<Enemy> enemiesList;
    List<Observer> tickObserver;


    private Board(String board, String character) {
        int i = 0;
        int j = 0;
        char tile;
        Player player = null;
        Enemy tl;

        while (!board.equals("")) {
            tile = board.charAt(0);
            if (tile == '\n') {
                i++;
                j = -1;
            } else if (tile == '@') {
                if (character.equals("Jon Snow")) {
                    this.player = new Warrior("Jon Snow", 30, 4, 3, 300, new Point(i, j));
                } else if (character.equals("The Hound")) {
                    this.player = new Warrior("The Hound", 20, 6, 5, 400, new Point(i, j));
                } else if (character.equals("Melisandre")) {
                    this.player = new Mage("Melisandre", 5, 1, 100, 300, 30, 15, 5, 6, new Point(i, j));
                } else if (character.equals("Thoros of Myr")) {
                    this.player = new Mage("Thoros of Myr", 25, 4, 250, 150, 20, 20, 3, 4, new Point(i, j));
                } else if (character.equals("Arya Stark")) {
                    this.player = new Rogue("Arya Stark", 40, 2, 150, 20, new Point(i, j));
                } else if (character.equals("Bronn")) {
                    this.player = new Rogue("Bronn", 35, 3, 250, 50, new Point(i, j));
                } else {
                    System.out.println("NOT SUPPOSED TO HAPPEN");
                }
                tiles[i][j] = this.player;
            } else if (tile == '.') {
                tiles[i][j] = new Empty(new Point(i, j));
            } else if (tile == '#') {
                tiles[i][j] = new Wall(new Point(i, j));
            } else if (tile == 's') {
                tl = new Monster(new Point(i, j), 's', "Lannister Solider", 8, 3, 80, 3, 25);
                tiles[i][j] = tl;
                enemiesList.add(tl);
            } else if (tile == 'l') {
                tl = new Monster(new Point(i, j), 'l', "Lannister Knight", 14, 8, 200, 4, 50);//monster --Lannister Knight;
                tiles[i][j] = tl;
                enemiesList.add(tl);
            } else if (tile == 'q') {
                tl = new Monster(new Point(i, j), 'q', "Queen’s Guard", 20, 15, 400, 5, 100);//monster --Queen’s Guard;
                tiles[i][j] = tl;
                enemiesList.add(tl);
            } else if (tile == 'z') {
                tl = new Monster(new Point(i, j), 'z', "Wright", 30, 15, 600, 3, 100);//monster --Wright;
                tiles[i][j] = tl;
                enemiesList.add(tl);
            } else if (tile == 'b') {
                tl = new Monster(new Point(i, j), 'b', "Bear-Wright", 75, 30, 1000, 4, 250);//monster --Bear-Wright;
                tiles[i][j] = tl;
                enemiesList.add(tl);
            } else if (tile == 'g') {
                tl = new Monster(new Point(i, j), 'g', "Giant-Wright", 100, 40, 1500, 5, 500);//monster --Giant-Wright;
                tiles[i][j] = tl;
                enemiesList.add(tl);
            } else if (tile == 'w') {
                tl = new Monster(new Point(i, j), 'w', "White Walker", 150, 50, 2000, 6, 1000);//monster --White Walker;
                tiles[i][j] = tl;
                enemiesList.add(tl);
            } else if (tile == 'M') {
                tl = new Monster(new Point(i, j), 'M', "The Mountain", 60, 25, 1000, 6, 500);//monster --The Mountain;
                tiles[i][j] = tl;
                enemiesList.add(tl);
            } else if (tile == 'C') {
                tl = new Monster(new Point(i, j), 'C', "Queen Cersei", 10, 10, 100, 1, 1000);//monster --Queen Cersei;
                tiles[i][j] = tl;
                enemiesList.add(tl);
            } else if (tile == 'K') {
                tl = new Monster(new Point(i, j), 'K', "Night’s King", 300, 150, 5000, 8, 5000);//monster --Night’s King;
                tiles[i][j] = tl;
                enemiesList.add(tl);
            } else if (tile == 'B') {
                tl = new Trap(new Point(i, j), 'B', "Bonus Trap", 1, 1, 1, 1, 5, 250);//Trap --Bonus Trap;
                tiles[i][j] = tl;
                enemiesList.add(tl);
            } else if (tile == 'Q') {
                tl = new Trap(new Point(i, j), 'Q', "Queen’s Trap", 20, 10, 250, 3, 7, 100);//Trap --Queen’s Trap;
                tiles[i][j] = tl;
                enemiesList.add(tl);
            } else if (tile == 'D') {
                tl = new Trap(new Point(i, j), 'D', "Death Trap", 100, 20, 500, 1, 10, 250);//Trap -- Death Trap;
                tiles[i][j] = tl;
                enemiesList.add(tl);
            } else {
                System.out.println("NOT SUPPOSED TO HAPPEN");
            }
            j++;
            board = board.substring(1);
        }
    }

    public static Board getBoard() {
        return instance;
    }

    public static void initBoard(String[] levels, String player,int level) {
        if (instance == null) instance = new Board(levels[level], player);
    }

    public Player getPlayer() {
        return player;
    }

    public Tile getTile(Point p) {
        return tiles[p.getX()][p.getY()];
    }

    public void switchTile(Point p1, Point p2) {
        Tile temp = tiles[p1.getX()][p1.getY()];
        tiles[p1.getX()][p1.getY()] = tiles[p2.getX()][p2.getY()];
        tiles[p2.getX()][p2.getY()] = temp;
    }

    public boolean gameTick() {
        return false;
    }

    @Override
    public void addObserver(Observer O) {

    }

    @Override
    public void callObservers() {

    }
}
