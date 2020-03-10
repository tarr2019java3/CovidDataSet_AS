package pl.sda.coviddataset;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    private Path path;
    private List<Record> records = new ArrayList<>();
    public void openFile(String filename){
        path = Paths.get(filename);
        try {
            List<String> lines = Files.readAllLines(path);

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
                Komparator komparator = new Komparator();
                records.sort(komparator);
            }
            JSONUtils jsonUtils = new JSONUtils();
            jsonUtils.writeList("COVID.json", records);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public Double getAllDeaths(String filename) {
        path = Paths.get(filename);
        Double deaths = 0.0;
        try {
            List<String> lines = Files.readAllLines(path);

            for (int x = 1; x<lines.size(); x++){
                String line = lines.get(x);
                String[] columns = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                String deadpeople = columns[6];
                deaths += deaths.parseDouble(deadpeople);
            }
    } catch (IOException e) {
            e.printStackTrace();
        }
        return deaths;
    }
    public void sortByColumn(String filename){
        path = Paths.get(filename);
        Komparator komparator = new Komparator();
        Record record = new Record();
        List<Record> sorted = new ArrayList<>();
        records.sort(komparator);
        JSONUtils jsonUtils = new JSONUtils();
        jsonUtils.writeList("COVID_sorted.json", records);
    }
}
