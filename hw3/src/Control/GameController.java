package Control;

import Board.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GameController {
    public GameController() {
    }

    public void Start(String path) {
        Board.getBoard().initBoard(getLevels(path));
        boolean gameOver = false;
        Scanner scan = new Scanner(System.in);
        while (!gameOver) {
            ScreenWriter.getScreenWriter().print(Board.getBoard().getPlayer().toString());
            ScreenWriter.getScreenWriter().print(Board.getBoard().toString());
            char playerAct = scan.next().charAt(0);// = ...get the char to the playerd
            gameOver = Board.getBoard().gameTick(playerAct);// send with char
        }
    }

    private String[] getLevels(String args) {
        File dir = new File(args);
        String[] dirFiles = dir.list();
        assert dirFiles != null;
        List<String> dirFilesPath = Arrays.stream(dirFiles).map(s -> args + "/" + s).collect(Collectors.toList());
        String[] levels = new String[dirFiles.length];
        int cnt = 0;
        for (String filePath : dirFilesPath) {
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                String everything = sb.toString();
                everything = everything.replaceAll("\r", "");
                levels[cnt] = everything;
                cnt++;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return levels;
    }
}

