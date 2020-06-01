package Algorithms;

/**
 *
 * @author jacobwaro
 */
public class Sort_ {
    
    /**
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     * 
     * @param values - array of integers 
     */
    public static void bubbleSort(int[] values) {
        // n sweeps
        for (int i = 0; i < values.length - 1; i++) {

            // compare adjacent neighbors up to (i - 1) position from the end
            for (int j = 0; j < values.length - 1 - i; j++) {

                // swap values
                if (values[j] > values[j + 1]) {
                    int tmp = values[j+1];
                    values[j+1] = values[j];
                    values[j] = tmp;
                }
            }
        }
    }
    
    /**
     * Improved bubble sort. Quits early.
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     * 
     * @param values - array of integers 
     */
    public static void improvedBubbleSort(int[] values) {
        // Track swaps
        boolean swapped = true;

        // n sweeps
        for (int i = 0; i < values.length - 1 && swapped; i++) {
            swapped = false;

            // compare adjacent neighbors up to (i - 1) position from the end
            for (int j = 0; j < values.length - 1 - i; j++) {

                // swap values
                if (values[j] > values[j + 1]) {
                    int tmp = values[j+1];
                    values[j+1] = values[j];
                    values[j] = tmp;
                    swapped = true;
                }
            }
        }
    }
    
    /**
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     * 
     * @param values - array of integers
     */
    public static void selectionSort(int[] values) {
        // n - 1 sweeps
        for (int i = 0; i < values.length - 1; i++) {

            // index of max element in unsorted portion of the array 
            int max = 0;

            // compare if we have a new max
            for (int j = 0; j < values.length - 1 - i; j++) {
                if (values[j] > values[max]) {
                    max = j;
                }
            }

            // swap max element to the end of unsorted array
            int tmp = values[values.length - 1 - i];
            values[values.length - 1 - i] = values[max];
            values[max] = tmp;
        }   
    }
    
    /**
     * Improved merge sort. Doesn't need to do initial breaking down of arrays (i.e. we're doing 1/2 * n * log(n))
     * 
     * Time complexity: O(n * log(n))
     * Space complexity: O(n)
     * 
     * @param values - array of integers
     */
    public static void improvedMergeSort(int[] values) {
        if (values != null && values.length > 1) {
            int size = 1;
            while (size <= values.length) {
                merge(size, values);
                size *= 2;
            }
        }
    }
    
    /**
     * Helper method for improvedMergeSort. This method steps over the array, and merges sub-arrays into sorted
     * arrays of size (size * 2).
     * @param size - size of each sub-array
     * @param values - array that's being sorted
     */
    private static void merge(int size, int[] values) {
        // the "subarray" we are working on at the current depth
        int count = 1;
        
        // left and right positions for merging subarrays
        int left = 0, right = size;
        
        // end of left subarray
        int leftBreak = size * 2 - size;
        
        // end of right subarray
        int rightBreak = size * 2 > values.length ? values.length : size * 2;
        
        // temporary array
        int[] tmp = values.clone();
        
        // stop merging subarrays at this point
        int stop = (size * 2 > values.length) ? values.length : (values.length / 2) * 2;
        
        // merge subarrays
        for (int i = 0; i < stop; i++) {
            
            // once we've finished sorting a "subarray" of size * 2, reset left & right positions and breaks
            if (left == leftBreak && right == rightBreak) {
                count++;
                leftBreak = size * 2 * count - size;
                rightBreak = ((size * 2 * count) > values.length) ? values.length : size * 2 * count;
                left = i;
                right = leftBreak;
            }
            
            // populate temporary array
            if (left < leftBreak && right == rightBreak) {
                // right subarray has been completely merged, merge rest of elements from left subarray
                tmp[i] = values[left++];
            } else if (right < rightBreak && left == leftBreak) {
                // left subarray has been completely merged, merge rest of elements from right subarray
                tmp[i] = values[right++];
            } else if (values[left] < values[right]) {
                // merge element from left subarray
                tmp[i] = values[left++];
            } else {
                // merge element from right subarray
                tmp[i] = values[right++];
            }
        }
        
        // update values array
        for (int i =0; i < tmp.length; i++) {
            values[i] = tmp[i];
        }
    }
    
    /**
     * Time Complexity: O(n * log(n) ) average, O(n^2) worst case
     * Space Complexity: O( log(n) )
     * 
     * @param values - integer array of values to sort
     */
    public static void quickSort(int[] values) {}

    
    /**
     * Radix sort algorithm, implemented using helper overload method to perform the counting sort.
     * 
     * Time Complexity: O(kn) where k is the number of digits in the largest number and n is the size of the array to
     * be sorted.
     * Space Complexity: O(n + r) where r is the range of the counting sort (usually 10)
     * 
     * @param values - array of integers to be sorted
     */
    public static void radixSort(int[] values) {
        if (values != null && values.length > 1) {
            int max = getMax(values);

            int maxLength = String.valueOf(max).length();

            radixSort(values, maxLength);
        }
    }
    
    /**
     * Gets the max number in an array of integers.
     * 
     * @param values - array of integers
     * @return the max number in values
     */
    public static int getMax(int[] values) {
        int max = Integer.MIN_VALUE;
        
        for (int num: values) {
            if (num > max)
                max = num;
        }
        
        return max;
        
    }
    
    /**
     * Overloaded helper method to do the heavy lifting counting sorting for the radix sort.
     * 
     * @param values - array of integers to be sorted
     * @param passes - number of digits in the largest number in values
     */
    public static void radixSort(int[] values, int passes) {
        
        // take a pass for each digit of the max number
        for (int i = 0, divisor = 1; i < passes; i++, divisor *= 10 ) {
            int[] tmp  = new int[values.length];
            int[] counting = new int[10];
            
            // populate counts
            for (int num: values) {
                counting[ (num / divisor)  % 10 ]++;
            }
            
            // change counts to actual output positions
            for (int j = 1; j < 10; j++)
                counting[j] += counting[j-1];
            
            // now update tmp
            for (int j = values.length - 1; j >= 0; j--) {
                tmp[counting[ (values[j] / divisor) % 10 ] - 1] = values[j];
                counting[ (values[j]/divisor) % 10 ]--;
            }
            
            // copy output from tmp back into values
            for (int z = 0; z < values.length; z++)
                values[z] = tmp[z];
        }
    }
}
