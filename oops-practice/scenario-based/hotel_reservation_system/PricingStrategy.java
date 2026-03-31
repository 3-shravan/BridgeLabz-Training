package hotel_reservation_system;

public interface PricingStrategy {
    double calculatePrice(double basePrice, int days);
}
