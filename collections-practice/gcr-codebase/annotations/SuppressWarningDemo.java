import java.util.ArrayList;

public class SuppressWarningDemo {
  @SuppressWarnings("unchecked")
  public static void main(String[] args) {

    @SuppressWarnings("rawtypes")
    ArrayList list = new ArrayList();

    list.add("Java");
    list.add(100);
    list.add(3.14);

    for (Object obj : list) {
      System.out.println(obj);
    }
  }

}
