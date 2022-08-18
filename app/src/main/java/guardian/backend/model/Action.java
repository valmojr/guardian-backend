package guardian.backend.model;

public class Action {
    private int id;
    private String description;
    private boolean state;
    private String designatedPosition;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public boolean isState() {
        return state;
    }
    public void setState(boolean state) {
        this.state = state;
    }
    public String getDesignatedPosition() {
        return designatedPosition;
    }
    public void setDesignatedPosition(String designatedPosition) {
        this.designatedPosition = designatedPosition;
    }
}
