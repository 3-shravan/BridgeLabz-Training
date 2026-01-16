package service;

import entity.Contact;
import repository.AddressBookRepository;

public class AddressBookService {

  private final AddressBookRepository addressBookRepository;

  public AddressBookService() {
    this.addressBookRepository = new AddressBookRepository();
  }

  public void addContact(Contact contact) {
    validateContact(contact);
    addressBookRepository.save(contact);
    System.out.println("Contact added Successfully");
  }

  public void editContactByFirstName(String firstName, Contact updatedContact) {

    if (firstName == null || firstName.isEmpty()) {
      throw new IllegalArgumentException("First name cannot be empty.");
    }
    validateContact(updatedContact);

    Contact existingContact = addressBookRepository.findByFirstName(firstName);
    if (existingContact == null) {
      throw new IllegalArgumentException("Contact not found with first name: " + firstName);
    }
    addressBookRepository.update(updatedContact);
    System.out.println("Contact updated Successfully");
  }

  private void validateContact(Contact contact) {

    if (contact == null) {
      throw new IllegalArgumentException("Contact cannot be null");
    }
    if (contact.getFirstName() == null || contact.getFirstName().isEmpty()) {
      throw new IllegalArgumentException("First name cannot be empty");
    }
  }

}
