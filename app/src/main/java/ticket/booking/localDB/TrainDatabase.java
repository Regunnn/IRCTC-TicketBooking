package ticket.booking.localDB;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import ticket.booking.entities.Train;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class TrainDatabase {
    private static final String FILE_PATH = "C:\\Users\\rehan\\ticketBooking\\app\\src\\main\\java\\ticket\\booking\\localDB\\trains.json";

    public static List<Train> loadTrains() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(FILE_PATH), new TypeReference<List<Train>>() {});
        } catch (IOException e) {
            return Collections.emptyList(); // Java 8 compatible
        }
    }

    public static void saveTrains(List<Train> trains) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        try {
            mapper.writeValue(new File(FILE_PATH), trains);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
