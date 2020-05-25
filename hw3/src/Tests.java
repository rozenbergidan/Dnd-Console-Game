import Board.Board;

import java.util.Arrays;
import java.util.Scanner;

public class Tests {
    public static void main(String[]args){
        String[] levels={"#########################\n" +
                "#b..........@..........b#\n" +
                "#.......................#\n" +
                "#...###...........###...#\n" +
                "#.......................#\n" +
                "#...zzz...........zzz...#\n" +
                "#...###g...w.w...g###...#\n" +
                "#.......................#\n" +
                "#......D.........D......#\n" +
                "#..####...........####..#\n" +
                "#..z##z...........z##z..#\n" +
                "#..####...........####..#\n" +
                "#.......................#\n" +
                "########.........########\n" +
                "########.........########\n" +
                "########.ww.K.ww.########\n" +
                "#########################"};
        Board.getBoard().initBoard(levels);
        Board.getBoard().selectCharacter(1);
        Board.getBoard().buildBoard();
        System.out.println(Arrays.deepToString(Board.getBoard().tiles));
    }
}
