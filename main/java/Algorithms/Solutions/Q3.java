/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.Solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author jacobwaro
 */
public class Q3 {
    
    Q3() {
        
    }
    
    /**
     * This method groups a list of strings by anagram groups. The str array is first sorted by the order of sorted
     * anagram letters, and then for each anagram group, the strings are sorted.
     * 
     * @param strs - list of strings to group by anagram and sort.
     */
    public static void groupAnagrams(String[] strs) {
        
        Map<String, ArrayList<String>> anagrams = new TreeMap<String, ArrayList<String>>();
        
        for (String str: strs) {
            
            String key = buildKey(str);
            
            // add str to respective anagram key
            if (anagrams.containsKey(key)) {
               ArrayList<String> val = anagrams.get(key);
               val.add(str);
            } else {
                ArrayList<String> val = new ArrayList<>();
                val.add(str);
                anagrams.put(key, val);
            }
        }
        
        // iterate by sorted anagrams, modifying strs array to be sorted
        int pos = 0;
        for (Map.Entry<String, ArrayList<String>> entry : anagrams.entrySet()) {
            ArrayList<String> vals = entry.getValue();
            Collections.sort(vals);
            for (String str: vals) {
                strs[pos] = str;
                pos++;
            }
        }       
    }
    
    /**
     * This method creates a sorted key representing the letters to a str. This is the same key for all anagrams of
     * str.
     * 
     * @param str - string in which we need to create an anagram key for.
     * @return the key to which anagram group this str belongs to.
     */
    private static String buildKey(String str) {
        // count sort the letters in the string
        int[] counts = new int[26];
            
        for (int i = 0; i < str.length(); i++) {
            counts[str.charAt(i) - 'a']++;
        }
        
        String key = "";
        
        // for each letter present in the counts array, add the letter followed by its count to the key
        for (int j = 0; j < 26; j++) {
            if (counts[j] != 0) {
                int letter = j + 'a';
                char val = (char) letter;
                key += String.valueOf(val) + String.valueOf(counts[j]);
            }
        }
        
        return key;
    }
    
}
