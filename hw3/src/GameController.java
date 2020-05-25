import Board.*;
public class GameController {
    public void Start(String[]levels,int i){
        Board.getBoard().initBoard(levels);
        Board.getBoard().selectCharacter(i);
        Board.getBoard().buildBoard();
        boolean gameOver = false;
        while (!gameOver){
            //get the char to the player
            Board.getBoard().gameTick();// send with char
        }
    }
}
