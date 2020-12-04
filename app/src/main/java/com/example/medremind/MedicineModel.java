package com.example.medremind;

public class MedicineModel {
    private int medID;
    private String medTitle,medSun,medMon,medTue,medWed,medThu,medFri,medSat,medTime,medDosage;

public MedicineModel (){}

    public MedicineModel(String medTitle,String medSun, String medMon, String medTue, String medWed, String medThu, String medFri, String medSat, String medTime, String medDosage){
        this.medTitle = medTitle;
        this.medSun = medSun;
        this.medMon = medMon;
        this.medTue = medTue;
        this.medWed = medWed;
        this.medThu = medThu;
        this.medFri = medFri;
        this.medSat = medSat;
        this.medTime = medTime;
        this.medDosage = medDosage;
    }

    public MedicineModel(int medID, String medTitle, String medSun, String medMon, String medTue, String medWed, String medThu, String medFri, String medSat, String medTime, String medDosage){
        this.medID = medID;
        this.medTitle = medTitle;
        this.medSun = medSun;
        this.medMon = medMon;
        this.medTue = medTue;
        this.medWed = medWed;
        this.medThu = medThu;
        this.medFri = medFri;
        this.medSat = medSat;
        this.medTime = medTime;
        this.medDosage = medDosage;
    }

    public int getMedID() {
        return medID;
    }

    public void setMedID(int medID) {
        this.medID = medID;
    }

    public String getMedTitle() {
        return medTitle;
    }

    public void setMedTitle(String medTitle) {
        this.medTitle = medTitle;
    }

    public String getMedTime() {
        return medTime;
    }

    public void setMedTime(String medTime) {
        this.medTime = medTime;
    }

    public String getMedMon() {
        return medMon;
    }

    public void setMedMon(String medMon) {
        this.medMon = medMon;
    }

    public String getMedTue() {
        return medTue;
    }

    public void setMedTue(String medTue) {
        this.medTue = medTue;
    }

    public String getMedWed() {
        return medWed;
    }

    public void setMedWed(String medWed) {
        this.medWed = medWed;
    }

    public String getMedThu() {
        return medThu;
    }

    public void setMedThu(String medThu) {
        this.medThu = medThu;
    }

    public String getMedFri() {
        return medFri;
    }

    public void setMedFri(String medFri) {
        this.medFri = medFri;
    }

    public String getMedSat() {
        return medSat;
    }

    public void setMedSat(String medSat) {
        this.medSat = medSat;
    }

    public String getMedSun() {
        return medSun;
    }

    public void setMedSun(String medSun) {
        this.medSun = medSun;
    }

    public String getMedDosage() {
        return medDosage;
    }

    public void setMedDosage(String medDosage) {
        this.medDosage = medDosage;
    }
}