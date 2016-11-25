/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meh.fun.Problems_31_40;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author n439081
 */
public class problem37 {

  /**
   * The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.

Find the sum of the only eleven primes that are both truncatable from left to right and right to left.

NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
   */
  public static void main(String[] args) {
//    System.out.println(removeFirstDigit(123456789, 9));
//    System.out.println(removeLastDigit(123456789));
    
    long time = System.currentTimeMillis();

    List<Integer> truncatablePrimes = new ArrayList<>();
    
    int currentNum = 22;
    
    while(truncatablePrimes.size() != 11){
      currentNum++;
      
      if(!isPrime(currentNum))continue;
      
      boolean isTruncPrime = true;
      int length = Integer.toString(currentNum).length();
      
      int currentFirstDigitsRemoval = currentNum;
      int currentLastDigitsRemoval = currentNum;
      
      for (int i = 0; i < length -1 ; i++){
         currentFirstDigitsRemoval = removeFirstDigit(currentFirstDigitsRemoval,length - i);
         currentLastDigitsRemoval = removeLastDigit(currentLastDigitsRemoval);
         
         if(!isPrime(currentFirstDigitsRemoval) || !isPrime(currentLastDigitsRemoval)){
           isTruncPrime = false;
//           System.out.println(currentNum + " " + currentFirstDigitsRemoval + " " + currentLastDigitsRemoval);
           break;
         }
         
      }
      
      if(isTruncPrime){
        truncatablePrimes.add(currentNum);
        System.out.println(currentNum);
      }
      
    }
    
    int result = 0;
    
    for(int num: truncatablePrimes){
      result += num;
    }
    
    System.out.println(result);
    System.out.println((System.currentTimeMillis()-time)/1000.0 + " seconds");
    
  }
  
  private static boolean isPrime(int n) {
    if(n < 2) return false;
    if(n == 2 || n == 3) return true;
    if(n%2 == 0 || n%3 == 0) return false;
    long sqrtN = (long)Math.sqrt(n)+1;
    for(long i = 6L; i <= sqrtN; i += 6) {
      if(n%(i-1) == 0 || n%(i+1) == 0) return false;
    }
    return true;
  }
  
  private static int removeFirstDigit(int n, int length){
    double fullNum = n/(Math.pow(10,length-1));
    int firstDigit = (int) Math.floor(fullNum);
    double decimal = fullNum-firstDigit;
    return (int) Math.round(((fullNum-firstDigit)*Math.pow(10,length-1)));
  }
  
  private static int removeLastDigit(int n){
    return (int)n/10;
  }
  
}
