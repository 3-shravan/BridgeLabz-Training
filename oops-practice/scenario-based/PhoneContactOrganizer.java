// Custom exception for invalid phone no.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class InvalidPhoneNumberException extends Exception {
  public InvalidPhoneNumberException(String message) {
    super(message);
  }
}

class Contact {
  private String name;
  private String phoneNumber;

  public Contact(String name, String phoneNumber) throws InvalidPhoneNumberException {
    this.name = name;
    this.phoneNumber = phoneNumber;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getName() {
    return name;
  }

  void displayContact() {
    System.out.println("Name: " + name + ", Phone Number: " + phoneNumber);
  }

}

class ContactOrganizer {
  List<Contact> contacts = new ArrayList<>();

  private void validatePhoneNumber(String phoneNumber) throws InvalidPhoneNumberException {
    if (!phoneNumber.matches("\\d{10}")) {
      throw new InvalidPhoneNumberException("Phone number must be 10 digits long.");
    }
  }

  private boolean isDuplicate(String phoneNumber) {
    for (Contact contact : contacts) {
      if (contact.getPhoneNumber().equals(phoneNumber)) {
        return true;
      }
    }
    return false;
  }

  void addContct(String name, String phoneNumber) throws InvalidPhoneNumberException {
    validatePhoneNumber(phoneNumber);

    if (isDuplicate(phoneNumber)) {
      throw new InvalidPhoneNumberException("Duplicate phone number found: " + phoneNumber);
    }
    contacts.add(new Contact(name, phoneNumber));
    System.out.println("Contact added: " + name + ", " + phoneNumber);
  }

  void searchContact(String name) {
    for (Contact contact : contacts) {
      if (contact.getName().toLowerCase().contains(name.toLowerCase())) {
        contact.displayContact();
        return;
      } else {
        System.out.println("Contact not found: " + name);
      }
    }

  }

  void deleteContact(String phoneNumber) {
    for (Contact contact : contacts) {
      if (contact.getPhoneNumber().equals(phoneNumber)) {
        contacts.remove(contact);
        System.out.println("Contact deleted: " + phoneNumber);
        return;
      }
    }
    System.out.println("Contact not found: " + phoneNumber);
  }

  void displayAllContacts() {
    if (contacts.isEmpty()) {
      System.out.println("No contacts available.");
      return;
    }
    for (Contact contact : contacts) {
      contact.displayContact();
    }
  }
}

public class PhoneContactOrganizer {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    ContactOrganizer organizer = new ContactOrganizer();

    while (true) {
      System.out.println("\nPhone Contact Organizer");
      System.out.println("1. Add Contact");
      System.out.println("2. Delete Contact");
      System.out.println("3. Search Contact");
      System.out.println("4. Display All Contacts");
      System.out.println("5. Exit");
      System.out.print("Enter choice: ");
      int choice = sc.nextInt();
      sc.nextLine();

      switch (choice) {
        case 1:
          System.out.print("Enter name: ");
          String name = sc.nextLine();
          System.out.print("Enter phone number: ");
          String phoneNumber = sc.nextLine();
          try {
            organizer.addContct(name, phoneNumber);
          } catch (InvalidPhoneNumberException e) {
            System.out.println("Error: " + e.getMessage());
          }
          break;
        case 2:
          System.out.print("Enter phone number to delete: ");
          String phoneNumberToDelete = sc.nextLine();
          organizer.deleteContact(phoneNumberToDelete);
          break;
        case 3:
          System.out.print("Enter name to search: ");
          String nameToSearch = sc.nextLine();
          organizer.searchContact(nameToSearch);
          break;
        case 4:
          organizer.displayAllContacts();
          break;
        case 5:
          System.out.println("Exiting...");
          sc.close();
          System.exit(0);
        default:
          System.out.println("Invalid choice. Please try again.");
      }

    }

  }
}
