package ticket.booking.entities;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String username;
    private String password;
    private List<Ticket> bookedTickets = new ArrayList<>();

    public User() {}

    public User(String userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Ticket> getBookedTickets() {
        return bookedTickets;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBookedTickets(List<Ticket> bookedTickets) {
        this.bookedTickets = bookedTickets;
    }
}
