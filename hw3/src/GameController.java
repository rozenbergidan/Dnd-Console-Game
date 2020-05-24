import Board.*;
public class GameController {
    public void Start(){
        //Board.initBoard();       give input to the board and init it.
        boolean gameOver = false;
        while (!gameOver){
            Board.getBoard().gameTick();
        }
    }
}
