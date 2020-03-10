package pl.sda.coviddataset;

public class Main {

    public static void main(String[] args) {
        FileUtils fileUtils = new FileUtils();
	    fileUtils.openFile("2019_nCoV_data.csv");
	    JSONUtils jsonUtils = new JSONUtils();
	    jsonUtils.readList("COVID.json");
        System.out.println("All deaths: " + fileUtils.getAllDeaths("2019_nCoV_data.csv"));
        //fileUtils.sortByColumn("2019_nCoV_data.csv");
    }
}
