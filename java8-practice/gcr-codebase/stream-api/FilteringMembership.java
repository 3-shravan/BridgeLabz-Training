import java.time.LocalDate;
import java.util.Arrays;

class Member {
  private String name;
  private LocalDate membershipExpireDate;

  public Member(String name, LocalDate membershipExpireDate) {
    this.name = name;
    this.membershipExpireDate = membershipExpireDate;
  }

  public String getName() {
    return name;
  }

  public LocalDate getMembershipExpireDate() {
    return membershipExpireDate;
  }

  @Override
  public String toString() {
    return "Member [name=" + name + ", membershipExpireDate=" + membershipExpireDate + "]";
  }

}

public class FilteringMembership {

  public static void main(String[] args) {
    Arrays.asList(
        new Member("Alice", LocalDate.of(2026, 2, 7)),
        new Member("Bob", LocalDate.of(2023, 5, 15)),
        new Member("Charlie", LocalDate.of(2024, 1, 10))).stream()
        .filter(m -> m.getMembershipExpireDate().isAfter(LocalDate.now())
            && m.getMembershipExpireDate().isBefore(LocalDate.now().plusMonths(1)))
        .forEach(System.out::println);
  }
}