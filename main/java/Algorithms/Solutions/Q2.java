/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.Solutions;

import Algorithms.Sort_;



/**
 *
 * @author jacobwaro
 */
public class Q2 {
    
    /**
     * Time complexity: O( m + k * n )
     * Space complexity: O( n + r )
     * 
     * Where m is the length of y, n is the length of x, k is the number of digits of the largest number between
     * x and y, and r is the constrained range from using count sort (10).
     * 
     * @param x - array of sorted integers with trailing 0s
     * @param y - array of sorted integers
     * 
     * @return sorted array
     */
    public static int[] mergeSortedArrays(int[] x, int[] y) {
        
        // add y to end of x
        for (int i = x.length - y.length, j = 0; i < x.length; i++, j++)
            x[i] = y[j];
        
        // use radix sort to sort x
        Sort_.radixSort(x);
        
        return x;
    }
    
}
