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
public class problem7 {

  /**
   * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10 001st prime number?
   */
  public static void main(String[] args) throws GenerationException {
    
    List<Long> primeNums = PrimesUtils.generatePrimeList(10001,GenerationType.CAPACITY);
    System.out.println(primeNums.get(10000));
  }
  
}
