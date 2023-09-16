package com.example.crimereport;

public class datahilder1 {

    String crimetype,crimedate,crimeloccatiom,img;

    public datahilder1(String s, String toString, String string) {
    }

    public datahilder1(String crimetype, String crimedate, String crimeloccatiom, String img) {
        this.crimetype = crimetype;
        this.crimedate = crimedate;
        this.crimeloccatiom = crimeloccatiom;
        this.img = img;
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

    public String getCrimeloccatiom() {
        return crimeloccatiom;
    }

    public void setCrimeloccatiom(String crimeloccatiom) {
        this.crimeloccatiom = crimeloccatiom;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
