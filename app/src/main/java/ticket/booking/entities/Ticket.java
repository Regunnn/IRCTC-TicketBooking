package ticket.booking.entities;

import java.time.LocalDateTime;

public class Ticket {
    private String trainId;
    private String source;
    private String destination;
    private LocalDateTime bookingTime;

    public Ticket() {}

    public Ticket(String trainId, String source, String destination, LocalDateTime bookingTime) {
        this.trainId = trainId;
        this.source = source;
        this.destination = destination;
        this.bookingTime = bookingTime;
    }

    public String getTrainId() {
        return trainId;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    @Override
    public String toString() {
        return "Train ID: " + trainId + ", Source: " + source + ", Destination: " + destination + ", Time: " + bookingTime;
    }
}
