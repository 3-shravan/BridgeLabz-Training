package hotel_reservation_system;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    HotelService service = new HotelService();

    service.addRoom(new StandardRoom(101));
    service.addRoom(new DeluxeRoom(201));

    while (true) {
      System.out.println("""
          1. View Rooms
          2. Book Room
          3. Checkout
          4. Exit
          """);

      System.out.print("Enter choice: ");
      int choice = sc.nextInt();

      try {
        switch (choice) {

        case 1:
          service.viewRooms();
          break;

        case 2:
          System.out.print("Enter Guest ID: ");
          String gid = sc.next();
          System.out.print("Enter Guest Name: ");
          String name = sc.next();
          Guest guest = new Guest(gid, name);

          System.out.print("Enter Room Number: ");
          int roomNo = sc.nextInt();
          System.out.print("Enter Number of Days: ");
          int days = sc.nextInt();

          service.bookRoom(roomNo, guest, days);
          break;

        case 3:
          System.out.print("Enter Reservation ID: ");
          int resId = sc.nextInt();
          service.checkout(resId);
          break;

        case 4:
          sc.close();
          System.out.println("Thank you. Goodbye!");
          return;

        default:
          System.out.println("Invalid choice");
        }
      } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
      }
    }
  }
}
