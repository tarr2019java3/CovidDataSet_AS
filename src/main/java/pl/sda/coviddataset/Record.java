package pl.sda.coviddataset;

public class Record {
    private Integer Sno;
    private String Date, ProvinceState, Country, Last_Update;
    private Double Confirmed, Deaths, Recovered;

    public Record() {
    }

    public Record(Integer sno, String date, String provinceState, String country, String last_Update, Double confirmed, Double deaths, Double recovered) {
        Sno = sno;
        Date = date;
        ProvinceState = provinceState;
        Country = country;
        Last_Update = last_Update;
        Confirmed = confirmed;
        Deaths = deaths;
        Recovered = recovered;
    }

    public Integer getSno() {
        return Sno;
    }

    public void setSno(Integer sno) {
        Sno = sno;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getProvinceState() {
        return ProvinceState;
    }

    public void setProvinceState(String provinceState) {
        ProvinceState = provinceState;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getLast_Update() {
        return Last_Update;
    }

    public void setLast_Update(String last_Update) {
        Last_Update = last_Update;
    }

    public Double getConfirmed() {
        return Confirmed;
    }

    public void setConfirmed(Double confirmed) {
        Confirmed = confirmed;
    }

    public Double getDeaths() {
        return Deaths;
    }

    public void setDeaths(Double deaths) {
        Deaths = deaths;
    }

    public Double getRecovered() {
        return Recovered;
    }

    public void setRecovered(Double recovered) {
        Recovered = recovered;
    }
}
