package Control;

import Board.*;

import java.util.List;
import java.util.Scanner;

public class GameController {
    public GameController(){}
    public void Start(String[] levels){
        Board.getBoard().initBoard(levels);
        boolean gameOver = false;
        Scanner scan = new Scanner(System.in);
        while (!gameOver){
            ScreenWriter.getScreenWriter().print(Board.getBoard().getPlayer().toString());
            ScreenWriter.getScreenWriter().print(Board.getBoard().toString());
            char playerAct = scan.next().charAt(0);// = ...get the char to the playerd
            gameOver = Board.getBoard().gameTick(playerAct);// send with char
        }
    }
}
