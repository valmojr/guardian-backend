package com.valmojr.guardian.model;

public class AreaOfInterest {
    private int id;
    private String designatedArea = "";
    private int danger;
    private String observation = "";

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDesignatedArea() {
        return designatedArea;
    }
    public void setDesignatedArea(String designatedArea) {
        this.designatedArea = designatedArea;
    }
    public int getDanger() {
        return danger;
    }
    public void setDanger(int danger) {
        this.danger = danger;
    }
    public String getObservation() {
        return observation;
    }
    public void setObservation(String observation) {
        this.observation = observation;
    }
}
