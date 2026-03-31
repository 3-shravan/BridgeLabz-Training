package list;

import java.util.ArrayList;
import java.util.List;

public class RotateList {
  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5));
    int k = 2;
    k = k % list.size();
    List<Integer> rotatedList = new ArrayList<>();
    rotatedList.addAll(list.subList(k, list.size()));
    rotatedList.addAll(list.subList(0, k));
    System.out.println(rotatedList);
  }

}
