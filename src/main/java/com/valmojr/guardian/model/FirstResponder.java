package com.valmojr.guardian.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class FirstResponder {
    private int id;
    private String username = "";
    private String password = "";
    private String email = "";
    private String showedName = "";
    private String description = "";
    private int privilegeLevel;
    private ArrayList<String> reportedPosition = new ArrayList<String>();
    private ArrayList<LocalDateTime> reportedPositionTime = new ArrayList<LocalDateTime>();
    private int firstResponderType;
    private boolean state;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getShowedName() {
        return showedName;
    }
    public void setShowedName(String showedName) {
        this.showedName = showedName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getPrivilegeLevel() {
        return privilegeLevel;
    }
    public void setPrivilegeLevel(int privilegeLevel) {
        this.privilegeLevel = privilegeLevel;
    }
    public ArrayList<String> getReportedPosition() {
        return reportedPosition;
    }
    public void setReportedPosition(ArrayList<String> reportedPosition) {
        this.reportedPosition = reportedPosition;
    }
    public ArrayList<LocalDateTime> getReportedPositionTime() {
        return reportedPositionTime;
    }
    public void setReportedPositionTime(ArrayList<LocalDateTime> reportedPositionTime) {
        this.reportedPositionTime = reportedPositionTime;
    }
    public int getFirstResponderType() {
        return firstResponderType;
    }
    public void setFirstResponderType(int firstResponderType) {
        this.firstResponderType = firstResponderType;
    }
    public boolean isReady() {
        return state;
    }
    public void setState(boolean state) {
        this.state = state;
    }

    public String getCurrentLocation() {
        return this.getReportedPosition().get(getReportedPosition().size()-1);
    }
    public LocalDateTime getCurrentLocationTime() {
        return this.getReportedPositionTime().get(getReportedPosition().size()-1);
    }
}
