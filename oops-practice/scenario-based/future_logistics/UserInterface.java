package future_logistics;

import java.util.Scanner;

public class UserInterface {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the Goods Transport details");
    String input = sc.nextLine();

    Utility util = new Utility();

    String[] parts = input.split(":");
    String transportId = parts.length > 0 ? parts[0].trim() : "";

    if (!util.validateTransportId(transportId)) {
      sc.close();
      return;
    }

    GoodsTransport goods = util.parseDetails(input);
    if (goods == null) {
      sc.close();
      return;
    }

    String type = util.findObjectType(goods);
    if ("BrickTransport".equals(type)) {
      BrickTransport bt = (BrickTransport) goods;
      System.out.println("Transporter id : " + bt.getTransportId());
      System.out.println("Date of transport : " + bt.getTransportDate());
      System.out.println("Rating of the transport : " + bt.getTransportRating());
      System.out.println("Quantity of bricks : " + bt.getBrickQuantity());
      System.out.println("Brick price : " + bt.getBrickPrice());
      System.out.println("Vehicle for transport : " + bt.vehicleSelection());
      System.out.println("Total charge : " + bt.calculateTotalCharge());
    } else if ("TimberTransport".equals(type)) {
      TimberTransport tt = (TimberTransport) goods;
      System.out.println("Transporter id : " + tt.getTransportId());
      System.out.println("Date of transport : " + tt.getTransportDate());
      System.out.println("Rating of the transport : " + tt.getTransportRating());
      System.out.println("Type of the timber : " + tt.getTimberType());
      System.out.println("Timber price per kilo : " + tt.getTimberPrice());
      System.out.println("Vehicle for transport : " + tt.vehicleSelection());
      System.out.println("Total charge : " + tt.calculateTotalCharge());
    }

    sc.close();
  }
}
