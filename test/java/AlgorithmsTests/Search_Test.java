/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgorithmsTests;

import Algorithms.Search_;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;

/**
 *
 * @author jacobwaro
 */
public class Search_Test {
    
    public Search_Test() {
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

    @ParameterizedTest
    public void testBinarySearch() {
        int[] values = {1, 4, 8, 19, 20, 25, 33, 45, 57, 80, 109};
        int[] smallArr = {1};
        int[] smallArr2 = {1, 2};
        int[] empty = new int[0];
        
        int result1 = Search_.binarySearch(values, 45);
        int result2 = Search_.binarySearch(values, 20);
        int resultStart = Search_.binarySearch(values, 1);
        int resultEnd = Search_.binarySearch(values, 109);
        int resultDoesNotExist = Search_.binarySearch(values, 214);
        int resultEmpty = Search_.binarySearch(empty, 24);
        int resultSmallArr = Search_.binarySearch(smallArr, 1);
        int resultSmallArr2 = Search_.binarySearch(smallArr2, 1);
        
        assertEquals(7, result1);
        assertEquals(4, result2);
        assertEquals(0, resultStart);
        assertEquals(10, resultEnd);
        assertEquals(-1, resultDoesNotExist);
        assertEquals(-1, resultEmpty);
        assertEquals(0, resultSmallArr);
        assertEquals(0, resultSmallArr2);
        
    }
}
