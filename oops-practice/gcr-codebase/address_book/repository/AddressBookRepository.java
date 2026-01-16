package repository;

import entity.Contact;

public class AddressBookRepository {

  private Contact contact;

  public void save(Contact contact) {
    this.contact = contact;
  }

  public Contact findByFirstName(String firstName) {
    if (contact != null && contact.getFirstName().equalsIgnoreCase(firstName)) {
      return contact;
    }
    return null;
  }

  public void update(Contact contact) {
    this.contact = contact;
  }
}
