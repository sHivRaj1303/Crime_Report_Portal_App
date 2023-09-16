package com.example.crimereport;

public class dataholder {

    String crimetype,crimedate,location,pimg;

    public dataholder(String location, String s, String toString) {
        this.location = location;
    }

    public dataholder(String crimetype, String crimedate) {
        this.crimetype = crimetype;
        this.crimedate = crimedate;
        this.pimg = pimg;
    }

    public String getCrimetype() {
        return crimetype;
    }

    public void setCrimetype(String crimetype) {
        this.crimetype = crimetype;
    }

    public String getCrimedate() {
        return crimedate;
    }

    public void setCrimedate(String crimedate) {
        this.crimedate = crimedate;
    }

    public String getPimg() {
        return pimg;
    }

    public void setPimg(String pimg) {
        this.pimg = pimg;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
