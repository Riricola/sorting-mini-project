import java.util.Comparator;

/**
 * Sort using insertion sort.
 *
 * @author Maria Rodriguez
 */

public class InsertionSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new InsertionSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  InsertionSort() {
  } // InsertionSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    if(values != null){//if the array isn't empty
      for(int i = 1; i < values.length; i++){

        //check if vals[i] is less than the largest sorted val
        if((order.compare(values[i], values[i-1])) <= 0){
          //if its smaller, find it's spot
          for(int j = 0; j <= i; j++){

            if((order.compare(values[i], values[j])) < 0){
              swap(values, i, j);
            }//if
          }//for
        }//if

      }//for
    }//if
  } // sort(T[], Comparator<? super T>

  /* swap(T[] vals, int num1, int num2)
   * 
   * Swaps num1 and num2 
   */
  public static <T> void swap(T[] vals, int num1, int num2){
    T temp = vals[num1];
    vals[num1] = vals[num2]; //puts the val to the left of ub
    vals[num2] = temp;
  }//swap

} // class InsertionSort
