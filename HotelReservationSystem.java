import java.util.ArrayList;
import java.util.Scanner;

class telReservationSystem {
    int roomNumber;
    String category;
    boolean isAvailable;
    double price;

    telReservationSystem(int roomNumber, String category, boolean isAvailable, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.isAvailable = isAvailable;
        this.price = price;
    }
}

class Booking {
    String guestName;
    int roomNumber;
    String category;
    double price;

    Booking(String guestName, int roomNumber, String category, double price) {
        this.guestName = guestName;
        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
    }
}

public class HotelReservationSystem {
    public static void main(String[] args) {
        ArrayList<telReservationSystem> rooms = new ArrayList<>();
        ArrayList<Booking> bookings = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Adding some rooms
        rooms.add(new telReservationSystem(101, "Single", true, 100.0));
        rooms.add(new telReservationSystem(102, "Double", true, 150.0));
        rooms.add(new telReservationSystem(103, "Suite", true, 300.0));

        while (true) {
            System.out.println("\nHotel Reservation System");
            System.out.println("1. Search for Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Booking Details");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("\nAvailable Rooms:");
                    for (telReservationSystem room : rooms) {
                        if (room.isAvailable) {
                            System.out.println("Room Number: " + room.roomNumber + ", Category: " + room.category + ", Price: " + room.price);
                        }
                    }
                    break;
                case 2:
                    System.out.print("\nEnter your name: ");
                    String guestName = scanner.nextLine();
                    System.out.print("Enter room number: ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    telReservationSystem roomToBook = null;
                    for (telReservationSystem room : rooms) {
                        if (room.roomNumber == roomNumber && room.isAvailable) {
                            roomToBook = room;
                            break;
                        }
                    }

                    if (roomToBook != null) {
                        roomToBook.isAvailable = false;
                        bookings.add(new Booking(guestName, roomToBook.roomNumber, roomToBook.category, roomToBook.price));
                        System.out.println("Booking successful! Total amount to be paid: " + roomToBook.price);
                    } else {
                        System.out.println("Room not available or invalid room number.");
                    }
                    break;
                case 3:
                    System.out.println("\nBooking Details:");
                    for (Booking booking : bookings) {
                        System.out.println("Guest Name: " + booking.guestName + ", Room Number: " + booking.roomNumber + ", Category: " + booking.category + ", Price: " + booking.price);
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
