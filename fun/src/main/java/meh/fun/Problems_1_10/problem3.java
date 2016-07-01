/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meh.fun.Problems_1_10;

import java.util.Iterator;
import java.util.Set;
import meh.fun.Problem_Utilities.PrimesUtils;

/**
 *
 * @author n439081
 */
public class problem3 {

  /**
   * The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143
   */
  public static void main(String[] args) {
    
    Set<Long> primeFactors = new PrimesUtils().generatePrimeFactors(600851475143L);
    
    Iterator<Long> iter = primeFactors.iterator();
    
    long result = 0;
    
    while(iter.hasNext()){
      long num = iter.next();
      if(result < num) result = num;
    }
    
    System.out.println(result);
    
  }
  
}
