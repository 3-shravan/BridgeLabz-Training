package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import entity.AddressBook;
import entity.Contact;
import repository.AddressBookRepository;
import repository.AddressBookSystemRepository;

public class AddressBookService {

  private final AddressBookSystemRepository systemRepository = new AddressBookSystemRepository();
  private final AddressBookRepository addressBookRepository = new AddressBookRepository();
  private AddressBook currentAddressBook;
  private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
  private static final HttpClient HTTP_CLIENT = HttpClient.newHttpClient();

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

  public void writeCurrentAddressBookToJsonUsingGson(String filePath) {
    validateField(filePath);
    Path path = Paths.get(filePath);

    try {
      Path parent = path.getParent();
      if (parent != null) {
        Files.createDirectories(parent);
      }

      try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
        GSON.toJson(currentAddressBook.getContacts(), writer);
      }

      System.out.println("Address Book JSON written successfully using Gson: " + filePath);
    } catch (IOException e) {
      throw new IllegalStateException("Failed to write JSON file using Gson: " + e.getMessage());
    }
  }

  public void readContactsFromJsonUsingGson(String filePath) {
    validateField(filePath);
    Path path = Paths.get(filePath);

    if (!Files.exists(path)) {
      throw new IllegalArgumentException("File not found: " + filePath);
    }

    try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
      Type contactListType = new TypeToken<List<Contact>>() {
      }.getType();

      List<Contact> loadedContacts = GSON.fromJson(reader, contactListType);
      if (loadedContacts == null) {
        loadedContacts = new ArrayList<>();
      }

      currentAddressBook.getContacts().clear();
      currentAddressBook.getContacts().addAll(loadedContacts);

      System.out.println("Address Book JSON loaded successfully using Gson. Total contacts: " + loadedContacts.size());
    } catch (IOException e) {
      throw new IllegalStateException("Failed to read JSON file using Gson: " + e.getMessage());
    } catch (Exception e) {
      throw new IllegalStateException("Invalid JSON format: " + e.getMessage());
    }
  }

  public void writeCurrentAddressBookToJsonServer(String apiUrl) {
    validateField(apiUrl);
    String normalizedApiUrl = normalizeApiUrl(apiUrl);

    try {
      HttpRequest fetchRequest = HttpRequest.newBuilder()
          .uri(URI.create(normalizedApiUrl))
          .GET()
          .build();

      HttpResponse<String> fetchResponse = HTTP_CLIENT.send(fetchRequest, HttpResponse.BodyHandlers.ofString());

      if (fetchResponse.statusCode() < 200 || fetchResponse.statusCode() >= 300) {
        throw new IllegalStateException("Unable to reach JSON Server. HTTP status: " + fetchResponse.statusCode());
      }

      JsonArray existingRecords = GSON.fromJson(fetchResponse.body(), JsonArray.class);
      if (existingRecords != null) {
        for (JsonElement record : existingRecords) {
          if (record != null && record.isJsonObject()) {
            JsonObject object = record.getAsJsonObject();
            JsonElement idElement = object.get("id");
            if (idElement != null && !idElement.isJsonNull()) {
              String deleteUrl = normalizedApiUrl + "/" + idElement.getAsString();
              HttpRequest deleteRequest = HttpRequest.newBuilder()
                  .uri(URI.create(deleteUrl))
                  .DELETE()
                  .build();
              HTTP_CLIENT.send(deleteRequest, HttpResponse.BodyHandlers.ofString());
            }
          }
        }
      }

      for (Contact contact : currentAddressBook.getContacts()) {
        String payload = GSON.toJson(contact);
        HttpRequest postRequest = HttpRequest.newBuilder()
            .uri(URI.create(normalizedApiUrl))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(payload, StandardCharsets.UTF_8))
            .build();

        HttpResponse<String> postResponse = HTTP_CLIENT.send(postRequest, HttpResponse.BodyHandlers.ofString());
        if (postResponse.statusCode() < 200 || postResponse.statusCode() >= 300) {
          throw new IllegalStateException("Failed to write contact to JSON Server. HTTP status: " + postResponse.statusCode());
        }
      }

      System.out.println("Address Book written successfully to JSON Server: " + normalizedApiUrl);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new IllegalStateException("Failed to write Address Book to JSON Server: " + e.getMessage());
    } catch (IOException e) {
      throw new IllegalStateException("Failed to write Address Book to JSON Server: " + e.getMessage());
    }
  }

  public void readContactsFromJsonServer(String apiUrl) {
    validateField(apiUrl);
    String normalizedApiUrl = normalizeApiUrl(apiUrl);

    try {
      HttpRequest request = HttpRequest.newBuilder()
          .uri(URI.create(normalizedApiUrl))
          .GET()
          .build();

      HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

      if (response.statusCode() < 200 || response.statusCode() >= 300) {
        throw new IllegalStateException("Failed to read from JSON Server. HTTP status: " + response.statusCode());
      }

      Type contactListType = new TypeToken<List<Contact>>() {
      }.getType();
      List<Contact> serverContacts = GSON.fromJson(response.body(), contactListType);
      if (serverContacts == null) {
        serverContacts = new ArrayList<>();
      }

      currentAddressBook.getContacts().clear();
      currentAddressBook.getContacts().addAll(serverContacts);

      System.out.println("Address Book loaded successfully from JSON Server. Total contacts: " + serverContacts.size());
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new IllegalStateException("Failed to read Address Book from JSON Server: " + e.getMessage());
    } catch (IOException e) {
      throw new IllegalStateException("Failed to read Address Book from JSON Server: " + e.getMessage());
    } catch (Exception e) {
      throw new IllegalStateException("Invalid JSON response from JSON Server: " + e.getMessage());
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

  private String normalizeApiUrl(String apiUrl) {
    String trimmed = apiUrl.trim();
    if (trimmed.endsWith("/")) {
      return trimmed.substring(0, trimmed.length() - 1);
    }
    return trimmed;
  }

}