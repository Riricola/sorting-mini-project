import java.util.Comparator;

/**
 * Sort using an implementation of Heap sort
 *
 * @author Maria Rodriguez
 * Acknowledgements: ChatGPT
 *    - "What are some ideas of sorting algorithms" - provided me with a list of 10 different sorts
 *    - "Using java, make a heap sort method" - provided the variables, for loops, and if statements
 *        needed for a heap sort. I used it as a blueprint and replaced variable names, some indeces,
 *        and applied my swap helper wherever necessary.
 */

public class RodriguezMariaSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new RodriguezMariaSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  RodriguezMariaSort() {
  } // FakeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    int hi = values.length;

    // Build a max-heap (rearrange the array)
    for (int i = hi / 2 - 1; i >= 0; i--) {
        heapify(values, order, hi, i);
    }//for

    // One by one extract elements from the heap
    for (int i = hi - 1; i > 0; i--) {
        // Move the current root (maximum element) to the end of the array
        swap(values, 0, i);

        // Call max heapify on the reduced heap
        heapify(values, order, i, 0);
    }//for
  } // sort(T[], Comparator<? super T>

  /* heapify(T[] arr, <? super T> order, int n, int i) 
   * 
   * To heapify a subtree rooted with node i which is an index in the array.
  */
  public <T> void heapify(T[] arr, Comparator<? super T> order, int i, int num) {
    int largest = num; // Initialize the largest as the root
    int left = 2 * num + 1; // Left child
    int right = 2 * num + 2; // Right child

    // If the left child is larger than the root
    if (left < i && (order.compare(arr[left], arr[largest]) > 0)) {
      
        largest = left;
    }//if

    // If the right child is larger than the largest so far
    if (right < i && (order.compare(arr[right], arr[largest]) > 0)) {
        largest = right;
    }//if

    // If the largest is not the root
    if (largest != num) {
        swap(arr, num, largest);

        // Recursively heapify the affected sub-tree
        heapify(arr, order, i, largest);
    }//if
  }//heapify

  /* swap(T[] vals, int num1, int num2)
   * 
   * Swaps num1 and num2 
   */
  public static <T> void swap(T[] vals, int num1, int num2){
    T temp = vals[num1];
    vals[num1] = vals[num2]; //puts the val to the left of ub
    vals[num2] = temp;
  }//swap
} // class FakeSort
