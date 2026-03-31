public class MobilePhoneDetails {
  String brand;
  String model;
  double price;

  MobilePhoneDetails(String brand, String model, double price) {
    this.brand = brand;
    this.model = model;
    this.price = price;
  }

  void displayDetails() {
    System.out.println("Brand of mobile: " + brand);
    System.out.println("Model of mobile: " + model);
    System.out.println("Price of mobile: " + price);
  }

  public static void main(String[] args) {
    MobilePhoneDetails phone1 = new MobilePhoneDetails("Apple", "iPhone 13", 999.99);
    MobilePhoneDetails phone2 = new MobilePhoneDetails("Samsung", "Galaxy S21", 799.99);

    phone1.displayDetails();
    System.out.println();
    phone2.displayDetails();
  }

}
