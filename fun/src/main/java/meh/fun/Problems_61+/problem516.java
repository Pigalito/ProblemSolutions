/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meh.fun;

/**
 *
 * 5-smooth numbers are numbers whose largest prime factor doesn't exceed 5.
5-smooth numbers are also called Hamming numbers.
Let S(L) be the sum of the numbers n not exceeding L such that Euler's totient function φ(n) is a Hamming number.
S(100)=3728.

Find S(1012). Give your answer modulo 232.
 */
public class problem516 {

  
  static int[] primes = {2,3,5};
  
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
  
    long starttime = System.currentTimeMillis();
    
    for(long i = 0; i <= 1000000000000L; i++){
      if(i%10000000000L==0)System.out.println(i);
      if(doesNoPrimeFactorGT5Exist(i)){
//        System.out.println(i);
      }
    }
//    doesNoPrimeFactorGT5Exist(15);
    
    System.out.println("\n" + (System.currentTimeMillis() - starttime)/1000.0 + " secs");
    
  }
  
  private static boolean doesNoPrimeFactorGT5Exist(long n){
    while(n > 5){
      boolean stillDivisible = false;
      for(int prime : primes){
        if(n%prime==0) {
          n = n/prime;
          stillDivisible = true;
        }
      }
      if(!stillDivisible){
        return false;
      }
    }
    return true;
  };
  
  private static long totientFunction(long n){
    long noOfCoprimes = 0;
    
    return n;
  }
  
}
