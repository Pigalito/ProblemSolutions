/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meh.fun.Problems_41_50;

/**
 *
 * @author n439081
 */
public class problem49 {

  /**
   * The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways: (i) each of the three terms are prime, and, (ii) each of the 4-digit numbers are permutations of one another.

There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property, but there is one other 4-digit increasing sequence.

What 12-digit number do you form by concatenating the three terms in this sequence?
   */
  public static void main(String[] args) {
    
    for(int firstTerm=10000; firstTerm < 99999; firstTerm++){
      
      if(!isPrime(firstTerm))continue;
      
      String firstTermNumMask = getNumMaskForNumber(firstTerm);
      
      int secondTerm = firstTerm;
      int thirdTerm = firstTerm;
      int aritmeticAddition = 0;
      
      while(thirdTerm < 100000){
        
        aritmeticAddition++;
        secondTerm = firstTerm + aritmeticAddition;
        thirdTerm = firstTerm + 2*aritmeticAddition;
        
        if(!isPrime(secondTerm))continue;
        if(!isPrime(thirdTerm))continue;
        
        String secondTermNumMask = getNumMaskForNumber(secondTerm);
        if(!firstTermNumMask.equals(secondTermNumMask))continue;
        
        String thirdTermNumMask = getNumMaskForNumber(thirdTerm);
        if(!firstTermNumMask.equals(thirdTermNumMask))continue;
        
        System.out.println(firstTerm + " " + secondTerm + " " + thirdTerm);
      }
    }
  }
  
  private static String getNumMaskForNumber(int number){
    
    int numMask = 0;
    int numLength = Integer.toString(number).length();
    
    for(int numIndex = 0; numIndex < numLength; numIndex++){
      double curDigit = (int) (number/Math.pow(10,numIndex))%10;
      int digitMask = (int) Math.pow(2,curDigit);
      numMask = numMask | digitMask; 
    }
//    String binNum = Integer.toBinaryString(numMask);
    return Integer.toBinaryString(numMask);
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
  
}
