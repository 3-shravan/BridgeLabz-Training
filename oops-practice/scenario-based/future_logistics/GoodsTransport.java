package future_logistics;

public abstract class GoodsTransport {

  private String transportId;
  private String transportDate;
  private int transportRating;

  public String getTransportId() {
    return transportId;
  }

  public void setTransportId(String transportId) {
    this.transportId = transportId;
  }

  public String getTransportDate() {
    return transportDate;
  }

  public void setTransportDate(String transportDate) {
    this.transportDate = transportDate;
  }

  public int getTransportRating() {
    return transportRating;
  }

  public void setTransportRating(int transportRating) {
    this.transportRating = transportRating;
  }

  public GoodsTransport(String transportId, String transportDate, int transportRating) {
    this.transportId = transportId;
    this.transportDate = transportDate;
    this.transportRating = transportRating;
  }

  abstract public String vehicleSelection();
  abstract public float calculateTotalCharge();
}
