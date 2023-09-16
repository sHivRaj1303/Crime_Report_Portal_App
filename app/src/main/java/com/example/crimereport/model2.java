package com.example.crimereport;

public class model2 {

    String type , date, location , des, pimg2;

    public model2() {
    }

    public model2(String type, String date, String location, String des, String pimg2) {
        this.type = type;
        this.date = date;
        this.location = location;
        this.des = des;
        this.pimg2 = pimg2;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getPimg2() {
        return pimg2;
    }

    public void setPimg2(String pimg2) {
        this.pimg2 = pimg2;
    }
}
