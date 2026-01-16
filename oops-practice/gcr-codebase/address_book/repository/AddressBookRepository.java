package repository;

import java.util.ArrayList;
import java.util.List;

import entity.Contact;

public class AddressBookRepository {

  private final List<Contact> contacts = new ArrayList<>();

  public void save(Contact contact) {
    contacts.add(contact);
  }

  public List<Contact> getContacts() {
    return contacts;
  }

  public Contact findByFirstName(String firstName) {
    for (Contact contact : contacts) {
      if (contact != null && contact.getFirstName().equalsIgnoreCase(firstName)) {
        return contact;
      }
    }
    return null;
  }

  public void update(Contact contact) {
    for (int i = 0; i < contacts.size(); i++) {
      if (contacts.get(i).getFirstName().equalsIgnoreCase(contact.getFirstName())) {
        contacts.set(i, contact);
        return;
      }
    }
  }

  public void delete(Contact contact) {
    contacts.removeIf(c -> c.getFirstName().equalsIgnoreCase(contact.getFirstName()));
  }

}
