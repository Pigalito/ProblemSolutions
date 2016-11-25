/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meh.fun.Problems_31_40;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author n439081
 */
public class problem32 {

  /**
   * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.

The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.

Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.

HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
   */
  public static void main(String[] args) {
    
    long starttime = System.currentTimeMillis();
    
    int result = 0;
    Set<Integer> uniqueProducts = new HashSet<>();
    
    int higherFactorStart = 4999;
    
    for(int lowerFactor = 1; lowerFactor < 100; lowerFactor++){
      
      if(lowerFactor>=10)higherFactorStart=999;
      
      for(int higherFactor = higherFactorStart; higherFactor > 100; higherFactor--){
        int product = lowerFactor*higherFactor;
        long concatenatedInt = Long.parseLong(product + "" + higherFactor + "" + lowerFactor);
        if(has9DistinctNonZeroDigits(concatenatedInt)){
          System.out.println(lowerFactor + " x " + higherFactor + " = " + product);
          uniqueProducts.add(product);
        }
      }
    }
    
    for(int prod : uniqueProducts){
      result+=prod;
    }
    System.out.println(result);
    System.out.println((System.currentTimeMillis() - starttime)/1000.0 + " seconds");
    
//    System.out.println(has9DistinctNonZeroDigits(123456789));
//    System.out.println(has9DistinctNonZeroDigits(1234567890));
//    System.out.println(has9DistinctNonZeroDigits(1234567891));
//    System.out.println(has9DistinctNonZeroDigits(123456780));

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
  
  private static boolean hasDistinctDigits(long number){
    int numMask = 0;
    int numLength = Long.toString(number).length();
    
    for(int numIndex = 0; numIndex < numLength; numIndex++){
      double curDigit = (int) (number/Math.pow(10,numIndex))%10;
      int digitMask = (int) Math.pow(2,curDigit);
      if((numMask & digitMask) > 0) return false;
      numMask = numMask | digitMask; 
    }
    return true;
  }
  
  private static boolean has9Digits(long number){
    return ((int) Math.ceil(Math.log10(number+1))) == 9;
  }
  
  
  
}
