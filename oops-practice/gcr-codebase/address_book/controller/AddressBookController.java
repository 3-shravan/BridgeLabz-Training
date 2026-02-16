package controller;

import java.util.List;
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
            showContactsFlow();
            break;
          case 2:
            addContactFlow();
            break;
          case 3:
            editContactFlow();
            break;
          case 4:
            deleteContactFlow();
            break;
          case 5:
            createAddressBookFlow();
            break;
          case 6:
            showAllAddressBooksFlow();
            break;
          case 7:
            switchAddressBookFlow();
            break;
          case 8:
            handleSearchByStateOrCity();
            break;
          case 9:
            handleViewByStateOrCity();
            break;
          case 10:
            handleContactCountByStateOrCity();
            break;
          case 11:
            sortContactsByNameFlow();
            break;
          case 12:
            sortContactsByCityStateOrZipFlow();
            break;
          case 13:
            fileReadWriteFlow();
            break;
          case 14:
            csvReadWriteUsingOpenCsvFlow();
            break;
          case 15:
            jsonReadWriteUsingGsonFlow();
            break;
          case 16:
            jsonServerReadWriteFlow();
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
      } catch (IllegalArgumentException e) {
        System.out.println("Error: " + e.getMessage());
      } catch (Exception e) {
        System.out.println("Unexpected error: " + e.getMessage());
      }
    }

    scanner.close();
  }

  private static void handleContactCountByStateOrCity() {
    try {
      System.out.println("Get Total Contacts by: ");
      System.out.println("1. State");
      System.out.println("2. City");
      System.out.print("Enter your choice: ");
      int choice = Integer.parseInt(scanner.nextLine());
      switch (choice) {
        case 0:
          return;
        case 1:
          System.out.print("Enter state to get total contacts: ");
          String state = scanner.nextLine();
          int stateCount = service.totalContactsCountByState(state);
          System.out.println("Total contacts in state '" + state + "': " + stateCount);
          break;
        case 2:
          System.out.print("Enter city to get total contacts: ");
          String city = scanner.nextLine();
          int cityCount = service.totalContactsCountByCity(city);
          System.out.println("Total contacts in city '" + city + "': " + cityCount);
          break;
        default:
          System.out.println("Invalid choice. Please select 1 or 2.");
      }

    } catch (IllegalArgumentException e) {
      System.out.println("Error: " + e.getMessage());
    }

  }

  private static void handleViewByStateOrCity() {
    try {
      System.out.println("View Contacts by: ");
      System.out.println("1. State");
      System.out.println("2. City");
      System.out.print("Enter your choice: ");
      int choice = Integer.parseInt(scanner.nextLine());
      switch (choice) {
        case 0:
          return;
        case 1:
          System.out.print("Enter state to view contacts: ");
          String state = scanner.nextLine();
          List<Contact> stateResults = service.getContactsByState(state);
          if (stateResults.isEmpty()) {
            System.out.println("No contacts found for the given state.");
          } else {
            System.out.println("Contacts found:");
            for (Contact contact : stateResults) {
              System.out.println(contact);
            }
          }
          break;
        case 2:
          System.out.print("Enter city to view contacts: ");
          String city = scanner.nextLine();
          List<Contact> cityResults = service.getContactsByCity(city);
          if (cityResults.isEmpty()) {
            System.out.println("No contacts found for the given city.");
          } else {
            System.out.println("Contacts found:");
            for (Contact contact : cityResults) {
              System.out.println(contact);
            }
          }
          break;
        default:
          System.out.println("Invalid choice. Please select 1 or 2.");
      }

    } catch (IllegalArgumentException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  private static void handleSearchByStateOrCity() {
    try {
      System.out.print("Enter state or city to search contacts: ");
      String keyword = scanner.nextLine();
      List<Contact> results = service.findContactByStateOrCity(keyword);
      if (results.isEmpty()) {
        System.out.println("No contacts found for the given state or city.");
      } else {
        System.out.println("Contacts found:");
        for (Contact contact : results) {
          System.out.println(contact);
        }
      }
    } catch (IllegalArgumentException e) {
      System.out.println("Error: " + e.getMessage());
    }

  }

  private static void showContactsFlow() {
    service.showContacts();
  }

  private static void showMenu() {
    System.out.println("\n===== ADDRESS BOOK MENU =====");
    System.out.println("1. View All Contacts");
    System.out.println("2. Add Contact");
    System.out.println("3. Edit Contact by First Name");
    System.out.println("4. Delete Contact by First Name");
    System.out.println("5. Create new Address Book");
    System.out.println("6. Show all Address Books");
    System.out.println("7. Switch Address Book ");
    System.out.println("8. Search Contacts by State or City");
    System.out.println("9. View Contacts by State or City");
    System.out.println("10. Get Total Contacts by State or City");
    System.out.println("11. Sort Contacts by Person Name (A-Z)");
    System.out.println("12. Sort Contacts by City/State/Zip");
    System.out.println("13. Read/Write Address Book To File");
    System.out.println("14. Read/Write Address Book as CSV (OpenCSV)");
    System.out.println("15. Read/Write Address Book as JSON (Gson)");
    System.out.println("16. Read/Write Address Book to JSONServer");
    System.out.println("0. Exit");
    System.out.print("Enter your choice: ");
  }

  private static void sortContactsByNameFlow() {
    service.showContactsSortedByName();
  }

  private static void sortContactsByCityStateOrZipFlow() {
    try {
      System.out.println("Sort contacts by:");
      System.out.println("1. City");
      System.out.println("2. State");
      System.out.println("3. Zip");
      System.out.print("Enter your choice: ");
      int choice = Integer.parseInt(scanner.nextLine());

      switch (choice) {
        case 1:
          service.showContactsSortedByCity();
          break;
        case 2:
          service.showContactsSortedByState();
          break;
        case 3:
          service.showContactsSortedByZip();
          break;
        default:
          System.out.println("Invalid choice. Please select 1, 2 or 3.");
      }
    } catch (NumberFormatException e) {
      System.out.println("Please enter a valid number.");
    }
  }

  private static void fileReadWriteFlow() {
    try {
      System.out.println("File Operations:");
      System.out.println("1. Write Address Book to File");
      System.out.println("2. Read Address Book from File");
      System.out.print("Enter your choice: ");
      int choice = Integer.parseInt(scanner.nextLine());

      System.out.print("Enter file path: ");
      String filePath = scanner.nextLine();

      switch (choice) {
        case 1:
          service.writeCurrentAddressBookToFile(filePath);
          break;
        case 2:
          service.readContactsFromFile(filePath);
          break;
        default:
          System.out.println("Invalid choice. Please select 1 or 2.");
      }
    } catch (NumberFormatException e) {
      System.out.println("Please enter a valid number.");
    } catch (IllegalArgumentException e) {
      System.out.println("Error: " + e.getMessage());
    } catch (IllegalStateException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  private static void csvReadWriteUsingOpenCsvFlow() {
    try {
      System.out.println("OpenCSV Operations:");
      System.out.println("1. Write Address Book as CSV");
      System.out.println("2. Read Address Book from CSV");
      System.out.print("Enter your choice: ");
      int choice = Integer.parseInt(scanner.nextLine());

      System.out.print("Enter CSV file path: ");
      String filePath = scanner.nextLine();

      switch (choice) {
        case 1:
          service.writeCurrentAddressBookToCsvUsingOpenCsv(filePath);
          break;
        case 2:
          service.readContactsFromCsvUsingOpenCsv(filePath);
          break;
        default:
          System.out.println("Invalid choice. Please select 1 or 2.");
      }
    } catch (NumberFormatException e) {
      System.out.println("Please enter a valid number.");
    } catch (IllegalArgumentException e) {
      System.out.println("Error: " + e.getMessage());
    } catch (IllegalStateException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  private static void jsonReadWriteUsingGsonFlow() {
    try {
      System.out.println("Gson JSON Operations:");
      System.out.println("1. Write Address Book as JSON");
      System.out.println("2. Read Address Book from JSON");
      System.out.print("Enter your choice: ");
      int choice = Integer.parseInt(scanner.nextLine());

      System.out.print("Enter JSON file path: ");
      String filePath = scanner.nextLine();

      switch (choice) {
        case 1:
          service.writeCurrentAddressBookToJsonUsingGson(filePath);
          break;
        case 2:
          service.readContactsFromJsonUsingGson(filePath);
          break;
        default:
          System.out.println("Invalid choice. Please select 1 or 2.");
      }
    } catch (NumberFormatException e) {
      System.out.println("Please enter a valid number.");
    } catch (IllegalArgumentException e) {
      System.out.println("Error: " + e.getMessage());
    } catch (IllegalStateException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  private static void jsonServerReadWriteFlow() {
    try {
      System.out.println("JSON Server Operations:");
      System.out.println("1. Write Address Book to JSON Server");
      System.out.println("2. Read Address Book from JSON Server");
      System.out.print("Enter your choice: ");
      int choice = Integer.parseInt(scanner.nextLine());

      System.out.print("Enter JSON Server API URL (example: http://localhost:3000/contacts): ");
      String apiUrl = scanner.nextLine();

      switch (choice) {
        case 1:
          service.writeCurrentAddressBookToJsonServer(apiUrl);
          break;
        case 2:
          service.readContactsFromJsonServer(apiUrl);
          break;
        default:
          System.out.println("Invalid choice. Please select 1 or 2.");
      }
    } catch (NumberFormatException e) {
      System.out.println("Please enter a valid number.");
    } catch (IllegalArgumentException e) {
      System.out.println("Error: " + e.getMessage());
    } catch (IllegalStateException e) {
      System.out.println("Error: " + e.getMessage());
    }
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

  private static void deleteContactFlow() {
    try {
      System.out.print("Enter first name of contact to delete: ");
      String firstName = scanner.nextLine();

      service.deleteContactByFirstName(firstName);
    } catch (IllegalArgumentException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  private static void createAddressBookFlow() {
    try {
      System.out.print("Enter name for new Address Book: ");
      String name = scanner.nextLine();
      service.createAddressBook(name);
    } catch (IllegalArgumentException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  private static void showAllAddressBooksFlow() {
    service.showAllAddressBooks();
  }

  private static void switchAddressBookFlow() {
    try {
      System.out.print("Enter name of Address Book to switch to: ");
      String name = scanner.nextLine();
      service.switchAddressBook(name);
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
