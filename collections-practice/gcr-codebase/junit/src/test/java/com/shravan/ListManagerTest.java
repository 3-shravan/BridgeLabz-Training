package com.shravan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ListManagerTest {

  @Test
  void testAddElement() {
    List<Integer> list = new ArrayList<>();
    ListManager.addElement(list, 10);
    ListManager.addElement(list, 20);

    assertEquals(2, list.size());
    assertTrue(list.contains(10));
    assertTrue(list.contains(20));
  }

  @Test
  void testRemoveElement() {
    List<Integer> list = new ArrayList<>();
    list.add(10);
    list.add(20);

    boolean removed = ListManager.removeElement(list, 10);

    assertTrue(removed);
    assertEquals(1, list.size());
    assertFalse(list.contains(10));
  }

  @Test
  void testRemoveElementNotPresent() {
    List<Integer> list = new ArrayList<>();
    list.add(10);

    boolean removed = ListManager.removeElement(list, 99);

    assertFalse(removed);
    assertEquals(1, list.size());
  }

  @Test
  void testGetSize() {
    List<Integer> list = new ArrayList<>();
    assertEquals(0, ListManager.getSize(list));

    list.add(5);
    list.add(15);
    assertEquals(2, ListManager.getSize(list));
  }

  @Test
  void testNullList() {
    assertThrows(IllegalArgumentException.class, () -> ListManager.addElement(null, 10));
    assertThrows(IllegalArgumentException.class, () -> ListManager.removeElement(null, 10));
    assertThrows(IllegalArgumentException.class, () -> ListManager.getSize(null));
  }

}
