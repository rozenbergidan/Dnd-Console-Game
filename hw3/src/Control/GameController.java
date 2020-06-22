package Control;

import Board.*;

import java.util.Scanner;

public class GameController {
    public GameController(){}
    public void Start(String[]levels,int i){
        Board.getBoard().initBoard(levels);
        Board.getBoard().selectCharacter();
        Board.getBoard().buildBoard();
        boolean gameOver = false;
        Scanner scan = new Scanner(System.in);
        while (!gameOver){
            ScreenWriter.getScreenWriter().print(Board.getBoard().getPlayer().toString());
            ScreenWriter.getScreenWriter().print(Board.getBoard().toString());
            char playerAct = scan.next().charAt(0);// = ...get the char to the playerd
            gameOver = Board.getBoard().gameTick(playerAct);// send with char
            //ScreenWriter.getScreanWriter().print(Board.getBoard().getPlayer().toString());
        }

    }
}
