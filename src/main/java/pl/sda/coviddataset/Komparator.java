package pl.sda.coviddataset;

import java.util.Comparator;

public class Komparator implements Comparator<Record> {
    @Override
    public int compare(Record o1, Record o2) {
        if (o2==null) return -1;
        if (o1.getDeaths()>o2.getDeaths()) return 1;
        else if (o1.getDeaths()<o2.getDeaths()) return -1;
        else return 0;
    }
}
