package com.shravan;

import java.util.List;

public class ListManager {

  public static void addElement(List<Integer> list, int element) {
    if (list == null) {
      throw new IllegalArgumentException("List cannot be null");
    }
    list.add(element);
  }

  public static boolean removeElement(List<Integer> list, int element) {
    if (list == null) {
      throw new IllegalArgumentException("List cannot be null");
    }
    return list.remove(Integer.valueOf(element));
  }

  public static int getSize(List<Integer> list) {
    if (list == null) {
      throw new IllegalArgumentException("List cannot be null");
    }
    return list.size();
  }

}
