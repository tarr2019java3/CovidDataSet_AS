package pl.sda.coviddataset;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JSONUtils {

    public void writeList(String filename, List<Record> list) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(filename), list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readList(String filename) {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(filename);
        try {
            Record[] elements = mapper.readValue(file, Record[].class);
            String a, b, c, d, e, f, g, h;
            for (int x = 0; x < elements.length; x++) {
                a = String.format("%-5d", elements[x].getSno());
                b = String.format("%20s", elements[x].getDate());
                c = String.format("%-30s", elements[x].getProvinceState());
                d = String.format("%-20s", elements[x].getCountry());
                e = String.format("%-20s", elements[x].getLast_Update());
                f = String.format("%6.0f", elements[x].getConfirmed());
                g = String.format("%6.0f", elements[x].getDeaths());
                h = String.format("%6.0f", elements[x].getRecovered());
                System.out.println(a + b+"   " + c + d + e + f + g + h);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}

