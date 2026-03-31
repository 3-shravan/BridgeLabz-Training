import java.util.Arrays;
import java.util.stream.Collectors;

class InsuranceClaim {
  String claimType;
  double amount;

  public InsuranceClaim(String claimType, double amount) {
    this.claimType = claimType;
    this.amount = amount;
  }

  public String getClaimType() {
    return claimType;
  }

  public double getAmount() {
    return amount;
  }

  @Override
  public String toString() {
    return "InsuranceClaim [claimType=" + claimType + ", amount=" + amount + "]";
  }

}

public class InsuranceClaimAnalysis {

  public static void main(String[] args) {

    Arrays.asList(
        new InsuranceClaim("Health", 5000),
        new InsuranceClaim("Auto", 3000),
        new InsuranceClaim("Home", 7000),
        new InsuranceClaim("Health", 2000),
        new InsuranceClaim("Auto", 4000))
        .stream()
        .collect(Collectors.groupingBy(InsuranceClaim::getClaimType,
            Collectors.averagingDouble(InsuranceClaim::getAmount)))
        .forEach((claimType, avgAmount) -> System.out.println(claimType + ": " + avgAmount));

  }
}