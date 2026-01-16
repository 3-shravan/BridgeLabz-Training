package service;

import entity.Contact;
import repository.AddressBookRepository;

public class AddressBookService {

  private final AddressBookRepository addressBookRepository;

  public AddressBookService() {
    this.addressBookRepository = new AddressBookRepository();
  }

  public void addContact(Contact contact) {
    if (contact == null) {
      System.out.println("Invalid contact details");
      return;
    }
    addressBookRepository.save(contact);
    System.out.println("Contact added Successfully");
  }

}
