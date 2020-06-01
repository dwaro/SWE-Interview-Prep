package Algorithms;

/**
 *
 * @author jacobwaro
 */
public class Search_ {
    
    Search_() {
        
    }
    
    /**
     * Binary search algorithm.
     * 
     * Time complexity: O( log(n) )
     * 
     * @param values - array of sorted integers to search through
     * @param val - value we are looking for
     * @return index of val in values.
     */
    public static int binarySearch(int[] values, int val) {
        // edge cases
        if (values.length == 0 || values == null) return -1;
        if (values.length == 1) return 0;
        
        int low = 0;
        int high = values.length - 1;
        int mid;
        
        // loop until values[mid] == val or low > high
        while (low <= high) {
            
            mid = (high - low ) / 2 + low;
            
            // val is to the right
            if  (values[mid] < val)  low = mid + 1;
            
            // val is to the left
            else if (values[mid] > val) high = mid - 1;
            
            // we found the val
            else return mid;
        }
        
        // error in finding the value
        return -1;
    }
    
}
