package repository;

import entity.Contact;

public class AddressBookRepository {

  private Contact contact;

  public void save(Contact contact) {
    this.contact = contact;
  }

}
