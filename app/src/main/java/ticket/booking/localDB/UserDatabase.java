package ticket.booking.localDB;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import ticket.booking.entities.User;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserDatabase {
    private static final String FILE_PATH = "C:\\Users\\rehan\\ticketBooking\\app\\src\\main\\java\\ticket\\booking\\localDB\\users.json";

    public static Map<String, User> loadUsers() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(FILE_PATH), new TypeReference<Map<String, User>>() {});
        } catch (IOException e) {
            return new HashMap<>();
        }
    }

    public static void saveUsers(Map<String, User> users) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        try {
            mapper.writeValue(new File(FILE_PATH), users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
