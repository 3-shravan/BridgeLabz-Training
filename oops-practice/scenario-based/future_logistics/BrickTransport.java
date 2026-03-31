package future_logistics;

public class BrickTransport extends GoodsTransport {

  private float brickSize;
  private int brickQuantity;
  private float brickPrice;

  public BrickTransport(String transportId, String transportDate, int transportRating, float brickSize,
      int brickQuantity, float brickPrice) {
    super(transportId, transportDate, transportRating);
    this.brickSize = brickSize;
    this.brickQuantity = brickQuantity;
    this.brickPrice = brickPrice;
  }

  public float getBrickSize() {
    return brickSize;
  }

  public void setBrickSize(float brickSize) {
    this.brickSize = brickSize;
  }

  public int getBrickQuantity() {
    return brickQuantity;
  }

  public void setBrickQuantity(int brickQuantity) {
    this.brickQuantity = brickQuantity;
  }

  public float getBrickPrice() {
    return brickPrice;
  }

  public void setBrickPrice(float brickPrice) {
    this.brickPrice = brickPrice;
  }

  @Override
  public String vehicleSelection() {
    if (getBrickQuantity() < 300) {
      return "Truck";
    } else if (getBrickQuantity() >= 300 && getBrickQuantity() <= 500) {
      return "Lorry";
    } else {
      return "MonsterLorry";
    }
  }

  @Override
  public float calculateTotalCharge() {
    float totalBrickCost = getBrickPrice() * getBrickQuantity();
    String vehicleType = vehicleSelection();
    float vehiclePrice = 0;

    switch (vehicleType.toLowerCase()) {
    case "truck":
      vehiclePrice = 1000;
      break;
    case "lorry":
      vehiclePrice = 1700;
      break;
    case "monsterlorry":
      vehiclePrice = 3000;
      break;
    }

    float tax = 0.3f * totalBrickCost;
    float discount = calculateDiscount(totalBrickCost);

    return totalBrickCost + vehiclePrice + tax - discount;
  }

  private float calculateDiscount(float totalBrickCost) {
    int rating = getTransportRating();
    if (rating < 0 || rating > 5) {
      System.out.println("Invalid Rating");
      return 0.0f;
    }
    float discount = 0.0f;
    if (rating == 5) {
      discount = 0.2f * totalBrickCost;
    } else if (rating == 4 || rating == 3) {
      discount = 0.1f * totalBrickCost;
    }
    return discount;
  }

}
