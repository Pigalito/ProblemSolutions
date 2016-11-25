/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meh.fun.Problems_61_up;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author n439081
 */
public class problem203 {

  /**
   * The binomial coefficients nCk can be arranged in triangular form, Pascal's triangle, like this:

1	
1		1	
1		2		1	
1		3		3		1	
1		4		6		4		1	
1		5		10		10		5		1	
1		6		15		20		15		6		1	
1		7		21		35		35		21		7		1
.........
It can be seen that the first eight rows of Pascal's triangle contain twelve distinct numbers: 1, 2, 3, 4, 5, 6, 7, 10, 15, 20, 21 and 35.

A positive integer n is called squarefree if no square of a prime divides n. Of the twelve distinct numbers in the first eight rows of Pascal's triangle, all except 4 and 20 are squarefree. The sum of the distinct squarefree numbers in the first eight rows is 105.

Find the sum of the distinct squarefree numbers in the first 51 rows of Pascal's triangle.
   */
  static boolean[] primes;
  
  public static void main(String[] args) {
    
    long starttime = System.currentTimeMillis();
    
    // 51C25 = 2.4795927e+14
    // sqrt(51C25) = 15746722.4042
    // limit of a long = 9.223372e+18
    
    int rowCount = 50;
    int primeCount = 15750000;
    
//    int rowCount = 7;
//    int primeCount = 100;
    
    long total = 0;
    
    primes = new boolean[primeCount];
    primes[0] = false;   
    primes[1] = false;   // 1
    primes[2] = true;    // 2
    primes[3] = true;    // 3
    
    for(int i = 4; i < primes.length; i++){
      primes[i]=isPrime(i);
      if(i%1000000==0){
        System.out.println(i);
      }
    }
    
//    for(int i = 1; i < 100; i++){
//      System.out.println(i + ". " + primes[i]);
//    }
    
    List<Long> squarePrimes = new ArrayList<>();
    
//    long[] squaredPrimes = new long[1000000];
//    int squarePrimeindex = 0;
    
    for(long i = 0; i < primes.length; i++){
      if(primes[(int) i]){
        squarePrimes.add(i*i);
      }
    }
    
    Set<Long> pascalNums = new LinkedHashSet<>();
    List<Long> squareFreeNums = new ArrayList<>();
    
    
    for(long i = 2; i <= rowCount; i++){
      for(long j = 0; j <= i ; j++){
        pascalNums.add(factorial(i,j));
      }
    }
    
    for(Long pascalNum : pascalNums){
      boolean toBeAdded = true;
      for(Long squarePrime : squarePrimes){
        if(squarePrime > pascalNum) break;
        if(pascalNum%squarePrime==0){
          toBeAdded = false;
          break;
        }
      }
      if(toBeAdded){
        squareFreeNums.add(pascalNum);
      }
    }
    
    System.out.println("Full Triangle: ");
    for (Long pascalNum : pascalNums){
      System.out.print(" " + pascalNum + " ");
    }
    
    System.out.println("\nSquarefree Triangle: ");
    for (Long pascalNum : squareFreeNums){
      System.out.print(" " + pascalNum + " ");
      total += pascalNum;
    }
    
    System.out.println("\n" + total);
    
    System.out.println("\n" + (System.currentTimeMillis() - starttime)/1000.0 + " secs");
  }
  
  private static boolean isPrime(int n){
    for(int i = 1; i <= Math.sqrt(n); i++){
      if(primes[i]){
        if(n%i==0){
          return false;
        }
      }
    }
    return true;
  }
  
  private static long factorial(long n, long m){
    BigDecimal top = new BigDecimal(1);
    BigDecimal bottom1 = new BigDecimal(1);
    BigDecimal bottom2 = new BigDecimal(1);
    
    if(m==0 || m==n)return 1;
    if(m==1 || m==(n-1))return n;
    
    for(int i = 1; i <= n; i++){
      top = top.multiply(new BigDecimal(i));
      if(i==m)bottom1 = top;
      if(i==(n-m))bottom2=top;
    }
    
    long result = top.divide(bottom1.multiply(bottom2)).longValue();
    
    return result;
  };
  
}
