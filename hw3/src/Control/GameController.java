package Control;

import Board.*;

import java.util.Scanner;

public class GameController {
    public GameController(){}
    public void Start(String[]levels,int i){
        Board.getBoard().initBoard(levels);
        Board.getBoard().selectCharacter(i);
        Board.getBoard().buildBoard();
        boolean gameOver = false;
        int j = 0;
        while (!gameOver & j < 20){
            System.out.println("pick a move: ");

            char playerAct = 's';// = ...get the char to the player
            gameOver = Board.getBoard().gameTick(playerAct);// send with char
            System.out.println(Board.getBoard().toString());
            j ++;
        }
    }
}
