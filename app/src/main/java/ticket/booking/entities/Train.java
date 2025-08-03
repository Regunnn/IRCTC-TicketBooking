package ticket.booking.entities;

import java.util.List;

public class Train {
    private String trainId;
    private int trainNo;
    private List<String> stations;

    public Train() {}

    public Train(String trainId, int trainNo, List<String> stations) {
        this.trainId = trainId;
        this.trainNo = trainNo;
        this.stations = stations;
    }

    public String getTrainId() {
        return trainId;
    }

    public int getTrainNo() {
        return trainNo;
    }

    public List<String> getStations() {
        return stations;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public void setTrainNo(int trainNo) {
        this.trainNo = trainNo;
    }

    public void setStations(List<String> stations) {
        this.stations = stations;
    }
}
