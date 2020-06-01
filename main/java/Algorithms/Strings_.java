package Algorithms;

import java.util.Stack;

/**
 *
 * @author jacobwaro
 */
public class Strings_ {
    
    /**
     * Google Tech Guide - Former Coding Interview Question
     * 
     * This method decompresses a compressed string of format number[string].
     * The decompressed output form should be the string written number times.
     * 
     * e.g.
     * 3[abc]4[ab]c ==> abcabcabcababababc
     * 2[3[a]b] ==> aaabaaab
     * 
     * Solved using a recursive approach, requiring linear O(n) time
     * 
     * @param compressed - compressed string
     * @return uncompressed string
     */
    public static String decompressString(String compressed) {
        if (compressed.equals("")) return "";
        
        String result = "";
        int index = 0;
        
        // iterate through string
        // 1. if just a letter, add it to the result
        // 2. if we have a number, get the number and multiply it by the following letters
        // 3. if not at a number or letter, call buildstring to move forward
        while (index < compressed.length()) {
            if (Character.isLetter(compressed.charAt(index))) {
                result += compressed.charAt(index);
                index++;
            }
            else if (Character.isDigit(compressed.charAt(index))) {
                int[] numberArr = buildNumber(compressed, index); // contains number and index position
                int number = numberArr[0];
                index = numberArr[1];
                
                // call recursively to get deeper compressed string levels
                String[] addStack = buildString(compressed, index);
                index = Integer.parseInt(addStack[1]);
                
                // add the string number times to result
                for (int i = 0; i < number; i++) {
                    result += addStack[0];
                }
            } else {
                String[] addStack = buildString(compressed, index); // contains string to multiply by and index position
                result += addStack[0];
                index = Integer.parseInt(addStack[1]);
            }
        }
        
        return result;
    }
    
    /**
     * This is a helper method for decompressString. This method returns a number that occurs in the compressed
     * string.
     * @param compressed - compressed string
     * @param index - current index in the compressed string
     * @return number that occurs in the compressed string.
     */
    private static int[] buildNumber(String compressed, int index) {
        String number = "";
        
        // build the number
        while (Character.isDigit(compressed.charAt(index))) {
            number += compressed.charAt(index);
            index++;
        }
        
        int[] numberArr = {Integer.parseInt(number), index};
        
        return numberArr;
    }
    
    /**
     * This method is a helper method for decompressString. We recursively build the string; if a number occurs,
     * we extract the number and multiply it by the following strings / depths of the compressed string.
     * @param compressed - compressed string
     * @param index - current index position in the compressed string
     * @return string at a certain depth of compressed string
     */
    private static String[] buildString(String compressed, int index) {
        if (compressed.charAt(index) == '[') index++;
        
        String tmp = "";
        
        if (Character.isDigit(compressed.charAt(index))) {
            // getthe number for how many times we should add the string to the output
            int[] numberArr = buildNumber(compressed, index);
            int number = numberArr[0];
            index = numberArr[1];
            
            // call recursively to get deeper compressed string levels
            String[] addStack = buildString(compressed, index);
            index = Integer.parseInt(addStack[1]);
            
            // build the string number times to output
            for (int i = 0; i < number; i++) {
                tmp += addStack[0];
            }
        }
        
        // add leftover letters after recursive depth
        while (Character.isLetter(compressed.charAt(index))) {
            tmp += compressed.charAt(index);
            index++;
         }
        
        // end of this depth, increase index
        if (compressed.charAt(index) == ']') index++;
        
        String[] output = { tmp, String.valueOf(index)};
        
        return output;
    }
}