package Control;

import Board.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GameController {
    public GameController(){}
    public void Start(String path){
        Board.getBoard().initBoard(getLevels(path));
        boolean gameOver = false;
        Scanner scan = new Scanner(System.in);
        while (!gameOver){
            ScreenWriter.getScreenWriter().print(Board.getBoard().getPlayer().toString());
            ScreenWriter.getScreenWriter().print(Board.getBoard().toString());
            char playerAct = scan.next().charAt(0);// = ...get the char to the playerd
            gameOver = Board.getBoard().gameTick(playerAct);// send with char
        }
    }
    private String[] getLevels(String args){
        File dir = new File(args);
        String[] dirFiles = dir.list();
        assert dirFiles != null;
        List<String> dirFilesPath = Arrays.stream(dirFiles).map(s -> args + "/" + s).collect(Collectors.toList());
        List<List<String>> filesContent = new ArrayList<>();
        for (String filePath : dirFilesPath){
            try {
                filesContent.add(Files.readAllLines(Paths.get(filePath)));
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        String[] levels=new String[filesContent.size()];
        int index=0;
        for (List<String> lst: filesContent) {
            String str="";
            for (String r: lst) {
                str+=r+"\n";
            }
            levels[index]=str;
            index++;
        }
        return levels;
    }
}
