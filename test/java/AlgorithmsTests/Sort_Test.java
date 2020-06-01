/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgorithmsTests;

import Algorithms.Sort_;
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
public class Sort_Test {
    
    public Sort_Test() {
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
     public void testImprovedMergeSortOdds() {
         // simplest case
         int[] expected1 = {1};
         int[] result1 = {1};
         Sort_.improvedMergeSort(result1);
         
         for (int i = 0; i < expected1.length; i++) {
             assertEquals(expected1[i], result1[i]);
         }
         
         // simple case
         int[] expected2 = {1, 2, 3};
         int[] result2 = {3, 2, 1};
         Sort_.improvedMergeSort(result2);
         
         for (int i = 0; i < expected2.length; i++) {
             assertEquals(expected2[i], result2[i]);
         }
         
         // longer case
         int[] expected3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
         int[] result3 = {13, 5, 8, 3, 2, 9, 14, 12, 6, 4, 17, 10, 15, 1, 11, 16, 7};
         Sort_.improvedMergeSort(result3);
         
         for (int i = 0; i < expected3.length; i++) {
             assertEquals(expected3[i], result3[i]);
         }
         
     }
     
     @Test
     public void testImprovedMergeSortEvens() {
         
         // simplest case
         int[] expected1 = {1, 2};
         int[] result1 = {2, 1};
         Sort_.improvedMergeSort(result1);
         
         for (int i = 0; i < expected1.length; i++) {
             assertEquals(expected1[i], result1[i]);
         }
         
         // longer case
         int[] expected2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
         int[] result2 = {13, 5, 8, 3, 2, 9, 14, 12, 6, 4, 10, 1, 11, 7};
         Sort_.improvedMergeSort(result2);
         
         for (int i = 0; i < expected2.length; i++) {
             assertEquals(expected2[i], result2[i]);
         }
         
     }
     
     @Test
     public void testImprovedMergeSortOther() {
         // null input
         int[] result1 = null;
         Sort_.improvedMergeSort(result1);
         
         assertNull(result1);
         
         // empty input
         int[] expected2 = {};
         int[] result2 = {};
         Sort_.improvedMergeSort(result2);
         
         for (int i = 0; i < expected2.length; i++) {
             assertEquals(expected2[i], result2[i]);
         }
         
     }
     
     @Test
     public void testRadixSortSameRange() {
         int[] expected = {2, 3, 5, 6, 7, 9};
         int[] result = {9, 5, 2, 6, 7, 3};
         Sort_.radixSort(result);
         
         for (int i = 0; i < expected.length; i++)
             assertEquals(expected[i], result[i]);
     }
     
     @Test
     public void testRadixSortDiffRange() {
         int[] expected = {2, 6, 17, 35, 91, 103, 452, 780, 1046};
         int[] result =  {2, 780, 103, 35, 1046, 6, 17, 91, 452};
         Sort_.radixSort(result);
         
         for (int i = 0; i < expected.length; i++)
             assertEquals(expected[i], result[i]);
     }
     
     @Test
     public void testRadixSortEdges() {
         // single value
         int[] expected = {892};
         int[] result =  {892};
         Sort_.radixSort(result);
         
         for (int i = 0; i < expected.length; i++)
             assertEquals(expected[i], result[i]);
         
         // null input
         int[] result1 = null;
         Sort_.radixSort(result1);
         
         assertNull(result1);
         
         // empty input
         int[] expected2 = new int[0];
         int[] result2 = new int[0];
         Sort_.radixSort(result2);
         
         for (int i = 0; i < expected2.length; i++)
             assertEquals(expected2[i], result2[i]);
         
     }
}
