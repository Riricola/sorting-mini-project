import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.math.BigInteger;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 * Tests of Sorter objects.
 *
 * @author Your Name
 */
public class SortTester {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  Sorter sorter;

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  @Test
  public void fakeTest() {
    assertTrue(true);
  } // fakeTest()

  @Test
  public void orderedStringTest() {
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void reverseOrderedStringTest() {
    String[] original = { "foxtrot", "delta", "charlie", "bravo", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void randOrderedStringTest() {
    String[] original = { "alpha", "charlie", "bravo", "foxtrot", "delta" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // randOrderedStringTest

  @Test
  public void duplicateStringTest() {
    String[] original = { "alpha", "alpha", "alpha", "foxtrot", "alpha" };
    String[] expected = { "alpha", "alpha", "alpha", "alpha", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // duplicateStringTest

  @Test
  public void singleStringTest() {
    String[] original = { "alpha" };
    String[] expected = { "alpha" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // singleStringTest

  @Test
  public void emptyStringTest() {
    String[] original = {  };
    String[] expected = {  };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // emptyStringTest

  @Test
  public void randOrderIntegerTest() {
    Integer[] original = { 3, 7, 2, 8, 1 };
    Integer[] expected = { 1, 2, 3, 7, 8 };
    sorter.sort(original, (x, y) -> (x == y ? 0 : x < y ? -1 : 1));
    assertArrayEquals(original, expected);
  } // randOrderIntegerTest

  /*
   * random large array for the E
   */
  @Test
  public void testSortArray() {
    // Generate a randomly large array
    int size = 1000;
    int[] randomArray = new int[size];
    for (int i = 0; i < size; i++) {
      randomArray[i] = (int) (Math.random() * 1000); // Adjust the range as needed
    }
    sorter.sort(original, (x, y) -> (x == y ? 0 : x < y ? -1 : 1));
  
    int[] originalArray = Arrays.copyOf(randomArray, size);
    int[] sortedArray = sorter.sort(randomArray);

    assertArrayEquals(originalArray, sortedArray);

  } // testSortArray



} // class SortTester
