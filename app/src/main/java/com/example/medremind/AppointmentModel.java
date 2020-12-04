package com.example.medremind;

public class AppointmentModel {
 private int aptID;
 private String aptTitle,aptDateTime;

 public AppointmentModel(){}

    public AppointmentModel(String aptTitle, String aptDateTime) {
        this.aptTitle = aptTitle;
        this.aptDateTime = aptDateTime;
    }

    public AppointmentModel(int aptID, String aptTitle, String aptDateTime) {
        this.aptID = aptID;
        this.aptTitle = aptTitle;
        this.aptDateTime = aptDateTime;
    }

    public int getAptID() {
        return aptID;
    }

    public void setAptID(int aptID) {
        this.aptID = aptID;
    }

    public String getAptTitle() {
        return aptTitle;
    }

    public void setAptTitle(String aptTitle) {
        this.aptTitle = aptTitle;
    }

    public String getAptDateTime() {
        return aptDateTime;
    }

    public void setAptDateTime(String aptDateTime) {
        this.aptDateTime = aptDateTime;
    }
}
