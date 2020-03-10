package pl.sda.coviddataset;

import java.util.Arrays;

public class MergeSort {
    public Record[] mergeTwo(Record[] first, Record[] second) {
        Record[] result = new Record[first.length + second.length];
        Record indexResult = null;
        Record indexFirst = null, indexSecond = null;
            if (((indexFirst < first.length) && (first[indexFirst] < second[indexSecond])) || (indexSecond == second.length)) {
                result[indexResult] = first[indexFirst];
                indexFirst++;
            } else {
                result[indexResult] = second[indexSecond];
                indexSecond++;
            }
            indexResult++;
        }
        return result;
    }

    public int[] sortowaniePrzezScalanie(int[] kolekcja) {
        int podzial = kolekcja.length / 2;
        int[] prawa = sortowaniePrzezScalanie(Arrays.copyOfRange(kolekcja, 0, podzial));
        int[] lewa = sortowaniePrzezScalanie(Arrays.copyOfRange(kolekcja, podzial, kolekcja.length));
        return scalDwie(prawa, lewa);
    }
}
