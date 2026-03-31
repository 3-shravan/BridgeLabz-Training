package hotel_reservation_system;

/*
 Seasonal pricing adds extra charge.
*/
public class SeasonalPricing implements PricingStrategy {

    @Override
    public double calculatePrice(double basePrice, int days) {
        return basePrice * days * 1.2;
    }
}
