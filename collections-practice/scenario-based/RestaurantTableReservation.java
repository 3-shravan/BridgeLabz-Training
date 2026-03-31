import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RestaurantTableReservation {

  public static void main(String[] args) {

    ReservationService service = new ReservationService();

    service.addTable(new Table(1, 4));
    service.addTable(new Table(2, 6));
    service.addTable(new Table(3, 2));

    LocalDateTime start = LocalDateTime.of(2026, 1, 28, 18, 0);
    LocalDateTime end = LocalDateTime.of(2026, 1, 28, 20, 0);

    try {
      service.reserveTable(1, "Rahul", start, end);
      service.reserveTable(1, "Amit", start.plusMinutes(30), end.plusMinutes(30));
    } catch (TableAlreadyReservedException e) {
      System.out.println(e.getMessage());
    }

    service.showAvailableTables(start, end);
    service.cancelReservation(1, start);
    service.showAvailableTables(start, end);
  }

}

class ReservationService {
  Map<Integer, Table> tableMap = new HashMap<>();
  List<Reservation> reservations = new ArrayList<>();

  public void addTable(Table table) {
    tableMap.put(table.getTableNumber(), table);
  }

  public void reserveTable(int tableNumber, String customerName, LocalDateTime startTime, LocalDateTime endTime)
      throws TableAlreadyReservedException {
    for (Reservation reservation : reservations) {
      if (reservation.getTableNumber() == tableNumber && startTime.isBefore(reservation.getEndTime())
          && endTime.isAfter(reservation.getStartTime())) {
        throw new TableAlreadyReservedException("Table " + tableNumber + " is already reserved during this time.");
      }
    }
    reservations.add(new Reservation(tableNumber, customerName, startTime, endTime));
    System.out.println(" Reservation successful for table " + tableNumber);

  }

  public void cancelReservation(int tableNumber, LocalDateTime start) {
    reservations.removeIf(r -> r.getTableNumber() == tableNumber && r.getStartTime().equals(start));
    System.out.println("🗑 Reservation cancelled for table " + tableNumber);
  }

  public void showAvailableTables(LocalDateTime start, LocalDateTime end) {
    Set<Integer> bookedTables = new HashSet<>();

    for (Reservation r : reservations) {
      if (start.isBefore(r.getEndTime()) && end.isAfter(r.getStartTime())) {
        bookedTables.add(r.getTableNumber());
      }
    }

    System.out.println(" Available Tables:");
    for (Table table : tableMap.values()) {
      if (!bookedTables.contains(table.getTableNumber())) {
        System.out.println(table);
      }
    }
  }

}

class TableAlreadyReservedException extends Exception {
  public TableAlreadyReservedException(String message) {
    super(message);
  }
}

class Table {
  private int tableNumber;
  private int capacity;

  public Table(int tableNumber, int capacity) {
    this.tableNumber = tableNumber;
    this.capacity = capacity;
  }

  public int getTableNumber() {
    return tableNumber;
  }

  public int getCapacity() {
    return capacity;
  }

  @Override
  public String toString() {
    return "Table{" + "tableNumber=" + tableNumber + ", capacity=" + capacity + '}';
  }
}

class Reservation {
  private int tableNumber;
  private String customerName;
  private LocalDateTime startTime;
  private LocalDateTime endTime;

  public Reservation(int tableNumber, String customerName, LocalDateTime startTime, LocalDateTime endTime) {
    this.tableNumber = tableNumber;
    this.customerName = customerName;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public int getTableNumber() {
    return tableNumber;
  }

  public String getCustomerName() {
    return customerName;
  }

  public LocalDateTime getStartTime() {
    return startTime;
  }

  public LocalDateTime getEndTime() {
    return endTime;
  }

  @Override
  public String toString() {
    return "Reservaation [tableNumber=" + tableNumber + ", customerName=" + customerName + ", startTime=" + startTime
        + ", endTime=" + endTime + "]";
  }

}
