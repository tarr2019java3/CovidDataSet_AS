package pl.sda.coviddataset;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    private Path path;
    public void openFile(String filename){
        path = Paths.get(filename);
        try {
            List<String> lines = Files.readAllLines(path);
//            System.out.println(lines);
            List<Record> records = new ArrayList<>();
            for (int x = 1; x<lines.size(); x++){
                Record record = new Record();
                String line = lines.get(x);
                String[] columns = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                record.setSno(Integer.parseInt(columns[0]));
                record.setDate(columns[1]);
                record.setProvinceState(columns[2]);
                record.setCountry(columns[3]);
                record.setLast_Update(columns[4]);
                record.setConfirmed(Double.parseDouble(columns[5]));
                record.setDeaths(Double.parseDouble(columns[6]));
                record.setRecovered(Double.parseDouble(columns[7]));
                records.add(record);
            }
            JSONUtils jsonUtils = new JSONUtils();
            jsonUtils.writeList("COVID.json", records);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
