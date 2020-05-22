package com.project.koslist;

public class Kost {
    public int id;
    public String kosName;
    public int kosPrice;
    public String kosFacility;
    public String kosThumbnail;
    public String kosAddress;
    public double kosLatitude;
    public double kosLongitude;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKosName() {
        return kosName;
    }

    public void setKosName(String kosName) {
        this.kosName = kosName;
    }

    public int getKosPrice() {
        return kosPrice;
    }

    public void setKosPrice(int kosPrice) {
        this.kosPrice = kosPrice;
    }

    public String getKosFacility() {
        return kosFacility;
    }

    public void setKosFacility(String kosFacility) {
        this.kosFacility = kosFacility;
    }

    public String getKosThumbnail() {
        return kosThumbnail;
    }

    public void setKosThumbnail(String kosThumbnail) {
        this.kosThumbnail = kosThumbnail;
    }

    public String getKosAddress() {
        return kosAddress;
    }

    public void setKosAddress(String kosAddress) {
        this.kosAddress = kosAddress;
    }

    public double getKosLatitude() {
        return kosLatitude;
    }

    public void setKosLatitude(double kosLatitude) {
        this.kosLatitude = kosLatitude;
    }

    public double getKosLongitude() {
        return kosLongitude;
    }

    public void setKosLongitude(double kosLongitude) {
        this.kosLongitude = kosLongitude;
    }
}
