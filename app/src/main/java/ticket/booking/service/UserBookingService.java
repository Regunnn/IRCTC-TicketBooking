package ticket.booking.service;

import ticket.booking.entities.Ticket;
import ticket.booking.entities.Train;
import ticket.booking.entities.User;
import ticket.booking.localDB.UserDatabase;
import ticket.booking.util.UserServiceUtil;

import java.time.LocalDateTime;
import java.util.*;

public class UserBookingService {
    private Map<String, User> users;
    private User currentUser;

    public UserBookingService() {
        this.users = UserDatabase.loadUsers();
    }

    public boolean login(String username, String password) {
        for (User user : users.values()) {
            if (user.getUsername().equals(username) &&
                UserServiceUtil.verifyPassword(password, user.getPassword())) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    public boolean signup(String username, String password) {
        String userId = UUID.randomUUID().toString();
        for (User user : users.values()) {
            if (user.getUsername().equals(username)) {
                return false;
            }
        }
        User user = new User(userId, username, UserServiceUtil.hashPassword(password));
        users.put(userId, user);
        UserDatabase.saveUsers(users);
        return true;
    }

    public void bookTicket(Train train, String source, String destination) {
        if (currentUser == null) {
            System.out.println("Please login first.");
            return;
        }
        Ticket ticket = new Ticket(train.getTrainId(), source, destination, LocalDateTime.now());
        currentUser.getBookedTickets().add(ticket);
        users.put(currentUser.getUserId(), currentUser);
        UserDatabase.saveUsers(users);
        System.out.println("Ticket booked successfully: " + ticket);
    }

    public void viewMyTickets() {
        if (currentUser == null) {
            System.out.println("Please login first.");
            return;
        }
        List<Ticket> tickets = currentUser.getBookedTickets();
        if (tickets.isEmpty()) {
            System.out.println("No tickets booked.");
        } else {
            for (Ticket ticket : tickets) {
                System.out.println(ticket);
            }
        }
    }

    public void cancelTicket(String trainId) {
        if (currentUser == null) {
            System.out.println("Please login first.");
            return;
        }
        List<Ticket> tickets = currentUser.getBookedTickets();
        boolean removed = tickets.removeIf(t -> t.getTrainId().equals(trainId));
        if (removed) {
            users.put(currentUser.getUserId(), currentUser);
            UserDatabase.saveUsers(users);
            System.out.println("Ticket cancelled.");
        } else {
            System.out.println("No such ticket found.");
        }
    }
}
