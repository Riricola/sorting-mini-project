import java.util.Comparator;

/**
 * Sort using merge sort.
 *
 * @author Maria Rodriguez
 */

public class MergeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  MergeSort() {
  } // MergeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    if (values == null || values.length <= 1) {
      return;
    } else{
      
      //calls mergesort on the array 
      MergeSort(values, order, 0, values.length);
      //merges all the split (sorted) arrays
      merge(values, 0, values.length/2, values.length, order);
    }//else
  } // sort(T[], Comparator<? super T>

  public static <T> void MergeSort(T[] values, Comparator<? super T> order, int lb, int ub){
    if(lb >= ub-1){
      return;
    } else{
      //these get redefined after every recursive call to mergesort
      int lo = lb;
      int hi = ub-1;
      int mid = lo + (ub - lo)/2; 

      //sorts the left half of the split array
      while(lo < mid){
        if(order.compare(values[lo], values[lo+1]) > 0){
          swap(values, lo, lo+1);
        }
        lo++;
      }//while

      //sorts the right half of the split array
      while(mid < hi){
        if(order.compare(values[mid], values[mid+1]) > 0){
          swap(values, mid, mid+1);
        }
        mid++;
      }//while

      //recursively calls mergeSort
      MergeSort(values, order, lb, mid);
      MergeSort(values, order, mid+1, ub);
    }//else  
  }//MergeSort

  /**
   * Merge the values from positions [lo..mid) and [mid..hi) back into
   * the same part of the array.
   *
   * Preconditions: Each subarray is sorted accorting to comparator.
   */
  static <T> void merge(T[] vals, int lo, int mid, int hi, Comparator<? super T> comparator) {
    //makes a copy of the array that will be sorted
    T[] merged = java.util.Arrays.copyOfRange(vals, lo, hi);

    int right = mid+1;
    int current = lo;

    //performs the while loop until either left or right is completely sorted
    while((lo <= mid) && (right <= hi-1)){
      //if the left array has a smaller val
      if(comparator.compare(vals[lo], vals[right]) <= 0){
        merged[current++] = vals[lo++];
      }//if
      //if the right array has a smaller val
      else {
        merged[current++] = vals[right++];
      }//else
    }//while

    //move over left
    //might not be mid+1
    while(lo < mid+1){
      merged[current++] = vals[lo++];
    }//while

    //move over right
    //might be hi+1
    while(right < hi){
      merged[current++] = vals[right++];
    }//while

    for(int i = 0; i< vals.length; i++){
      vals[i] = merged[i];
    }//for
  } // merge

  /* swap(T[] vals, int num1, int num2)
   * 
   * Swaps num1 and num2 
   */
  public static <T> void swap(T[] vals, int num1, int num2){
    T temp = vals[num1];
    vals[num1] = vals[num2]; //puts the val to the left of ub
    vals[num2] = temp;
  }//swap

} // class MergeSort
