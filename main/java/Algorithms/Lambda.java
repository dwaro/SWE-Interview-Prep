package Algorithms;
import Data_Structures.Helpers.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author jacobwaro
 */
public class Lambda {
    
    /**
     * Use a lambda expression to calculate the total population of continent.
     * @param countries - list of countries
     * @param continent - continent to calculate the population for
     * @return the combined populations of countries for a given continent.
     */
    public static int getPopulation(List<Country> countries, String continent) {
        // anonymous class wrapper
        var population = new Object(){ int sum = 0; };
        
        countries.forEach((Country c) -> {
            population.sum += c.getPopulation();
        });
        
        return population.sum;
        
        /* 
        Alternative Solution
        ----------------------------------
        
        int population = 0;
        for (Country c: countries) {
            population+=c.getPopulation();
        }
        return population;
        */
    }
    
    /**
     * Use a lambda expression to return a random subset of a list. I've also included the shuffling of the
     * randomly chosen elements.
     * @param list - list of integers
     * @return random subset of the list, randomly shuffled.
     */
    public static List<Integer> getRandomSubset(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        Random random = new Random();
        
        list.forEach(num -> {
           if (random.nextInt(2) == 1) newList.add(num);
        });
        
        Collections.shuffle(list, random);
        
        return newList;
    }
}
