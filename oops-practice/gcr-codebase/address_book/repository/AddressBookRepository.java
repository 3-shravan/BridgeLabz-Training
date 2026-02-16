package repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import entity.AddressBook;
import entity.Contact;

public class AddressBookRepository {

  public void save(AddressBook addressBook, Contact contact) {
    addressBook.getContacts().add(contact);
  }

  public boolean isContactExists(AddressBook addressBook, Contact contact) {
    for (Contact existingContact : addressBook.getContacts()) {
      if (existingContact.getFirstName().equalsIgnoreCase(contact.getFirstName())) {
        return true;
      }
    }
    return false;
  }

  public List<Contact> getContacts(AddressBook addressBook) {
    return addressBook.getContacts();
  }

  public List<Contact> getContactsSortedByName(AddressBook addressBook) {
    return addressBook.getContacts()
        .stream()
        .sorted(Comparator.comparing(Contact::getFullName, String.CASE_INSENSITIVE_ORDER))
        .collect(Collectors.toList());
  }

  public List<Contact> getContactsSortedByCity(AddressBook addressBook) {
    return addressBook.getContacts()
        .stream()
        .sorted(Comparator.comparing(Contact::getCity, String.CASE_INSENSITIVE_ORDER)
            .thenComparing(Contact::getFullName, String.CASE_INSENSITIVE_ORDER))
        .collect(Collectors.toList());
  }

  public List<Contact> getContactsSortedByState(AddressBook addressBook) {
    return addressBook.getContacts()
        .stream()
        .sorted(Comparator.comparing(Contact::getState, String.CASE_INSENSITIVE_ORDER)
            .thenComparing(Contact::getFullName, String.CASE_INSENSITIVE_ORDER))
        .collect(Collectors.toList());
  }

  public List<Contact> getContactsSortedByZip(AddressBook addressBook) {
    return addressBook.getContacts()
        .stream()
        .sorted(Comparator.comparing(Contact::getZip, String.CASE_INSENSITIVE_ORDER)
            .thenComparing(Contact::getFullName, String.CASE_INSENSITIVE_ORDER))
        .collect(Collectors.toList());
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

  public List<Contact> findByStateOrCity(AddressBook addressBook, String keyword) {
    List<Contact> results = new ArrayList<>();
    for (Contact contact : addressBook.getContacts()) {
      if (contact.getCity().contains(keyword) || contact.getState().contains(keyword)) {
        results.add(contact);
      }
    }
    return results;
  }

  public List<Contact> getContactsByState(AddressBook addressBook, String state) {

    List<Contact> results = new ArrayList<>();
    for (Contact contact : addressBook.getContacts()) {
      if (contact.getState().equalsIgnoreCase(state)) {
        results.add(contact);
      }
    }
    return results;
  }

  public List<Contact> getContactsByCity(AddressBook addressBook, String city) {
    List<Contact> results = new ArrayList<>();
    for (Contact contact : addressBook.getContacts()) {
      if (contact.getCity().equalsIgnoreCase(city)) {
        results.add(contact);
      }
    }
    return results;
  }

  public int totalContactsCountByCity(AddressBook addressBook, String city) {
    int count = 0;
    for (Contact contact : addressBook.getContacts()) {
      if (contact.getCity().equalsIgnoreCase(city)) {
        count++;
      }
    }
    return count;
  }

  public int totalContactsCountByState(AddressBook addressBook, String state) {
    int count = 0;
    for (Contact contact : addressBook.getContacts()) {
      if (contact.getState().equalsIgnoreCase(state)) {
        count++;
      }
    }
    return count;
  }

}
