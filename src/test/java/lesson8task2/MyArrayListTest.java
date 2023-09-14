package lesson8task2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyArrayListTest {


  @Test
  void shouldReturnSizeAndIsEmpty() {
    OwnList myArrayList = new MyArrayList();
    List<Integer> numbers = List.of(3, -100, 6, 8, 128, 210, 23, 21, 55, 66, 24, 56, 78);
    for (Integer number : numbers) {
      myArrayList.add(number);
    }
    Assertions.assertFalse(myArrayList.isEmpty());
    Assertions.assertEquals(13, myArrayList.size());

  }


  @Test
  void testAddAtIndex() {
    OwnList myArrayList = new MyArrayList();
    myArrayList.add(0, 1);
    myArrayList.add(1, 3);
    myArrayList.add(2, 2);

    assertEquals(1, myArrayList.get(0));
    assertEquals(3, myArrayList.get(1));
    assertEquals(2, myArrayList.get(2));

  }
}
