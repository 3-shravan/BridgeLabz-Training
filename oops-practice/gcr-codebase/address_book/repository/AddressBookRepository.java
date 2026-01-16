package repository;

import java.util.List;

import entity.AddressBook;
import entity.Contact;

public class AddressBookRepository {

  public void save(AddressBook addressBook, Contact contact) {
    addressBook.getContacts().add(contact);
  }

  public List<Contact> getContacts(AddressBook addressBook) {
    return addressBook.getContacts();
  }

  public Contact findByFirstName(AddressBook addressBook, String firstName) {
    for (Contact contact : addressBook.getContacts()) {
      if (contact != null && contact.getFirstName().equalsIgnoreCase(firstName)) {
        return contact;
      }
    }
    return null;
  }

  public void update(AddressBook addressBook, Contact contact) {
    for (int i = 0; i < addressBook.getContacts().size(); i++) {
      if (addressBook.getContacts().get(i).getFirstName().equalsIgnoreCase(contact.getFirstName())) {
        addressBook.getContacts().set(i, contact);
        return;
      }
    }
  }

  public void delete(AddressBook addressBook, Contact contact) {
    addressBook.getContacts().removeIf(c -> c.getFirstName().equalsIgnoreCase(contact.getFirstName()));
  }

}
