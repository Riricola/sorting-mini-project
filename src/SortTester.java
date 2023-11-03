import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;

/**
 * Tests of Sorter objects.
 *
 * @author Maria Rodriguez
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

} // class SortTester
