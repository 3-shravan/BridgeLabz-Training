package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

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

  public List<Contact> findContactByStateOrCity(String keyword) {

    validateField(keyword);
    List<Contact> results = new ArrayList<>();
    for (AddressBook ab : systemRepository.getAllAddressBooks().values()) {
      List<Contact> contacts = addressBookRepository.findByStateOrCity(ab, keyword);
      if (contacts != null)
        results.addAll(contacts);
    }
    return results;
  }

  public List<Contact> getContactsByState(String state) {
    validateField(state);
    List<Contact> results = new ArrayList<>();
    for (AddressBook ab : systemRepository.getAllAddressBooks().values()) {
      List<Contact> contacts = addressBookRepository.getContactsByState(ab, state);
      if (contacts != null)
        results.addAll(contacts);
    }
    return results;
  }

  public List<Contact> getContactsByCity(String city) {
    validateField(city);
    List<Contact> results = new ArrayList<>();
    for (AddressBook ab : systemRepository.getAllAddressBooks().values()) {
      List<Contact> contacts = addressBookRepository.getContactsByCity(ab, city);
      if (contacts != null)
        results.addAll(contacts);
    }
    return results;
  }

  public int totalContactsCountByCity(String city) {
    validateField(city);
    int count = 0;
    for (AddressBook ab : systemRepository.getAllAddressBooks().values()) {
      count += addressBookRepository.totalContactsCountByCity(ab, city);

    }
    return count;
  }

  public int totalContactsCountByState(String state) {
    validateField(state);
    int count = 0;
    for (AddressBook ab : systemRepository.getAllAddressBooks().values()) {
      count += addressBookRepository.totalContactsCountByState(ab, state);

    }
    return count;
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

  public void showContactsSortedByName() {
    List<Contact> sortedContacts = addressBookRepository.getContactsSortedByName(currentAddressBook);
    if (sortedContacts == null || sortedContacts.isEmpty()) {
      System.out.println("No contacts found.");
      return;
    }

    System.out.println("Contacts sorted alphabetically by person name:");
    sortedContacts.forEach(System.out::println);
  }

  public void showContactsSortedByCity() {
    List<Contact> sortedContacts = addressBookRepository.getContactsSortedByCity(currentAddressBook);
    if (sortedContacts == null || sortedContacts.isEmpty()) {
      System.out.println("No contacts found.");
      return;
    }

    System.out.println("Contacts sorted by city:");
    sortedContacts.forEach(System.out::println);
  }

  public void showContactsSortedByState() {
    List<Contact> sortedContacts = addressBookRepository.getContactsSortedByState(currentAddressBook);
    if (sortedContacts == null || sortedContacts.isEmpty()) {
      System.out.println("No contacts found.");
      return;
    }

    System.out.println("Contacts sorted by state:");
    sortedContacts.forEach(System.out::println);
  }

  public void showContactsSortedByZip() {
    List<Contact> sortedContacts = addressBookRepository.getContactsSortedByZip(currentAddressBook);
    if (sortedContacts == null || sortedContacts.isEmpty()) {
      System.out.println("No contacts found.");
      return;
    }

    System.out.println("Contacts sorted by zip:");
    sortedContacts.forEach(System.out::println);
  }

  public void writeCurrentAddressBookToFile(String filePath) {
    validateField(filePath);
    Path path = Paths.get(filePath);
    try {
      Path parent = path.getParent();
      if (parent != null) {
        Files.createDirectories(parent);
      }

      List<String> lines = new ArrayList<>();
      lines.add("firstName,lastName,address,city,state,zip,phoneNumber,email");

      currentAddressBook.getContacts()
          .stream()
          .map(this::toCsvLine)
          .forEach(lines::add);

      Files.write(path, lines, StandardCharsets.UTF_8);
      System.out.println("Address Book written successfully to file: " + filePath);
    } catch (IOException e) {
      throw new IllegalStateException("Failed to write Address Book to file: " + e.getMessage());
    }
  }

  public void readContactsFromFile(String filePath) {
    validateField(filePath);
    Path path = Paths.get(filePath);

    if (!Files.exists(path)) {
      throw new IllegalArgumentException("File not found: " + filePath);
    }

    try {
      List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
      if (lines.isEmpty()) {
        currentAddressBook.getContacts().clear();
        System.out.println("File is empty. Address Book cleared.");
        return;
      }

      List<Contact> loadedContacts = new ArrayList<>();
      for (int i = 0; i < lines.size(); i++) {
        String line = lines.get(i);
        if (line == null || line.isBlank()) {
          continue;
        }

        if (i == 0 && line.trim().equalsIgnoreCase("firstName,lastName,address,city,state,zip,phoneNumber,email")) {
          continue;
        }

        List<String> values = parseCsvLine(line);
        if (values.size() != 8) {
          throw new IllegalArgumentException("Invalid file format at line " + (i + 1));
        }

        loadedContacts.add(new Contact(
            values.get(0),
            values.get(1),
            values.get(2),
            values.get(3),
            values.get(4),
            values.get(5),
            values.get(6),
            values.get(7)));
      }

      currentAddressBook.getContacts().clear();
      currentAddressBook.getContacts().addAll(loadedContacts);
      System.out.println("Address Book loaded successfully from file. Total contacts: " + loadedContacts.size());
    } catch (IOException e) {
      throw new IllegalStateException("Failed to read Address Book from file: " + e.getMessage());
    }
  }

  public void writeCurrentAddressBookToCsvUsingOpenCsv(String filePath) {
    validateField(filePath);
    Path path = Paths.get(filePath);

    try {
      Path parent = path.getParent();
      if (parent != null) {
        Files.createDirectories(parent);
      }

      try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
          CSVWriter csvWriter = new CSVWriter(bufferedWriter)) {

        csvWriter.writeNext(new String[] { "firstName", "lastName", "address", "city", "state", "zip", "phoneNumber",
            "email" });

        currentAddressBook.getContacts().forEach(contact -> csvWriter.writeNext(new String[] {
            contact.getFirstName(),
            contact.getLastName(),
            contact.getAddress(),
            contact.getCity(),
            contact.getState(),
            contact.getZip(),
            contact.getPhoneNumber(),
            contact.getEmail() }));
      }

      System.out.println("Address Book CSV written successfully using OpenCSV: " + filePath);
    } catch (IOException e) {
      throw new IllegalStateException("Failed to write CSV file using OpenCSV: " + e.getMessage());
    }
  }

  public void readContactsFromCsvUsingOpenCsv(String filePath) {
    validateField(filePath);
    Path path = Paths.get(filePath);

    if (!Files.exists(path)) {
      throw new IllegalArgumentException("File not found: " + filePath);
    }

    try (BufferedReader bufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
        CSVReader csvReader = new CSVReader(bufferedReader)) {

      List<Contact> loadedContacts = new ArrayList<>();
      String[] row;
      boolean isHeader = true;

      while ((row = csvReader.readNext()) != null) {
        if (row.length == 0 || (row.length == 1 && row[0].isBlank())) {
          continue;
        }

        if (isHeader && row.length == 8 && "firstName".equalsIgnoreCase(row[0])) {
          isHeader = false;
          continue;
        }
        isHeader = false;

        if (row.length != 8) {
          throw new IllegalArgumentException("Invalid CSV format. Each row must contain exactly 8 columns.");
        }

        loadedContacts.add(new Contact(
            row[0],
            row[1],
            row[2],
            row[3],
            row[4],
            row[5],
            row[6],
            row[7]));
      }

      currentAddressBook.getContacts().clear();
      currentAddressBook.getContacts().addAll(loadedContacts);
      System.out.println("Address Book CSV loaded successfully using OpenCSV. Total contacts: " + loadedContacts.size());
    } catch (IOException | CsvValidationException e) {
      throw new IllegalStateException("Failed to read CSV file using OpenCSV: " + e.getMessage());
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

  private String toCsvLine(Contact contact) {
    return Stream.of(
        contact.getFirstName(),
        contact.getLastName(),
        contact.getAddress(),
        contact.getCity(),
        contact.getState(),
        contact.getZip(),
        contact.getPhoneNumber(),
        contact.getEmail())
        .map(this::escapeCsv)
        .collect(Collectors.joining(","));
  }

  private String escapeCsv(String value) {
    if (value == null) {
      return "";
    }

    String escaped = value.replace("\"", "\"\"");
    if (escaped.contains(",") || escaped.contains("\"") || escaped.contains("\n") || escaped.contains("\r")) {
      return "\"" + escaped + "\"";
    }
    return escaped;
  }

  private List<String> parseCsvLine(String line) {
    List<String> values = new ArrayList<>();
    StringBuilder current = new StringBuilder();
    boolean inQuotes = false;

    for (int i = 0; i < line.length(); i++) {
      char ch = line.charAt(i);
      if (ch == '"') {
        if (inQuotes && i + 1 < line.length() && line.charAt(i + 1) == '"') {
          current.append('"');
          i++;
        } else {
          inQuotes = !inQuotes;
        }
      } else if (ch == ',' && !inQuotes) {
        values.add(current.toString());
        current.setLength(0);
      } else {
        current.append(ch);
      }
    }

    values.add(current.toString());
    return values;
  }

}