/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meh.fun.Problems_21_30;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author n439081
 */
public class problem23 {

  /**
   * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.

Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
   */
  public static void main(String[] args) {
    
    List<Integer> abundantNums = new ArrayList<>();
    Set<Integer> abundantSums = new HashSet<>();
    int total = 0;
    int MAX=50000;
    
    for (int i = 1; i <= MAX; i++){
      if(isAbundant(i)){
        abundantNums.add(i);
      }
    }
    
    for (Integer num1 : abundantNums){
      for (Integer num2 : abundantNums){
        abundantSums.add(num2+num1);
      }
    }
    
    for (int i = 1; i <= MAX; i++){
      if(!abundantSums.contains(i)){
        System.out.println(i);
        total += i;
      }
    }
    
    System.out.println(total);
    
  }
  
  private static boolean isAbundant(int n){
    List<Integer> factors = factors(n);
    int total = 0;
    for(Integer factor: factors){
      total += factor;
    }
    if(total > n) {
      return true;
    }else{
      return false;
    }
  }
  
  private static List<Integer> factors(int n){
    List<Integer> factors = new ArrayList<>();
    for (int i = 1; i <= n/2; i++){
      if(n%i==0)factors.add(i);
    }
    return factors;
  }
  
}
