package hotel_reservation_system;

/*
 Connects Guest and Room
*/
public class Reservation {

  private int reservationId;
  private Guest guest;
  private Room room;
  private int days;

  public Reservation(int reservationId, Guest guest, Room room, int days) {
    this.reservationId = reservationId;
    this.guest = guest;
    this.room = room;
    this.days = days;
  }

  public int getReservationId() {
    return reservationId;
  }

  public Room getRoom() {
    return room;
  }

  public int getDays() {
    return days;
  }
}
