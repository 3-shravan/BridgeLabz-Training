package list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReverseList {
  public static <T> void reverse(List<T> list) {
    int left = 0, right = list.size() - 1;
    while (left < right) {
      T temp = list.get(left);
      list.set(left, list.get(right));
      list.set(right, temp);
      left++;
      right--;
    }
  }

  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5));
    reverse(numbers);
    System.out.println(numbers);

    List<Integer> linkedList = new LinkedList<>(List.of(1, 2, 3, 4, 5));
    reverse(linkedList);
    System.out.println(linkedList);
  }
}
