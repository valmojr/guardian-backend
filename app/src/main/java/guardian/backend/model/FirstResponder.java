package guardian.backend.model;

public class FirstResponder {
    private int id;
    private String username = "";
    private String password = "";
    private String email = "";
    private String showedName = "";
    private String description = "";
    private int privilegeLevel;
    private int lastPositionId;
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
    public int getLastPositionId() {
        return lastPositionId;
    }
    public void setLastPositionId(int reportedPosition) {
        this.lastPositionId = reportedPosition;
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
}
