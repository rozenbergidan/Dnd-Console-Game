package Board;

import Emenys.*;
import ObserverPattern.*;
import Players.*;
import Tiles.*;
import java.util.LinkedList;
import java.util.List;

public class Board implements Observable {

    private static Board instance = null;
    private Tile[][] tiles;////////////////////////////we have to change back to private
    String[] levels;
    int level;
    Player player;
    List<Enemy> enemiesList;
    List<Observer> tickObserver;
    boolean gameOver;

    private Board() { // for singleton use
        enemiesList = new LinkedList<>();
        tickObserver = new LinkedList<>();
        level = -1;
    }

    public void initBoard(String[] levels) { //will be called once in game controller
        this.levels = levels;
    }

    public int[] getBoardSize(){
        int[]arr=new int[2];
        arr[0]=levels[level].split("\n").length;
        arr[1]=levels[level].indexOf('\n');
        return arr;
    }

    public void selectCharacter(int index) {
        if (player == null) {
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
            } else {
                System.out.println("NOT SUPPOSED TO HAPPEN");
            }
            addObserver(player);
            System.out.println("You have selected: " + player.getName());
        }
    } //will be called once in game controller

    public boolean buildBoard() { // TODO: return true if game over
        enemiesList = new LinkedList<>();
        tickObserver=new LinkedList<>();
        level++;
        tiles=new Tile[getBoardSize()[0]][getBoardSize()[1]];
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
                tiles[i][j]=tl;
                enemiesList.add(tl);
            } else if (tile == 'q') {
                tl = new Monster(new Point(i, j), 'q', "Queen’s Guard", 20, 15, 400, 5, 100);
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
                tl = new Monster(new Point(i, j), 'M', "The Mountain", 60, 25, 1000, 6, 500);
                tiles[i][j] = tl;
                enemiesList.add(tl);
            } else if (tile == 'C') {
                tl = new Monster(new Point(i, j), 'C', "Queen Cersei", 10, 10, 100, 1, 1000);
                tiles[i][j] = tl;
                enemiesList.add(tl);
            } else if (tile == 'K') {
                tl = new Monster(new Point(i, j), 'K', "Night’s King", 300, 150, 5000, 8, 5000);
                tiles[i][j] = tl;
                enemiesList.add(tl);
            } else if (tile == 'B') {
                tp = new Trap(new Point(i, j), 'B', "Bonus Trap", 1, 1, 1, 1, 5, 250);
                tiles[i][j] = tp;
                enemiesList.add(tp);
                addObserver(tp);
            } else if (tile == 'Q') {
                tp = new Trap(new Point(i, j), 'Q', "Queen’s Trap", 20, 10, 250, 3, 7, 100);
                tiles[i][j] = tp;
                enemiesList.add(tp);
                addObserver((Trap)tp);
            } else if (tile == 'D') {
                tp = new Trap(new Point(i, j), 'D', "Death Trap", 100, 20, 500, 1, 10, 250);
                tiles[i][j] = tp;
                enemiesList.add(tp);
                addObserver((Trap)tp);
            } else {
                System.out.println("NOT SUPPOSED TO HAPPEN");
                System.out.println(tile);
            }
            j++;
            board = board.substring(1);
        }
        return false;// return true if game over
    } //will be called for each level in game controller

    public static Board getBoard() {
        if(instance==null) instance=new Board();
        return instance;
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
        for (Enemy enemy: enemiesList) {
            enemy.act();
        }
        callObservers();
        return gameOver;
    }// return true if game over

    //////////////////////////Observer Pattern
    @Override
    public void addObserver(Observer O) {
        tickObserver.add(O);
    }

    @Override
    public void callObservers() {
        for (Observer o :tickObserver) {
            o.onTickAct(this);
        }
    }
    //////////////////////////////////////////

    public void unitDied(Enemy enemy){
        enemiesList.remove(enemy);
        Point enemyLoction = enemy.getLocation();
        tiles[enemyLoction.getX()][enemyLoction.getY()] = new Empty(enemyLoction);
        player.killedEnemy(enemy.getExpValue());
        if(enemiesList.isEmpty()) buildBoard();
        String output = enemy.getName() + " died." + player.getName() + "Jon Snow gained" + enemy.getExpValue() + "experience";
    }

    public void playerDied(){
        gameOver = true;
    }

    public String toString(){
        char[][]arr=new char[tiles.length][tiles[0].length+1];
        String map="";
        for(int i=0;i<tiles.length;i++){
            int j=0;
            for(;j<tiles[0].length;j++){
                //arr[tiles[i][j].getLocation().getX()][tiles[i][j].getLocation().getY()]=tiles[i][j].getCharacter();
                map=map+""+tiles[i][j].getCharacter();
            }
            //arr[i][j]='\n';
            map=map+""+'\n';
        }
//        for(int i=0;i<arr.length;i++){
//            for(int j=0;j<arr[0].length;j++){
//                map=map+""+arr[i][j];
//            }
//        }
        return map;
    }

    //for warrior
    //return all enemies in range < 3
    public List<Enemy> enemiesInRangeWarrior(Player player, double range){
        List<Enemy> ls=new LinkedList<>();
        for (Enemy e:enemiesList) {
            if((int)player.getLocation().range(e.getLocation())<range){
                ls.add(e);
            }
        }
        return ls;
    }

    //for Mage
    //return all enemis who is randomly hited by mage spell range
    public List<Enemy> enemiesInRangeMage(Player player, double range){
        List<Enemy> ls=new LinkedList<>();
        for (Enemy e:enemiesList) {
            if((int)player.getLocation().range(e.getLocation())<=range){
                if(Math.random()*100>=50) //randomness elemnt
                    ls.add(e);
            }
        }
        return ls;
    }

    public List<Enemy> enemiesInRangeRogue(Player player, double range){
        List<Enemy> ls=new LinkedList<>();
        for (Enemy e:enemiesList) {
            if((int)player.getLocation().range(e.getLocation())<=range){
                ls.add(e);
            }
        }
        return ls;
    }
}
