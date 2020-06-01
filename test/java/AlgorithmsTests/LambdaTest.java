/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgorithmsTests;
import Algorithms.Lambda;
import Data_Structures.Helpers.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
public class LambdaTest {
    
    public LambdaTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
     @Test
     public void testGetPopulation_Success() {
         List<Country> countries = new ArrayList<Country>();
         countries.add(new Country("USA", "North America", 330));
         countries.add(new Country("Canada", "North America", 35));
         countries.add(new Country("Mexico", "North America", 126));
         
         assertEquals((330+35+126), Lambda.getPopulation(countries, "North America"));
     }
     
     @Test
     public void testGetPopulation_Fail() {
         List<Country> countries = new ArrayList<Country>();
         countries.add(new Country("USA", "North America", 330));
         countries.add(new Country("Canada", "North America", 35));
         countries.add(new Country("Mexico", "North America", 126));
         
         assertEquals((330+35+126), Lambda.getPopulation(countries, "South America"));
     }
     
     /**
      * Test method for generating a random subset of a list using a lambda expression
      */
     @Test
     public void testGetRandomSubset() {
         List<Integer> vals = new ArrayList<>();
         
         assertArrayEquals(vals.toArray(), Lambda.getRandomSubset(vals).toArray());
         
         for (int j = 0; j < 10; j++) {
             vals.clear();
            for (int i = 0; i < 100; i++) {
                vals.add(i);
            }

            List<Integer> result1 = Lambda.getRandomSubset(vals);
            List<Integer> result2 = Lambda.getRandomSubset(vals);
            
            assertFalse(Arrays.deepEquals(result1.toArray(), result2.toArray()));
         }
     }
     
}
