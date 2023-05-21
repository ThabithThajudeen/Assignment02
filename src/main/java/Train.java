public class Train {
    private int trainId;
    private String status;
    private String location;

    // Constructor
    public Train(int trainId, String status, String location) {
        this.trainId = trainId;
        this.status = status;
        this.location = location;
    }

    // Getters and Setters
    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}