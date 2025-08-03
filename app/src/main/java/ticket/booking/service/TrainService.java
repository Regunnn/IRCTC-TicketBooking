package ticket.booking.service;

import ticket.booking.entities.Train;
import ticket.booking.localDB.TrainDatabase;

import java.util.*;

public class TrainService {
    private Map<String, Train> trains;

    public TrainService() {
        this.trains = new HashMap<>();
        loadTrains();
    }

    private void loadTrains() {
        List<Train> trainList = TrainDatabase.loadTrains();
        for (Train train : trainList) {
            trains.put(train.getTrainId(), train);
        }
    }

    public void saveTrains() {
        TrainDatabase.saveTrains(new ArrayList<>(trains.values()));
    }

    public void addTrain(Train train) {
        trains.put(train.getTrainId(), train);
        saveTrains();
    }

    public Train getTrainById(String trainId) {
        return trains.get(trainId);
    }

    public List<Train> searchTrains(String source, String destination) {
        List<Train> result = new ArrayList<>();
        for (Train train : trains.values()) {
            List<String> stations = train.getStations();
            if (stations.contains(source.toLowerCase()) && stations.contains(destination.toLowerCase())) {
                if (stations.indexOf(source.toLowerCase()) < stations.indexOf(destination.toLowerCase())) {
                    result.add(train);
                }
            }
        }
        return result;
    }
}
