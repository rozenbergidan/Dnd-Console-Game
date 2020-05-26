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
        Scanner scan = new Scanner(System.in);
        while (!gameOver){
            System.out.println("pick a move: ");
            char playerAct = scan.next().charAt(0);// = ...get the char to the playerd
            gameOver = Board.getBoard().gameTick(playerAct);// send with char
            System.out.println(Board.getBoard().toString());

        }
    }
}
