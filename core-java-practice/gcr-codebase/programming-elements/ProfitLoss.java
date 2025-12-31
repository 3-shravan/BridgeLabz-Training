public class ProfitLoss {
  public static void main(String[] args) {
    int costPrice = 129;
    int sellingPrice = 191;
    int profit = sellingPrice - costPrice;
    float profitPercentage = (profit / (float) costPrice) * 100.0f;

    System.out.println("the Cost price is INR " + costPrice + " and selling price is INR " + sellingPrice
        + " The Profit is INR " + profit + " and the Profit Percentage is " + profitPercentage);

  }
}
