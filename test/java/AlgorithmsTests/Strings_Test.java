/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgorithmsTests;
import Algorithms.Strings_;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 *
 * @author jacobwaro
 */
public class Strings_Test {
    
    public Strings_Test() {
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

    /**
     * This test checks that the decompress string correctly decompresses strings in the format Number[string]
     */
    @Test
    public void testDecompressString() {
         String[] values =  {"0[safab]", "3[hgtv]", "1[abcd]", "24[]", "", "3[abc]4[ab]c", "2[3[a]b]", "2[3[a]b]3[gt]1[4[re]bd[3[d]]]", "2[4[2[3[z]y]x]w]v"};
         String[] expected = {
             "", 
             "hgtvhgtvhgtv",
             "abcd",
             "",
             "",
             "abcabcabcababababc",
             "aaabaaab",
             "aaabaaabgtgtgtrerererebdddd",
             "zzzyzzzyxzzzyzzzyxzzzyzzzyxzzzyzzzyxwzzzyzzzyxzzzyzzzyxzzzyzzzyxzzzyzzzyxwv"
         };
         
         for (int i = 0; i < values.length; i++) {
             assertEquals(expected[i], Strings_.decompressString(values[i]));
         }
     }
}
