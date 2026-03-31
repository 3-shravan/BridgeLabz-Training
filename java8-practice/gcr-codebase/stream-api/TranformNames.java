import java.util.List;

public class TranformNames {
  public static void main(String[] args) {

    List.of("Shravan", "Anne", "Jack").stream().map(String::toUpperCase).sorted()
        .forEach(System.out::println);

  }
}
