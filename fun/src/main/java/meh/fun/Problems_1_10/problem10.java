/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meh.fun.Problems_1_10;

import java.util.List;
import meh.fun.Problem_Utilities.GenerationException;
import meh.fun.Problem_Utilities.GenerationType;
import meh.fun.Problem_Utilities.PrimesUtils;

/**
 *
 * @author n439081
 */
public class problem10 {

  /**
   * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.
   */
  public static void main(String[] args) throws GenerationException {
    List<Long> primeNums = PrimesUtils.generatePrimeList(2000000,GenerationType.LIMIT);
    
    long sum = 0;
    
    for (long prime : primeNums){
      sum += prime;
    }
    
    System.out.println(sum);
  }
  
}
