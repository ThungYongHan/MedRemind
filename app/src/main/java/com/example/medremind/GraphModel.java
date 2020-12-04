package com.example.medremind;

public class GraphModel {
    private int graphID;
    private String graphOnTime;
    private String graphOutOfRange;
    private String graphNotTaken;

    public GraphModel(){}

    public GraphModel(String graphOnTime, String graphOutOfRange, String graphNotTaken) {
        this.graphOnTime = graphOnTime;
        this.graphOutOfRange = graphOutOfRange;
        this.graphOutOfRange = graphOutOfRange;
    }

    public GraphModel(int graphID, String graphOnTime, String graphOutOfRange, String graphNotTaken) {
        this.graphID = graphID;
        this.graphOnTime = graphOnTime;
        this.graphOutOfRange = graphOutOfRange;
        this.graphNotTaken = graphNotTaken;
    }


    public int getGraphID() {
        return graphID;
    }

    public void setGraphID(int graphID) {
        this.graphID = graphID;
    }

    public String getGraphOnTime() {
        return graphOnTime;
    }

    public void setGraphOnTime(String graphOnTime) {
        this.graphOnTime = graphOnTime;
    }

    public String getGraphOutOfRange() {
        return graphOutOfRange;
    }

    public void setGraphOutOfRange(String graphOutOfRange) {
        this.graphOutOfRange = graphOutOfRange;
    }

    public String getGraphNotTaken() {
        return graphNotTaken;
    }

    public void setGraphNotTaken(String graphNotTaken) {
        this.graphNotTaken = graphNotTaken;
    }
}
