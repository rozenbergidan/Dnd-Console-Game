import Board.Board;

import java.util.Arrays;
import java.util.Scanner;

public class Tests {
    public static void main(String[]args){
        String[] levels={"#################################################\n" +
                "#....s...#B#..........................#.........#\n" +
                "#........###....##..........##........#.........#\n" +
                "#........#......##..........##........#.........#\n" +
                "#........#............................#.........#\n" +
                "#........#............................#.........#\n" +
                "#........#......##..........##........#.........#\n" +
                "#........#......##s........k##........#.........#\n" +
                "#........#s.................##.......k#.........#\n" +
                "#@...........................Q.................q#\n" +
                "#........#s.................##.......k#.........#\n" +
                "#........#......##s........k##........#.........#\n" +
                "#........#......##..........##........#.........#\n" +
                "#........#............................#.........#\n" +
                "#........#............................#.........#\n" +
                "#........#......##..........##........#.........#\n" +
                "#........###....##..........##........#.........#\n" +
                "#....s...#B#..........................#.........#\n" +
                "#################################################","#########################\n" +
                "#.........M.C...........#\n" +
                "#........qqqqqq.........#\n" +
                "#...###...........###...#\n" +
                "#....Q.............Q....#\n" +
                "#.......................#\n" +
                "#.......................#\n" +
                "#...###...........###...#\n" +
                "#...###...q...q...###...#\n" +
                "#........kk...kk........#\n" +
                "#.......................#\n" +
                "#.......................#\n" +
                "#.......................#\n" +
                "#..k##k...........k##k..#\n" +
                "#...##.............##...#\n" +
                "#..ssss...........ssss..#\n" +
                "#.......................#\n" +
                "#.......................#\n" +
                "#.......................#\n" +
                "#...........@...........#\n" +
                "#########################","####################################################\n" +
                "#B........................g.......................B#\n" +
                "#..................................................#\n" +
                "#...####....................................####...#\n" +
                "#...####....................................####...#\n" +
                "#...####....................................####...#\n" +
                "#.....................z.......z....................#\n" +
                "#..................................................#\n" +
                "#..................................................#\n" +
                "#..................................................#\n" +
                "#............b............@............b...........#\n" +
                "#..................................................#\n" +
                "#..................................................#\n" +
                "#..................................................#\n" +
                "#.....................z.......z....................#\n" +
                "#..................................................#\n" +
                "#..................................................#\n" +
                "#..................................................#\n" +
                "#..................................................#\n" +
                "#.........................w........................#\n" +
                "####################################################","#########################\n" +
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
        System.out.println(Board.getBoard().toString());
        Board.getBoard().getPlayer().act('d');
        System.out.println(Board.getBoard().toString());
        Board.getBoard().getPlayer().act('d');
        System.out.println(Board.getBoard().toString());
        Board.getBoard().getPlayer().act('d');
        System.out.println(Board.getBoard().toString());
        Board.getBoard().getPlayer().act('d');
        System.out.println(Board.getBoard().toString());
        Board.getBoard().getPlayer().act('d');
        System.out.println(Board.getBoard().toString());
        Board.getBoard().getPlayer().act('d');
        System.out.println(Board.getBoard().toString());
        Board.getBoard().getPlayer().act('d');
        System.out.println(Board.getBoard().toString());
        Board.getBoard().getPlayer().act('d');
        System.out.println(Board.getBoard().toString());
        Board.getBoard().getPlayer().act('d');
        System.out.println(Board.getBoard().toString());
        Board.getBoard().getPlayer().act('d');
        System.out.println(Board.getBoard().toString());
        Board.getBoard().getPlayer().act('d');
        System.out.println(Board.getBoard().toString());
        Board.getBoard().getPlayer().act('d');
        System.out.println(Board.getBoard().toString());
        Board.getBoard().getPlayer().act('d');
        System.out.println(Board.getBoard().toString());
        Board.getBoard().getPlayer().act('d');
        System.out.println(Board.getBoard().toString());
        Board.getBoard().getPlayer().act('d');
        System.out.println(Board.getBoard().toString());
        Board.getBoard().getPlayer().act('d');
        System.out.println(Board.getBoard().toString());
        Board.getBoard().getPlayer().act('d');
        System.out.println(Board.getBoard().toString());
        Board.getBoard().getPlayer().act('d');
        System.out.println(Board.getBoard().toString());
        Board.getBoard().getPlayer().act('d');
        System.out.println(Board.getBoard().toString());
        Board.getBoard().getPlayer().act('d');
        System.out.println(Board.getBoard().toString());
        Board.getBoard().getPlayer().act('d');
        System.out.println(Board.getBoard().toString());
        Board.getBoard().getPlayer().act('d');
        System.out.println(Board.getBoard().toString());
        Board.getBoard().getPlayer().act('d');
        System.out.println(Board.getBoard().toString());
        Board.getBoard().getPlayer().act('d');
        System.out.println(Board.getBoard().toString());
        Board.getBoard().getPlayer().act('d');
        System.out.println(Board.getBoard().toString());
        Board.getBoard().getPlayer().act('d');
        System.out.println(Board.getBoard().toString());
        Board.getBoard().getPlayer().act('d');
        System.out.println(Board.getBoard().toString());
        Board.getBoard().getPlayer().act('d');
        System.out.println(Board.getBoard().toString());





        System.out.println(Board.getBoard().toString());
//        System.out.println(Arrays.deepToString(Board.getBoard().tiles));
//        Board.getBoard().buildBoard();
//        System.out.println(Arrays.deepToString(Board.getBoard().tiles));
//        Board.getBoard().buildBoard();
//        System.out.println(Arrays.deepToString(Board.getBoard().tiles));
//        Board.getBoard().buildBoard();
//        System.out.println(Arrays.deepToString(Board.getBoard().tiles));

    }
}
