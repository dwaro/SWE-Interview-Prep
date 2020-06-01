/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgorithmsTests.Solutions;

import Algorithms.Solutions.Q1;
import Algorithms.Solutions.Q2;
import Algorithms.Solutions.Q3;
import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jacobwaro
 */
public class Q1_Q10_Test {
    
    public Q1_Q10_Test() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testQ1() {
        // test simple
        int[] arr1 = {1, 5, 6, 7, 34, 109};
        int[] arr2 = {3, 18, 20, 29, 45, 100};
        int[] expected = {1, 3, 5, 6, 7, 18, 20, 29, 34, 45, 100, 109};
        int[] result = Q1.mergeSortedArrays(arr1, arr2);
        
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], result[i]);
        }
        
        // test same values in arrays
        int[] arr11 = {1, 5};
        int[] arr21 = {1, 1, 5};
        int[] expected1 = {1, 1, 1, 5, 5};
        int[] result1 = Q1.mergeSortedArrays(arr11, arr21);
        
        for (int i = 0; i < expected1.length; i++) {
            assertEquals(expected1[i], result1[i]);
        }
        
        // test empty
        int[] arr12 = {1, 5, 6, 7, 8};
        int[] arr22 = {};
        int[] expected2 = {1, 5, 6, 7, 8};
        int[] result2 = Q1.mergeSortedArrays(arr12, arr22);
        
        for (int i = 0; i < expected2.length; i++) {
            assertEquals(expected2[i], result2[i]);
        }
    }
    
    @Test
    public void testQ2() {
        // test simple
        int[] arr1 = {1, 5, 6, 7, 34, 109, 0, 0, 0, 0, 0, 0};
        int[] arr2 = {3, 18, 20, 29, 45, 100};
        int[] expected = {1, 3, 5, 6, 7, 18, 20, 29, 34, 45, 100, 109};
        int[] result = Q2.mergeSortedArrays(arr1, arr2);
        
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], result[i]);
        }
        
         // test same values in arrays
        int[] arr11 = {1, 5, 0, 0, 0};
        int[] arr21 = {1, 1, 5};
        int[] expected1 = {1, 1, 1, 5, 5};
        int[] result1 = Q2.mergeSortedArrays(arr11, arr21);
        
        for (int i = 0; i < expected1.length; i++) {
            assertEquals(expected1[i], result1[i]);
        }
        
        // test empty
        int[] arr12 = {1, 5, 6, 7, 8};
        int[] arr22 = {};
        int[] expected2 = {1, 5, 6, 7, 8};
        int[] result2 = Q2.mergeSortedArrays(arr12, arr22);
        
        for (int i = 0; i < expected2.length; i++) {
            assertEquals(expected2[i], result2[i]);
        }
    }
    
    @Test
    public void testQ3() {
        String[] strs1 = {"abc", "cba", "bac", "xyzw", "wxyz", "yzwx"};
        String[] expected1 = {"abc", "bac", "cba", "wxyz", "xyzw", "yzwx"};
        
        Q3.groupAnagrams(strs1);
        
        for (int i = 0; i < strs1.length; i++) {
            assertEquals(expected1[i], strs1[i]);
        }
        
        String[] strs2 = {"z", "tusa", "usta", "def", "fdea", "jump", "mup"};
        String[] expected2 = {"fdea", "tusa", "usta", "def", "jump", "mup", "z"};
        
        Q3.groupAnagrams(strs2);
        
        for (int i = 0; i < strs2.length; i++) {
            assertEquals(expected2[i], strs2[i]);
        }
        
    }
}
