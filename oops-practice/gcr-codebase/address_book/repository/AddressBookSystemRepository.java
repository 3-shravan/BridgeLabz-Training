package repository;

import java.util.HashMap;
import java.util.Map;

import entity.AddressBook;

public class AddressBookSystemRepository {
  private final Map<String, AddressBook> addressBooks = new HashMap<>();

  public AddressBookSystemRepository() {
    addressBooks.put("Default", new AddressBook("Default"));
  }

  public AddressBook getDefaultAddressBook() {
    return addressBooks.get("Default");
  }

  public AddressBook getAddressBook(String name) {
    return addressBooks.get(name);
  }

  public Map<String, AddressBook> getAllAddressBooks() {
    return addressBooks;
  }

  public void addAddressBook(String name) {
    if (addressBooks.containsKey(name)) {
      throw new IllegalArgumentException("Address Book with name " + name + " already exists.");
    }
    addressBooks.put(name, new AddressBook(name));
  }
}
