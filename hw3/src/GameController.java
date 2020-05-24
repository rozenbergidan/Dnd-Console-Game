import Board.*;
public class GameController {
    public void Start(){
        //Board.initBoard();       give input to the board and init it.
        boolean gameOver = false;
        while (!gameOver){
            //get the char to the player
            Board.getBoard().gameTick();// send with char
        }
    }
}
