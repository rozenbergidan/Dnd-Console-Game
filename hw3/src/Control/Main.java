package Control;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[]args){
        GameController gc=new GameController();
        File levelsDir = new File(args[0]);
        String[] levelsDirFilesNames = levelsDir.list();
        assert levelsDirFilesNames != null;
        List<String> inDirFilesPath = Arrays.stream(levelsDirFilesNames).map(s -> args[0] + "/" + s).collect(Collectors.toList());
        List<List<String>> LevelFilesContent = new ArrayList<>();
        for (String filePath : inDirFilesPath){
            try {
                LevelFilesContent.add(Files.readAllLines(Paths.get(filePath)));
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        gc.Start(LevelFilesContent.toArray(new String[0]));
    }
}
