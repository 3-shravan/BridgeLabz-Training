package future_logistics;

public class TimberTransport extends GoodsTransport {

  private float timberLength;
  private float timberRadius;
  private String timberType;
  private float timberPrice;

  public float getTimberLength() {
    return timberLength;
  }

  public void setTimberLength(float timberLength) {
    this.timberLength = timberLength;
  }

  public float getTimberRadius() {
    return timberRadius;
  }

  public void setTimberRadius(float timberRadius) {
    this.timberRadius = timberRadius;
  }

  public String getTimberType() {
    return timberType;
  }

  public void setTimberType(String timberType) {
    this.timberType = timberType;
  }

  public float getTimberPrice() {
    return timberPrice;
  }

  public void setTimberPrice(float timberPrice) {
    this.timberPrice = timberPrice;
  }

  public TimberTransport(String transportId, String transportDate, int transportRating, float timberLength,
      float timberRadius, String timberType, float timberPrice) {
    super(transportId, transportDate, transportRating);
    this.timberLength = timberLength;
    this.timberRadius = timberRadius;
    this.timberType = timberType;
    this.timberPrice = timberPrice;
  }

  private float calculateArea() {
    return 2 * 3.147f * getTimberRadius() * getTimberLength();
  }

  @Override
  public String vehicleSelection() {
    float area = calculateArea();
    if (area < 250) {
      return "Truck";
    } else if (area >= 250 && area <= 400) {
      return "Lorry";
    } else {
      return "MonsterLorry";
    }
  }

  private float calculateTimberVolume() {
    return 3.147f * getTimberRadius() * getTimberRadius() * getTimberLength();
  }

  private float getVehiclePrice() {
    switch (vehicleSelection().toLowerCase()) {
    case "truck":
      return 1000;
    case "lorry":
      return 1700;
    case "monsterlorry":
      return 3000;
    }
    return 0;
  }

  private float calculateDiscount(float totalTimberCost) {
    int rating = getTransportRating();
    if (rating < 0 || rating > 5) {
      System.out.println("Invalid Rating");
      return 0.0f;
    }
    float discount = 0.0f;
    if (rating == 5) {
      discount = 0.2f * totalTimberCost;
    } else if (rating == 4 || rating == 3) {
      discount = 0.1f * totalTimberCost;
    }
    return discount;
  }

  @Override
  public float calculateTotalCharge() {

    float volume = calculateTimberVolume();

    float rate = getTimberType().equalsIgnoreCase("Premium") ? 0.25f : 0.15f;

    float price = volume * getTimberPrice() * rate;
    float tax = price * 0.3f;
    float discount = calculateDiscount(price);

    return price + getVehiclePrice() + tax - discount;
  }

}
