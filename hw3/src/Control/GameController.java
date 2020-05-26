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
        Scanner scan = new Scanner(System.in);
        while (!gameOver){

            char playerAct = scan.next().charAt(0);// = ...get the char to the playerd
            gameOver = Board.getBoard().gameTick(playerAct);// send with char
            System.out.println(Board.getBoard().toString());

        }
    }
}
