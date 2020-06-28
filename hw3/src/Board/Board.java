package Board;

import Control.ScreenWriter;
import Enemys.*;
import Interfaces.ObserverPattern.*;
import Players.*;
import Tiles.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Board implements Observable {
    //====================FIELDS==================
    private static Board instance = null;
    private Tile[][] tiles;
    private String[] levels;
    private int level;
    private Player player;
    private List<Enemy> enemiesList;
    private List<Observer> tickObserver;
    private boolean gameOver;

    //=================CONSTRUCTOR=================
    private Board() { // for singleton use
        enemiesList = new LinkedList<>();
        tickObserver = new LinkedList<>();
        level = -1;
        gameOver = false;
    }
    //================PUBLIC_METHODS===============
    public static Board getBoard() {
        if (instance == null) instance = new Board();
        return instance;
    }

    public void initBoard(String[] levels) { //will be called once in game controller
        this.levels=levels;
        selectCharacter();
        buildBoard();
    }

    public int getLevel() {
        return level;
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

    public boolean gameTick(char playerAct) { // return true if game over
        player.act(playerAct);
        for (Enemy enemy : enemiesList) {
            if (!gameOver) enemy.act();
        }
        callObservers();
        return gameOver; // return true if game over
    }

    public void unitDied(Enemy enemy) {
        String output = enemy.getName() + " died. " + player.getName() + " gained " + enemy.getExpValue() + " experience";
        ScreenWriter.getScreenWriter().print(output);

        enemiesList.remove(enemy);
        Point enemyLoction = enemy.getLocation();
        tiles[enemyLoction.getX()][enemyLoction.getY()] = new Empty(enemyLoction);
        player.killedEnemy(enemy.getExpValue());
        if (enemiesList.isEmpty()) buildBoard();

    }

    public void playerDied() {
        gameOver = true;
        ScreenWriter.getScreenWriter().print("You lost.");
    }

    public List<Enemy> enemiesInRange(Player player, double range) {
        List<Enemy> ls = new LinkedList<>();
        for (Enemy e : enemiesList) {
            if ((int) player.getLocation().range(e.getLocation()) <= range) {
                ls.add(e);
            }
        }
        return ls;
    }

    public String toString() {
        String map = "";
        for (int i = 0; i < tiles.length; i++) {
            int j = 0;
            for (; j < tiles[0].length; j++) {
                map = map + "" + tiles[i][j].getCharacter();
            }
            map = map + "" + '\n';
        }
        return map;
    }
    //================PRIVATE_METHODS==============
    private int[] getBoardSize() {
        if(levels == null) throw new IllegalArgumentException("board did not initializes");
        int[] arr = new int[2];
        arr[0] = levels[level].split("\n").length; //rows
        arr[1] = levels[level].indexOf('\n'); // columns
        return arr;
    }

    private void selectCharacter() {
        String output = "Select player:\n1. Jon Snow             Health: 300/300         Attack: 30              Defense: 4              Level: 1                Experience: 0/50                Cooldown: 0/3\n" +
                "2. The Hound            Health: 400/400         Attack: 20              Defense: 6              Level: 1                Experience: 0/50                Cooldown: 0/5\n" +
                "3. Melisandre           Health: 100/100         Attack: 5               Defense: 1              Level: 1                Experience: 0/50                Mana: 75/300            Spell Power: 15\n" +
                "4. Thoros of Myr                Health: 250/250         Attack: 25              Defense: 4              Level: 1                Experience: 0/50                Mana: 37/150            Spell Power: 20\n" +
                "5. Arya Stark           Health: 150/150         Attack: 40              Defense: 2              Level: 1                Experience: 0/50                Energy: 100/100\n" +
                "6. Bronn                Health: 250/250         Attack: 35              Defense: 3              Level: 1                Experience: 0/50                Energy: 100/100\n" +
                "7. Ygritte              Health: 220/220         Attack: 30              Defense: 2              Level: 1                Experience: 0/50                Arrows: 10              Range: 6 \n";
        ScreenWriter.getScreenWriter().print(output);
        Scanner scan = new Scanner(System.in);
        int index = scan.nextInt();
        while (index < 1 || index > 8) {
            output = "input is not valid";
            ScreenWriter.getScreenWriter().print(output);
            index = scan.nextInt();
        }
        selectCharacter(index);
    }

    private void selectCharacter(int index) {
        if (player == null) {
            String output = "";
            if (index == 1) {
                this.player = new Warrior("Jon Snow", 30, 4, 3, 300, new Point(0, 0));
            } else if (index == 2) {
                this.player = new Warrior("The Hound", 20, 6, 5, 400, new Point(0, 0));
            } else if (index == 3) {
                this.player = new Mage("Melisandre", 5, 1, 100, 300, 30, 15, 5, 6, new Point(0, 0));
            } else if (index == 4) {
                this.player = new Mage("Thoros of Myr", 25, 4, 250, 150, 20, 20, 3, 4, new Point(0, 0));
            } else if (index == 5) {
                this.player = new Rogue("Arya Stark", 40, 2, 150, 20, new Point(0, 0));
            } else if (index == 6) {
                this.player = new Rogue("Bronn", 35, 3, 250, 50, new Point(0, 0));
            } else if (index == 7) {
                this.player = new Hunter("Ygritte", 30, 2, 220, 6, new Point(0, 0));
            }
            addObserver(player);
            output = output + "You have selected: " + player.getName() + ".\n";
            ScreenWriter.getScreenWriter().print(output);
        }
    }

    private boolean buildBoard() {

        enemiesList = new LinkedList<>();
        tickObserver = new LinkedList<>();
        level++;
        if (level < levels.length){
            tiles = new Tile[getBoardSize()[0]][getBoardSize()[1]];
            int i = 0;
            int j = 0;
            char tile;
            Enemy tl;
            Trap tp;
            String board = levels[level];
            while (!board.equals("")) {
                tile = board.charAt(0);
                if (tile == '\n') {
                    i++;
                    j = -1;
                } else if (tile == '@') {
                    player.setLocation(i, j);
                    tiles[i][j] = player;
                    addObserver(player);
                } else if (tile == '.') {
                    tiles[i][j] = new Empty(new Point(i, j));
                } else if (tile == '#') {
                    tiles[i][j] = new Wall(new Point(i, j));
                } else if (tile == 's') {
                    tl = new Monster(new Point(i, j), 's', "Lannister Solider", 8, 3, 80, 3, 25);
                    tiles[i][j] = tl;
                    enemiesList.add(tl);
                } else if (tile == 'k') {
                    tl = new Monster(new Point(i, j), 'k', "Lannister Knight", 14, 8, 200, 4, 50);
                    tiles[i][j] = tl;
                    enemiesList.add(tl);
                } else if (tile == 'q') {
                    tl = new Monster(new Point(i, j), 'q', "Queen\'s Guard", 20, 15, 400, 5, 100);
                    tiles[i][j] = tl;
                    enemiesList.add(tl);
                } else if (tile == 'z') {
                    tl = new Monster(new Point(i, j), 'z', "Wright", 30, 15, 600, 3, 100);
                    tiles[i][j] = tl;
                    enemiesList.add(tl);
                } else if (tile == 'b') {
                    tl = new Monster(new Point(i, j), 'b', "Bear-Wright", 75, 30, 1000, 4, 250);
                    tiles[i][j] = tl;
                    enemiesList.add(tl);
                } else if (tile == 'g') {
                    tl = new Monster(new Point(i, j), 'g', "Giant-Wright", 100, 40, 1500, 5, 500);
                    tiles[i][j] = tl;
                    enemiesList.add(tl);
                } else if (tile == 'w') {
                    tl = new Monster(new Point(i, j), 'w', "White Walker", 150, 50, 2000, 6, 1000);
                    tiles[i][j] = tl;
                    enemiesList.add(tl);
                } else if (tile == 'M') {
                    tl = new Boss(new Point(i, j), 'M', "The Mountain", 60, 25, 1000, 6, 500, "Skull Cracking", "Crack the skull of your infirior", 10);
                    tiles[i][j] = tl;
                    enemiesList.add(tl);
                } else if (tile == 'C') {
                    tl = new Boss(new Point(i, j), 'C', "Queen Cersei", 10, 10, 100, 1, 1000, "WildFire", "Drop down on your enemy rain of wildfire, burning them alive", 25);
                    tiles[i][j] = tl;
                    enemiesList.add(tl);
                } else if (tile == 'K') {
                    tl = new Boss(new Point(i, j), 'K', "Night\'s King", 300, 150, 5000, 8, 5000, "Ice Arrow", "Shoot on your enemy an ice arrow", 2);
                    tiles[i][j] = tl;
                    enemiesList.add(tl);
                } else if (tile == 'B') {
                    tp = new Trap(new Point(i, j), 'B', "Bonus Trap", 1, 1, 1, 1, 5, 250);
                    tiles[i][j] = tp;
                    enemiesList.add(tp);
                    addObserver(tp);
                } else if (tile == 'Q') {
                    tp = new Trap(new Point(i, j), 'Q', "Queen\'s Trap", 20, 10, 250, 3, 7, 100);
                    tiles[i][j] = tp;
                    enemiesList.add(tp);
                    addObserver(tp);
                } else if (tile == 'D') {
                    tp = new Trap(new Point(i, j), 'D', "Death Trap", 100, 20, 500, 1, 10, 250);
                    tiles[i][j] = tp;
                    enemiesList.add(tp);
                    addObserver(tp);
                } else {
                    ScreenWriter.getScreenWriter().print("Invalid character");
                    ScreenWriter.getScreenWriter().print(tile + "");
                }
                j++;
                board = board.substring(1);
            }
        }
        else {
            gameOver = true;
            ScreenWriter.getScreenWriter().print("You won!");
        }
        return gameOver;// return true if game over
    } //will be called for each level in game controller
    //==================INTERFACES===============
    @Override
    public void addObserver(Observer O) {
        tickObserver.add(O);
    }

    @Override
    public void callObservers() {
        for (Observer o : tickObserver) {
            o.onTickAct(this);
        }
    }







}
