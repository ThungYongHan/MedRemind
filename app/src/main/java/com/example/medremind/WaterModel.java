package com.example.medremind;

public class WaterModel {
    private int waterID;
    private String waterIntake;

    public WaterModel(){}

    public WaterModel(String waterIntake) {
        this.waterIntake = waterIntake;
    }

    public WaterModel(int waterID, String waterIntake) {
        this.waterID = waterID;
        this.waterIntake = waterIntake;
    }

    public int getWaterID() {
        return waterID;
    }

    public void setWaterID(int aptID) {
        this.waterID = waterID;
    }

    public String getWaterIntake() {
        return waterIntake;
    }

    public void setWaterIntake(String waterIntake) {
        this.waterIntake = waterIntake;
    }

}
