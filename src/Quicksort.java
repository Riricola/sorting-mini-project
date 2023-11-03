import java.util.Comparator;

/**
 * Sort using Quicksort.
 *
 * @author Maria Rodriguez
 */

public class Quicksort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new Quicksort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  Quicksort() {
  } // Quicksort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    quicksort(values, order, 0, values.length);
  } // sort(T[], Comparator<? super T>

  /* Quicksort(T[] values, <? super T> order, int lb, int)
   * 
   * recursively calls quicksort on an array that's split in half
   */
  public <T> void quicksort(T[] values, Comparator<? super T> order, int lb, int ub) {
    // Subarrays of one element or fewer are sorted.
    if (lb >= ub-1) {
      return;
    } else {
      int mid = partition(values, order, lb, ub); //through every call of Quicksort, mid gets redefined
      quicksort(values, order, lb, mid); //quicksort is called on the left half
      quicksort(values, order, mid+1, ub); //quicksort is called on the right half
    } // if/else
  } // Quicksort(T[], Comparator<? super T>, int lb, int ub)

  /**
   * Select a pivot and partition the subarray from [lb .. ub) into 
   * the following form.
   *
   * <pre>
   * ---+-----------------+-+----------------+---
   *    | values <= pivot |p| values > pivot |
   * ---+-----------------+-+----------------+---
   *    |                 |                  |
   *    lb                pivotLoc           ub
   * </pre>
   *
   * @return pivotLoc.
   */
  private static <T> int partition(T[] arr, Comparator<? super T> compare, int lb, int ub) {
    int pivot = lb + (ub - lb)/2; //set pivot index

    swap(arr, pivot, lb); //swaps pivot with the first elem

    int small = lb+1;
    int large = ub;

    //compares the pivot with the small/large indexed element
    while(small != large){
      if(compare.compare(arr[small], arr[lb]) > 0){ //if small is greater than pivot, swap it with whatever is before 'large'
        swap(arr, small, large-1);
        large--; //move the large pointer to the left
      } else{
        small++; //if small is less than the pivot, move the small pointer to the right
      }//if
    }//while
    //in the end, swap the pivot at [0] with the 'largest' small number
    swap(arr, small-1, lb); 

    return (large-1); //this returns the pivot's location after it has been swapped to the correct spot
  } // partition

  /* swap(T[] vals, int num1, int num2)
   * 
   * Swaps num1 and num2 
   */
  public static <T> void swap(T[] vals, int num1, int num2){
    T temp = vals[num1];
    vals[num1] = vals[num2];
    vals[num2] = temp;
  }//swap

} // class Quicksort
