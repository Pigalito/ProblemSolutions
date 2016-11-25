/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meh.fun.Problems_41_50;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author n439081
 */
public class problem46 {

  /**
   * It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.

9 = 7 + 2×1**2
15 = 7 + 2×2**2
21 = 3 + 2×3**2
25 = 7 + 2×3**2
27 = 19 + 2×2**2
33 = 31 + 2×1**2

It turns out that the conjecture was false.

What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?
   */
  public static void main(String[] args) {
    
    long startTime = System.currentTimeMillis();
    
    // Loop through composite numbers
    // Loop through squares
    // Check double square is not more that composite number - 1
    // Check if composite number minus double square is prime
    
    for(long compNum = 9; compNum <= 100000000L; compNum+=2){
      boolean isCurrentCompPrime = isPrime(compNum);
      boolean noSums = false;
      
      if(isCurrentCompPrime)continue;
      
      long currentSquare = 1;
      for(long square = 2; 2*currentSquare<compNum; square++){
        if(isPrime(compNum - 2*currentSquare)){
          noSums = true;
        }
        currentSquare = (long) Math.pow(square, 2);
      }
      
      if(!noSums){
        System.out.println(compNum);
        break;
      }
      
    }
    
    System.out.println((System.currentTimeMillis() - startTime)/1000.0 + " seconds");
  }
  
  private static boolean isPrime(long n) {
    if(n < 2) return false;
    if(n == 2 || n == 3) return true;
    if(n%2 == 0 || n%3 == 0) return false;
    long sqrtN = (long)Math.sqrt(n)+1;
    for(long i = 6L; i <= sqrtN; i += 6) {
      if(n%(i-1) == 0 || n%(i+1) == 0)return false;
    }
    return true;
  }
  
}
