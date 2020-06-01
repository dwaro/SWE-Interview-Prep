/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.Solutions;

/**
 *
 * @author jacobwaro
 */
public class Q1 {
    
    /**
     * Time complexity: O(n + m) where n is the length of arr1 and m is the length of arr2.
     * Space complexity: O(n + m)
     * 
     * @param arr1 - array of sorted integers
     * @param arr2 - array of sorted integers
     * @return new array of sorted merged arr1 and arr2
     */
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int l1 = arr1.length;
        int l2 = arr2.length;
        int[] result = new int[l1 + l2];
        
        int i1 = 0, i2 = 0; // index trackers
        
        // copy next smallest value between arr1 and arr2 to result
        for (int j = 0; j < l1 + l2; j++) {
            if (i1 <l1 && i2 == l2)
                result[j] = arr1[i1++];
            else if (i2 < l2 && i1 == l1)
                result[j] = arr2[i2++];
            else if (arr1[i1] < arr2[i2])
                result[j] = arr1[i1++];
            else
                result[j] = arr2[i2++];
        }
        
        return result;
    }
}
