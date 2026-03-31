package future_logistics;

public class Utility {

  public GoodsTransport parseDetails(String input) {

    String[] details = input.split(":");

    String transportId = details[0].trim();
    String transportDate = details[1].trim();
    int transportRating = Integer.parseInt(details[2].trim());
    String transportType = details[3].trim();

    if (transportType.equalsIgnoreCase("BrickTransport")) {

      float brickSize = Float.parseFloat(details[4].trim());
      int brickQuantity = Integer.parseInt(details[5].trim());
      float brickPrice = Float.parseFloat(details[6].trim());

      return new BrickTransport(transportId, transportDate, transportRating, brickSize, brickQuantity, brickPrice);

    } else if (transportType.equalsIgnoreCase("TimberTransport")) {

      float timberLength = Float.parseFloat(details[4].trim());
      float timberRadius = Float.parseFloat(details[5].trim());
      String timberType = details[6].trim();
      float timberPrice = Float.parseFloat(details[7].trim());

      return new TimberTransport(transportId, transportDate, transportRating, timberLength, timberRadius, timberType,
          timberPrice);
    }

    return null;
  }

  public boolean validateTransportId(String transportId) {
    String regex = "^[A-Z]{3}\\d{3}[A-Z]$";
    if (!transportId.matches(regex)) {
      System.out.println("Transport id " + transportId + " is invalid");
      System.out.println("Please provide a valid record");
    }
    return transportId.matches(regex);

  }

  public String findObjectType(GoodsTransport goodsTransport) {
    if (goodsTransport instanceof BrickTransport) {
      return "BrickTransport";
    } else if (goodsTransport instanceof TimberTransport) {
      return "TimberTransport";
    }
    return "Unknown Transport Type";
  }
}
