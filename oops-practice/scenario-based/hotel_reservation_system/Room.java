package hotel_reservation_system;

public class Room {

  protected int roomNumber;
  protected double basePrice;
  protected boolean available = true;

  public Room(int roomNumber, double basePrice) {
    this.roomNumber = roomNumber;
    this.basePrice = basePrice;
  }

  public int getRoomNumber() {
    return roomNumber;
  }

  public boolean isAvailable() {
    return available;
  }

  public void book() {
    available = false;
  }

  public void checkout() {
    available = true;
  }
}
