package guardian.backend.model;

public class Patrol {
    private int id;
    private String specificArea = "";
    private int state;
    private String observation;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getSpecificArea() {
        return specificArea;
    }
    public void setSpecificArea(String specificArea) {
        this.specificArea = specificArea;
    }
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    public String getObservation() {
        return observation;
    }
    public void setObservation(String observation) {
        this.observation = observation;
    }
}
