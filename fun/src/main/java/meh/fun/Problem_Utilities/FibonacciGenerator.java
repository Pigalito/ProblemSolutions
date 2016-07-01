/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meh.fun.Problem_Utilities;

import java.util.LinkedList;
import java.util.List;

/**
 * Utility class for common functions used for Fibonacci Numbers
 * 
 * @author n439081
 */
public class FibonacciGenerator {
  
  private List<Long> fibNums;
  
  
  /**
   * @param maximum The highest fibonacci number allowed or the total number to be stored in the list depending on other parameters
   * @param fibLimitOrCapacity LIMIT means that only fibonacci numbers below the maximum will be added and CAPACITY means that only the maximum number of fibonacci numbers will be added
   * @throws meh.fun.Problem_Utilities.GenerationException thrown if unsupported GenerationType is used
   */
  public FibonacciGenerator(int maximum, GenerationType fibLimitOrCapacity) throws GenerationException{
    
    fibNums = new LinkedList<>();
    fibNums.add(0L);
    fibNums.add(1L);
    
    switch (fibLimitOrCapacity) {
      
      case CAPACITY:
        for(int currentIndex = 2; currentIndex < maximum; currentIndex++){
          fibNums.add(fibNums.get(currentIndex-1) + fibNums.get(currentIndex-2));
        }
        break;
        
      case LIMIT:
        int currentIndex = 2;
        Long currentFibNum = fibNums.get(currentIndex-1) + fibNums.get(currentIndex-2);
        while(currentFibNum < maximum){
          fibNums.add(currentFibNum);
          currentIndex++;
          currentFibNum = fibNums.get(currentIndex-1) + fibNums.get(currentIndex-2);
        }
        break;
        
      default:
        throw new GenerationException(fibLimitOrCapacity + " is unsupported");
    }
    
    
    
  }
  
  public List<Long> getFibonacciNumbers(){
    return fibNums;
  }
  
}
