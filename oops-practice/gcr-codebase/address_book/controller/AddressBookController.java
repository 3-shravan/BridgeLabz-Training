package controller;

import java.util.Scanner;

import entity.Contact;

public class AddressBookController {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter First Name:");
    String firstName = scanner.nextLine();

    System.out.println("Enter Last Name:");
    String lastName = scanner.nextLine();

    System.out.println("Enter Address:");
    String address = scanner.nextLine();

    System.out.println("Enter City:");
    String city = scanner.nextLine();

    System.out.println("Enter State:");
    String state = scanner.nextLine();

    System.out.println("Enter Zip:");
    String zip = scanner.nextLine();

    System.out.println("Enter Phone Number:");
    String phoneNumber = scanner.nextLine();

    System.out.println("Enter Email:");
    String email = scanner.nextLine();

    Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
    System.out.println("Contact Created: " + contact);
  }

}
