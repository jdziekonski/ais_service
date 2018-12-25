package ais.service;

import java.util.*;

public class Ship {
    private String mmsi;
    private String name;
    private String flag;
    private String vtype;
    private byte[] photo;
    private int gtonnage;
    
    public Ship(){
    }
    
    public Ship(String mmsi, String name, String flag, String vtype, byte[] photo, int gtonnage){
        this.mmsi = mmsi;
        this.name = name;
        this.flag = flag;
        this.vtype = vtype;
        this.photo = photo;
        this.gtonnage = gtonnage;
    }

    public String getMmsi() {
        return mmsi;
    }

    public void setMmsi(String mmsi) {
        this.mmsi = mmsi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getVtype() {
        return vtype;
    }

    public void setVtype(String vtype) {
        this.vtype = vtype;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public int getGtonnage() {
        return gtonnage;
    }

    public void setGtonnage(int gtonnage) {
        this.gtonnage = gtonnage;
    }
}
