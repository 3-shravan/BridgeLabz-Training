package policy_system;

import java.time.LocalDate;
import java.util.Objects;

public class Policy {

  private int policyNumber;
  private String policyHolderName;
  private LocalDate expiryDate;
  private String coverageType;
  private double premiumAmount;

  public Policy(int policyNumber, String policyHolderName, LocalDate expiryDate, String coverageType,
      double premiumAmount) {
    this.policyNumber = policyNumber;
    this.policyHolderName = policyHolderName;
    this.expiryDate = expiryDate;
    this.coverageType = coverageType;
    this.premiumAmount = premiumAmount;
  }

  public int getPolicyNumber() {
    return policyNumber;
  }

  public LocalDate getExpiryDate() {
    return expiryDate;
  }

  public String getCoverageType() {
    return coverageType;
  }

  public String getPolicyHolderName() {
    return policyHolderName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Policy))
      return false;
    Policy policy = (Policy) o;
    return policyNumber == policy.policyNumber;
  }

  @Override
  public int hashCode() {
    return Objects.hash(policyNumber);
  }

  @Override
  public String toString() {
    return "Policy{" + "policyNumber=" + policyNumber + ", holder='" + policyHolderName + '\'' + ", expiry="
        + expiryDate + ", coverage='" + coverageType + '\'' + ", premium=" + premiumAmount + '}';
  }

}