package guardian.backend.control;

import java.sql.Date;
import java.util.ArrayList;

public class FirstResponder {
    int id;
    String username;
    String password;
    String email;
    String showedName;
    int privilegeLevel;
    ArrayList<String> reportedPosition;
    ArrayList<Date> reportedPositionTime;
    int FirstResponderType;
    boolean state;
    String description;
    ArrayList<Integer> assignedAction;

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
    public ArrayList<Date> getReportedPositionTime() {
        return reportedPositionTime;
    }
    public void setReportedPositionTime(ArrayList<Date> reportedPositionTime) {
        this.reportedPositionTime = reportedPositionTime;
    }
    public int getFirstResponderType() {
        return FirstResponderType;
    }
    public void setFirstResponderType(int firstResponderType) {
        FirstResponderType = firstResponderType;
    }
    public boolean getState() {
        return state;
    }
    public void setState(boolean state) {
        this.state = state;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public ArrayList<Integer> getAssignedAction() {
        return assignedAction;
    }
    public void setAssignedAction(ArrayList<Integer> assignedAction) {
        this.assignedAction = assignedAction;
    }

    public boolean isReady() {
        return !this.state;
    }
}
