// bubble sort implementation O(n^2)
public class BubbleSort {
  static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
  
  static void bubbleSort(int[] a) {
    for (;;) {
      boolean sorted = true;
      for (int j=0; j < n-1; j++) 
        if (a[j] > a[j+1]) { // compare adj elts
          swap(a, j, j+1); // swap them
          sorted = false;
        }
      if (sorted) break;  // if no swaps, arr is sorted, we're done
    }
  }
}

// selection sort implementation (n^2 compares)
public void selectionSort(int[] a) {
  int n = a.length;
  
  for (int i=0; i < n-1; i++) { // Move the pointer to the right.
    int min = i;  /* set current element as minimum*/
    
    for (int j = i+1; j<n; j++) // Identify index of minimum entry on right.
      if (a[j] < a[min]) min = j; 
      
    if (min != i) { /* swap the minimum element with the current element*/
      int temp = a[i];
      a[i] = a[min];
      a[min] = temp;
    }
  }
}
 
// merge sort implementation (nlogn compares)
public class Merge {
  // recurse (dividing in half, call sort) until we get to 1 element arr  -- depth: logn
  // go back up, begin by merging 2 single-elt arr                        -- work at each lv: n
  // memory: depends--uses extra space proportional to n; aux arr needs to be of len n for last merge
  
  // merge a[lo .. mid] with a[mid+1 .. hi] using aux[lo .. hi]
  private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
    
    // copy to aux[]
    for (int k=lo; k<=hi; k++) 
      aux[k] = a[k];
    
    // merge back to a[]
    int i=lo, j=mid+1;
    for (int k=lo; k<=hi; k++) {
      if      (i > mid)           a[k] = aux[j++]; // we have exhausted left half; copy rest of right half
      else if (j > hi)            a[k] = aux[i++];
      else if (aux[j] < aux[i])   a[k] = aux[j++]; // if right elt is smaller than left elt
      else                        a[k] = aux[i++];
    }
  } 
  
  // mergesort a[lo..hi] using aux arr aux[lo..hi]
  private static void sort(int[] a, int[] aux, int lo, int hi) {
    if (hi <= lo) return;
    int mid = (lo + hi) / 2;
    sort(a, aux, lo, mid);      // sort left half
    sort(a, aux, mid+1, hi);    // sort right half
    merge(a, aux, lo, mid, hi); // merge them
  }
  
  // rearranges the arr in ascending order
  public static void sort(int[] a) {
    int[] aux = new int[a.length];
    sort(a, aux, 0, a.length - 1);
  }
}

// Quicksort Implementation | Runtime: O(nlogn) avg, O(n^2) worst case | Memory: O(logn)
public class Quick 
{
/***************************************
partition so that entry a[j] is in place
divide: left and right of a[j]
repeat

Worse case: a[] is sorted
  each partition: a[0]--smallest--is in place -> move j pointer O(n) times  --> O(n)compares
  n calls to partition                                                      --> O(n^2) compares
  
Best case:  each partitioning stage divides a[] exactly in half
  logn calls to partition (like mergesort)                                  --> O(nlogn) compares
  
Avg case: similar to best case

Memory: Depth of recursion: logarithmic extra space

****************************************/

    // partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
    // and return the index j.
    private static int partition(Comparable[] a, int lo, int hi) 
    {
    int i = lo, j = hi+1;
    while (true) 
    {
        while (less(a[++i], a[lo]))     // find item on left to swap
            if (i == hi) break;       
      
        while (less(a[lo], a[--j]))     // find item on right to swap
            if (j == lo) break;
        
        if (i >= j) break;              // check if pointers cross
        exch(a, i, j);                  // swap
    }
    
    exch(a, lo, j);                     // put partitioning item v at a[j]
    return j;                           // return index of item now known to be in place
  }
  
    public static void sort(Comparable[] a) 
    {
      StdRandom.shuffle(a);
      sort(a, 0, a.length - 1);
    }
  
    // quicksort the subarray from a[lo] to a[hi]
    private static void sort(Comparable[] a, int lo, int hi)
    {
      if (hi <= lo) return;             // no partition for subarr of size 1
      int j = partition(a, lo, hi);
      sort(a, lo, j-1);
      sort(a, j+1, hi);
  }
}

// Binary Search 
public int binarySearch(int key, int[] a)
{   // a must be sorted
    int lo = 0;
    int hi = a.length - 1;
    while (lo <= hi)
    {   // Key is in a[lo..hi] or not present
        int mid = (lo + hi) / 2;
        if      (key < a[mid]) hi = mid - 1;
        else if (key > a[mid]) lo = mid + 1;
        else                   return mid;
    }
    return -1;
}






















