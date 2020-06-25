package Test;

import Board.*;
import javafx.beans.binding.When;
import org.junit.*;
import Tiles.*;
import Players.*;
import Enemys.*;

public class VisitorPatternTests {

    Player strongPlayer;
    Player weakPlayer;
    Monster strongMonster;
    Monster weakMonster;
    Wall wall;
    Empty empty;

    @Before
    public void initTest() {
        strongPlayer = new Warrior("strongPlayer", 1000, 1000, 1, 1000, new Point(1, 1));
        weakPlayer = new Warrior("weakPlayer", 0, 0, 1, 1, new Point(1, 1));

        strongMonster = new TestMonster(new Point(2, 2), 'a', "strongEnemy", 1000, 1000, 1000, 10, 10);

        weakMonster = new TestMonster(new Point(3, 3), 'a', "weakEnemy", 0, 0, 1, 10, 10);

        empty = new Empty(new Point(4,4));

        wall = new Wall(new Point(5,5));
    }

    @Test
    public void testPlayerGoToEmpty(){
        Assert.assertTrue( strongPlayer.visit(empty));
    }

    @Test
    public void testPlayerGoToWall(){
        Assert.assertFalse( strongPlayer.visit(wall));
    }

    @Test
    public void testMonsterGoToEmpty(){
        Assert.assertTrue( strongMonster.visit(empty));
    }

    @Test
    public void testMonsterGoToWall(){
        Assert.assertFalse( strongMonster.visit(wall));
    }

    @Test
    public void testPlayerGoToMonsterNotKill(){
        Assert.assertFalse( weakPlayer.visit(strongMonster));
    }

    @Test
    public void testPlayerGoToMonsterKill(){
       Assert.assertTrue( strongPlayer.visit(weakMonster));
    }

    @Test
    public void testMonsterGoToMonster(){
        Assert.assertFalse( weakMonster.visit(strongMonster));
    }

    @Test
    public void testMonsterGoToPlayerKill(){
        Assert.assertFalse( strongMonster.visit(weakPlayer));
    }

    @Test
    public void testMonsterGoToPlayerNotKill(){
        Assert.assertFalse( weakMonster.visit(strongPlayer));
    }




}