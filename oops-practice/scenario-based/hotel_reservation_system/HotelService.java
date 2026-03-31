package hotel_reservation_system;

import java.util.*;

/*
 Service manages rooms and reservations.
*/
public class HotelService {

    private Map<Integer, Room> rooms = new HashMap<>();
    private Map<Integer, Reservation> reservations = new HashMap<>();
    private int reservationCounter = 1;

    private PricingStrategy pricing = new SeasonalPricing();

    public void addRoom(Room room) {
        rooms.put(room.getRoomNumber(), room);
        System.out.println("Room added.");
    }

    public void bookRoom(int roomNo, Guest guest, int days) throws RoomNotAvailableException {

        Room room = rooms.get(roomNo);

        if (!room.isAvailable()) {
            throw new RoomNotAvailableException("Room not available");
        }

        room.book();
        Reservation r = new Reservation(reservationCounter++, guest, room, days);
        reservations.put(r.getReservationId(), r);

        System.out.println("Room booked. Reservation ID: " + r.getReservationId());
    }

    public void checkout(int reservationId) {

        Reservation r = reservations.get(reservationId);
        Room room = r.getRoom();
        room.checkout();

        double bill = pricing.calculatePrice(room.basePrice, r.getDays());

        System.out.println("Checkout complete.");
        System.out.println("Total Bill: ₹" + bill);
    }

    public void viewRooms() {
        for (Room r : rooms.values()) {
            System.out.println("Room " + r.getRoomNumber() + " | Available: " + r.isAvailable());
        }
    }
}
