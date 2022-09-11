package guardian.backend.model;
public class Incident {
    private int id;
    private int lastPositionId;
    private int danger;
    private int state;
    private String description;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getLastPositionId() {
        return lastPositionId;
    }
    public void setLastPositionId(int lastPositionId) {
        this.lastPositionId = lastPositionId;
    }
    public int getDanger() {
        return danger;
    }
    public void setDanger(int danger) {
        this.danger = danger;
    }
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
