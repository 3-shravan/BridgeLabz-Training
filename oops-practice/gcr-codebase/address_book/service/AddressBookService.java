package service;

import entity.Contact;
import repository.AddressBookRepository;

public class AddressBookService {

  private final AddressBookRepository addressBookRepository;

  public AddressBookService() {
    this.addressBookRepository = new AddressBookRepository();
  }

  private void validateContact(Contact contact) {

    if (contact == null) {
      throw new IllegalArgumentException("Contact cannot be null");
    }
    if (contact.getFirstName() == null || contact.getFirstName().isEmpty()) {
      throw new IllegalArgumentException("First name cannot be empty");
    }
  }

  private void validateField(String fieldValue, String fieldName) {
    if (fieldValue == null || fieldValue.isEmpty()) {
      throw new IllegalArgumentException(fieldName + " cannot be empty.");
    }
  }

  public void showContacts() {
    Contact contact = addressBookRepository.getContact();
    if (contact == null) {
      System.out.println("No contacts found.");
    } else {
      System.out.println(contact);
    }
  }

  public void addContact(Contact contact) {
    validateContact(contact);
    addressBookRepository.save(contact);
    System.out.println("Contact added Successfully");
  }

  public void editContactByFirstName(String firstName, Contact updatedContact) {

    validateField(firstName, "First name");
    validateContact(updatedContact);

    Contact existingContact = addressBookRepository.findByFirstName(firstName);
    if (existingContact == null) {
      throw new IllegalArgumentException("Contact not found with first name: " + firstName);
    }
    addressBookRepository.update(updatedContact);
    System.out.println("Contact updated Successfully");
  }

  public void deleteContactByFirstName(String firstName) {
    validateField(firstName, "First name");
    Contact existingContact = addressBookRepository.findByFirstName(firstName);
    if (existingContact == null) {
      throw new IllegalArgumentException("Contact not found with first name: " + firstName);
    }
    addressBookRepository.delete(existingContact);
    System.out.println("Contact deleted Successfully");
  }

}