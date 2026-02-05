import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class LoggingTransactions {
  public static void main(String[] args) {
    List<Integer> transactionIds = Arrays.asList(123, 456, 789, 345, 456, 345, 236, 876);
    transactionIds.forEach(id -> System.out.println(LocalDate.now() + " -> " + id));
  }
}
