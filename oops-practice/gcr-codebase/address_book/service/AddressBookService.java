package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import entity.AddressBook;
import entity.Contact;
import repository.AddressBookRepository;
import repository.AddressBookSystemRepository;

public class AddressBookService {

  private final AddressBookSystemRepository systemRepository = new AddressBookSystemRepository();
  private final AddressBookRepository addressBookRepository = new AddressBookRepository();
  private AddressBook currentAddressBook;

  public AddressBookService() {
    this.currentAddressBook = systemRepository.getDefaultAddressBook();
  }

  /*
   * SystemRepository methods called from service layer
   */

  public void createAddressBook(String name) {
    validateField(name);
    if (systemRepository.getAddressBook(name) != null)
      throw new IllegalArgumentException("Address Book with name " + name + " already exists.");

    systemRepository.addAddressBook(name);
    System.out.println("Address Book '" + name + "' created successfully.");
  }

  public void switchAddressBook(String name) {
    validateField(name);
    AddressBook addressBook = systemRepository.getAddressBook(name);
    if (addressBook == null) {
      throw new IllegalArgumentException("Address Book with name " + name + " does not exist.");
    }
    this.currentAddressBook = addressBook;
    System.out.println("Switched to Address Book '" + name + "'.");
  }

  public void showAllAddressBooks() {
    Map<String, AddressBook> addressBookNames = systemRepository.getAllAddressBooks();
    if (addressBookNames.isEmpty()) {
      System.out.println("No Address Books found.");
    } else {
      System.out.println("Available Address Books:");
      for (String name : addressBookNames.keySet()) {
        System.out.println("- " + name);
      }
    }
  }

  public List<Contact> getContactByStateOrCity(String keyword) {

    validateField(keyword);
    List<Contact> results = new ArrayList<>();
    for (AddressBook ab : systemRepository.getAllAddressBooks().values()) {
      List<Contact> contacts = addressBookRepository.findByStateOrCity(ab, keyword);
      if (contacts != null)
        results.addAll(contacts);
    }
    return results;
  }

  /*
   * @Repository methods called from service layer
   */

  public void showContacts() {
    List<Contact> contacts = currentAddressBook.getContacts();
    if (contacts == null || contacts.isEmpty()) {
      System.out.println("No contacts found.");
    } else {
      for (Contact contact : contacts) {
        System.out.println(contact);
      }
    }
  }

  public void addContact(Contact contact) {
    validateContact(contact);
    boolean isExists = addressBookRepository.isContactExists(currentAddressBook, contact);
    if (isExists) {
      throw new IllegalArgumentException("Contact with first name " + contact.getFirstName() + " already exists.");
    }
    addressBookRepository.save(currentAddressBook, contact);
    System.out.println("Contact added Successfully");
  }

  public void editContactByFirstName(String firstName, Contact updatedContact) {

    validateField(firstName);
    validateContact(updatedContact);

    Contact existingContact = addressBookRepository.findByFirstName(currentAddressBook, firstName);
    if (existingContact == null) {
      throw new IllegalArgumentException("Contact not found with first name: " + firstName);
    }
    addressBookRepository.update(currentAddressBook, updatedContact);
    System.out.println("Contact updated Successfully");
  }

  public void deleteContactByFirstName(String firstName) {
    validateField(firstName);
    Contact existingContact = addressBookRepository.findByFirstName(currentAddressBook, firstName);
    if (existingContact == null) {
      throw new IllegalArgumentException("Contact not found with first name: " + firstName);
    }
    addressBookRepository.delete(currentAddressBook, existingContact);
    System.out.println("Contact deleted Successfully");
  }

  /*
   * Validates the contact details.
   * 
   * @param contact The contact to validate.
   * 
   * @throws IllegalArgumentException if any validation fails.
   */
  private void validateContact(Contact contact) {

    if (contact == null) {
      throw new IllegalArgumentException("Contact cannot be null");
    }
    if (contact.getFirstName() == null || contact.getFirstName().isEmpty()) {
      throw new IllegalArgumentException("First name cannot be empty");
    }
  }

  /*
   * Validates a single field.
   * 
   * @param fieldValue The value of the field to validate.
   * 
   * @param fieldName The name of the field (for error messages).
   * 
   * @throws IllegalArgumentException if the field is null or empty.
   */

  private void validateField(String fieldValue) {
    if (fieldValue == null || fieldValue.isEmpty()) {
      throw new IllegalArgumentException(fieldValue + " cannot be empty.");
    }
  }

}