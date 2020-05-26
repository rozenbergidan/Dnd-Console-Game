package Emenys;

import Board.*;
import Players.Player;
import Tiles.Tile;
import VisitorPattern.*;

public class Monster extends Enemy implements Visitor {

    private int vision;

    public Monster(Point point, char character, String name, int attack, int defence, int health, int vision,int expValue) {
        super(expValue,point, character, name, attack, defence, health);
        this.vision=vision;
    }

    private void moveTo(Point goTo){
        Tile toVisit = Board.getBoard().getTile(goTo);
        if(visit(toVisit)){
            switchLocation(toVisit);
            Board.getBoard().switchTile(location, toVisit.getLocation());
        }
    }
    public void moveRight(){ ///////////// change back to private
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
    @Override
    public void act(){
        Player player = Board.getBoard().getPlayer();
        //if(location.range(player.getLocation())< vision){
            //algorithm to go the best path to player / go to player way
        //}
        //else{
            int direction = (int) (Math.random()*5);
            if(direction == 0){
                moveRight();
            }
            if(direction == 1){
                moveUp();
            }
            if(direction == 2){
                moveLeft();
            }
            if(direction == 3){
                moveDown();
            }
        //}

    }

    @Override
    public boolean accept(Player p) {// if dead change all neccesery in board
        return p.attack(this);

    }

    @Override
    public boolean accept(Monster m) {
        return false;
    }

    @Override
    public boolean visit(Visited v) {
        return v.accept(this);
    }

    @Override
    public String toString(){
        return super.toString()+"\t\tVision Range: "+vision;
    }

}
