public class CarRentalSystem {
  private String customerName;
  private String carModel;
  private int rentalDays;
  private double totalCost;

  public CarRentalSystem(String customerName, String carModel, int rentalDays) {
    this.customerName = customerName;
    this.carModel = carModel;
    this.rentalDays = rentalDays;
    this.totalCost = calculateTotalCost();
  }

  private double calculateTotalCost() {
    double dailyRate;
    switch (carModel.toLowerCase()) {
      case "sedan":
        dailyRate = 50.0;
        break;
      case "suv":
        dailyRate = 80.0;
        break;
      case "convertible":
        dailyRate = 100.0;
        break;
      default:
        dailyRate = 40.0;
        break;
    }

    return dailyRate * rentalDays;
  }

  public static void main(String[] args) {

    CarRentalSystem rental1 = new CarRentalSystem("Alice", "SUV", 3);
    System.out.println("Customer: " + rental1.customerName);
    System.out.println("Car Model: " + rental1.carModel);
    System.out.println("Rental Days: " + rental1.rentalDays);
    System.out.println("Total Cost: $" + rental1.totalCost);
  }
}
