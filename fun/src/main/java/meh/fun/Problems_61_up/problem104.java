/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meh.fun.Problems_61_up;

import java.math.BigInteger;

/**
 *
 * @author n439081
 */
public class problem104 {

  /**
   * The Fibonacci sequence is defined by the recurrence relation:

Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
It turns out that F541, which contains 113 digits, is the first Fibonacci number for which the last nine digits are 1-9 pandigital (contain all the digits 1 to 9, but not necessarily in order). And F2749, which contains 575 digits, is the first Fibonacci number for which the first nine digits are 1-9 pandigital.

Given that Fk is the first Fibonacci number for which the first nine digits AND the last nine digits are 1-9 pandigital, find k.
   */
  public static void main(String[] args) {
    BigInteger[] fibonaccis = new BigInteger[2];
    fibonaccis[0] = new BigInteger("0");
    fibonaccis[1] = new BigInteger("1");
    
    for(int i = 2; i < 1000000; i++){
      if(i%10000==0)System.out.println(i);
      fibonaccis[i%2] = fibonaccis[0].add(fibonaccis[1]);
      String numString = fibonaccis[i%2].toString();
      if(numString.length()>18){
        if(
                has9DistinctNonZeroDigits(Long.parseLong(numString.substring(0, 9))) 
                && 
                has9DistinctNonZeroDigits(Long.parseLong(numString.substring(numString.length() - 9, numString.length())))
                ){
          System.out.println(i + " " + numString);
        }
      }
    }
    
  }
  
  private static boolean has9DistinctNonZeroDigits(long number){
    
    int numMask = 0;
    int numLength = Long.toString(number).length();
    if(numLength != 9) return false;
        
    for(int numIndex = 0; numIndex < numLength; numIndex++){
      double curDigit = (int) (number/Math.pow(10,numIndex))%10;
      int digitMask = (int) Math.pow(2,curDigit);
      if((numMask & digitMask) > 0) return false;
      numMask = numMask | digitMask; 
    }
    String binNum = Integer.toBinaryString(numMask);
    return binNum.equals("1111111110");
  }
  
}
