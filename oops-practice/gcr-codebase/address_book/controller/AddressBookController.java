package controller;

import java.util.Scanner;

import entity.Contact;
import service.AddressBookService;

public class AddressBookController {

  private static final Scanner scanner = new Scanner(System.in);
  private static final AddressBookService service = new AddressBookService();

  public static void main(String[] args) {

    boolean running = true;

    while (running) {
      try {
        showMenu();
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
        case 1:
          addContactFlow();
          break;
        case 2:
          editContactFlow();
          break;
        case 0:
          running = false;
          System.out.println("Exiting Address Book...!");
          break;
        default:
          System.out.println("Invalid choice. Try again.");
        }
      } catch (NumberFormatException e) {
        System.out.println("Please enter a valid number.");
      } catch (Exception e) {
        System.out.println("Unexpected error: " + e.getMessage());
      }
    }

    scanner.close();
  }

  private static void showMenu() {
    System.out.println("\n===== ADDRESS BOOK MENU =====");
    System.out.println("1. Add Contact");
    System.out.println("2. Edit Contact by First Name");
    System.out.println("0. Exit");
    System.out.print("Enter your choice: ");
  }

  private static void addContactFlow() {
    try {
      Contact contact = readContactDetails();
      service.addContact(contact);
    } catch (IllegalArgumentException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  private static void editContactFlow() {
    try {
      System.out.print("Enter first name of contact to edit: ");
      String firstName = scanner.nextLine();

      Contact updatedContact = readContactDetails();
      service.editContactByFirstName(firstName, updatedContact);
    } catch (IllegalArgumentException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  private static Contact readContactDetails() {
    System.out.print("First Name: ");
    String firstName = scanner.nextLine();

    System.out.print("Last Name: ");
    String lastName = scanner.nextLine();

    System.out.print("Address: ");
    String address = scanner.nextLine();

    System.out.print("City: ");
    String city = scanner.nextLine();

    System.out.print("State: ");
    String state = scanner.nextLine();

    System.out.print("Zip: ");
    String zip = scanner.nextLine();

    System.out.print("Phone Number: ");
    String phoneNumber = scanner.nextLine();

    System.out.print("Email: ");
    String email = scanner.nextLine();

    return new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
  }
}
