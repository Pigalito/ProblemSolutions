/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meh.fun.Problems_41_50;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author n439081
 */
public class problem47 {
  
  /**
   * The first two consecutive numbers to have two distinct prime factors are:

14 = 2 × 7
15 = 3 × 5

The first three consecutive numbers to have three distinct prime factors are:

644 = 2² × 7 × 23
645 = 3 × 5 × 43
646 = 2 × 17 × 19.

Find the first four consecutive integers to have four distinct prime factors. What is the first of these numbers?
   */
  public static void main(String[] args) {
    
    long time = System.currentTimeMillis();
    int maxNumberToCheck = 1000000;
    
    Integer[] distinctPrimesCount = new Integer[maxNumberToCheck];
    
    int consecutiveQuantity = 4;

    for(int i = 1; i <= maxNumberToCheck; i++){
      if(i%10000==0)
        System.out.print(i + " ");
      boolean areConsecutiveNumbersWithSameDistinctPrimeFactors = false;
      distinctPrimesCount[i-1] = NumberOfPrimeFactors(i);
      if(i>=1 + consecutiveQuantity-1 && distinctPrimesCount[i-1] == consecutiveQuantity){
        areConsecutiveNumbersWithSameDistinctPrimeFactors = true;
        for(int j = i-1; j >= i - consecutiveQuantity; j--){
          if(distinctPrimesCount[j]!=consecutiveQuantity)areConsecutiveNumbersWithSameDistinctPrimeFactors = false;
        }
      }

      if(areConsecutiveNumbersWithSameDistinctPrimeFactors){
        System.out.println(i);
        break;
      }
    }
    
    System.out.println(System.currentTimeMillis()-time);
  }
  
  private static int NumberOfPrimeFactors(int num) {
		Set<Integer> primeFactors = new HashSet<>();
		
		for(int i=2;i<=num;i++){
			while(num%i == 0){
				primeFactors.add(i);
				num = num/i;
			}			
		}
		return primeFactors.size();
	}
  
}
