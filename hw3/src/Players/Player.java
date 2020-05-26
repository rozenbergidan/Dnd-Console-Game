package Players;

import Board.*;
import Emenys.Monster;
import ObserverPattern.Observer;
import Tiles.*;
import VisitorPattern.Visited;
import VisitorPattern.Visitor;

public abstract class Player extends Unit implements Observer, Visitor{
    //    public final char ON_MAP='@';
    private final int START_LEVEL=1;
    private final int START_EXP=0;
    protected int level;
    protected int exp;

    public Player(String name, int attack, int defence,int health,Point point){
        super(point,'@',name, attack, defence, health);
        level=START_LEVEL;
        exp=START_EXP;
    }

    public void levelUP() {
        exp = exp - (50 * level);
        level++;
        health.levelUP(level);
        attackPoint = attackPoint + 4 * level;
        defencePoint = defencePoint + level;
    }

    public abstract void castSpacialAbillity();

    private void moveTo(Point goTo){
        //Tile toVisit = Board.getBoard().getTile(goTo);
        if(visit(Board.getBoard().getTile(goTo))){
            switchLocation(Board.getBoard().getTile(goTo));
            Board.getBoard().switchTile(location, Board.getBoard().getTile(goTo).getLocation());
        }
    }
    private void moveRight(){
        Point goTo = new Point(location.getX(), location.getY() + 1);
        moveTo(goTo);
    }

    private void moveLeft(){
        Point goTo  = new Point(location.getX() , location.getY()- 1);
        moveTo(goTo);
    }
    private void moveUp(){
        Point goTo  = new Point(location.getX() - 1, location.getY() );
        moveTo(goTo);
    }

    private void moveDown(){
        Point goTo  = new Point(location.getX() + 1, location.getY() );
        moveTo(goTo);
    }

    public void act(char action) {// get the action char from the gameController
        if (action == 'e') castSpacialAbillity();
        if (action == 'w') moveUp();
        if (action == 'd') moveRight();
        if (action == 's') moveDown();
        if (action == 'a') moveLeft();

    }

    public void setLocation(int i, int j) {
        location.setX(i);
        location.setY(j);
    }

    public void killedEnemy(int monsterExp){
        exp = exp + monsterExp;
        if (exp >= level * 50){
            levelUP();
        }
    }

    public void died(){
        this.character = 'X';
    }

    @Override
    public boolean visit(Visited V){
        return V.accept(this);
    }

    @Override
    public boolean accept(Player p) {
        return false;
    }

    @Override
    public boolean accept(Monster m) {
        return m.attack(this);
    }
}
