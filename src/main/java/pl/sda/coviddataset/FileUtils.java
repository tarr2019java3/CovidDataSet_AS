package pl.sda.coviddataset;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileUtils {
    private Path path;
    public void openFile(String filename){
        path = Paths.get(filename);
        try {
            List<String> lines = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
