package ticket.booking;

import ticket.booking.entities.Train;
import ticket.booking.service.TrainService;
import ticket.booking.service.UserBookingService;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TrainService trainService = new TrainService();
        UserBookingService bookingService = new UserBookingService();

        while (true) {
            System.out.println("1. Signup\n2. Login\n3. Search Trains\n4. Book Ticket\n5. View My Tickets\n6. Cancel Ticket\n7. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String suName = sc.nextLine();
                    System.out.print("Enter password: ");
                    String suPass = sc.nextLine();
                    if (bookingService.signup(suName, suPass))
                        System.out.println("Signup successful.");
                    else
                        System.out.println("Username already exists.");
                    break;
                case 2:
                    System.out.print("Enter username: ");
                    String liName = sc.nextLine();
                    System.out.print("Enter password: ");
                    String liPass = sc.nextLine();
                    if (bookingService.login(liName, liPass))
                        System.out.println("Login successful.");
                    else
                        System.out.println("Login failed.");
                    break;
                case 3:
                    System.out.print("Enter source: ");
                    String source = sc.nextLine().toLowerCase();
                    System.out.print("Enter destination: ");
                    String destination = sc.nextLine().toLowerCase();
                    List<Train> trains = trainService.searchTrains(source, destination);
                    if (trains.isEmpty()) {
                        System.out.println("No trains found.");
                    } else {
                        int index = 1;
                        for (Train t : trains) {
                            System.out.println(index++ + ". Train No: " + t.getTrainNo() + " | Train ID: " + t.getTrainId());
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter Train ID: ");
                    String trainId = sc.nextLine();
                    System.out.print("Enter source: ");
                    String src = sc.nextLine().toLowerCase();
                    System.out.print("Enter destination: ");
                    String dest = sc.nextLine().toLowerCase();
                    Train train = trainService.getTrainById(trainId);
                    if (train != null)
                        bookingService.bookTicket(train, src, dest);
                    else
                        System.out.println("Train not found.");
                    break;
                case 5:
                    bookingService.viewMyTickets();
                    break;
                case 6:
                    System.out.print("Enter Train ID to cancel: ");
                    String cancelId = sc.nextLine();
                    bookingService.cancelTicket(cancelId);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    System.exit(0);
            }
        }
    }
}
