/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meh.fun;

/**
 *
 * @author n439081
 */
public class problem43 {

  /**
   * The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some order, but it also has a rather interesting sub-string divisibility property.

Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:

d2d3d4=406 is divisible by 2
d3d4d5=063 is divisible by 3
d4d5d6=635 is divisible by 5
d5d6d7=357 is divisible by 7
d6d7d8=572 is divisible by 11
d7d8d9=728 is divisible by 13
d8d9d10=289 is divisible by 17
Find the sum of all 0 to 9 pandigital numbers with this property.
   */
  
  static int[] primes = {2,3,5,7,11,13,17};
  
  static long i;
  
  public static void main(String[] args) {
    
//    has10DistinctNonZeroDigits(2394506810L);
    
    long result = 0;
    long timeStarted = System.currentTimeMillis();
    
    for(i = 1023456789L; i<=9876543210L; i++){
      if(i%100000000==0){
        System.out.println(i);
        System.out.println((System.currentTimeMillis() - timeStarted)/1000.0 + " seconds");
      }
      if(has10DistinctNonZeroDigits(i)){
        if(System.currentTimeMillis() - timeStarted > 5000){
          timeStarted = System.currentTimeMillis();
          System.out.println("After another 5 seconds we're on: " + i);
        }
//        System.out.println(i);
        boolean isSubStringDivisible = true;
        for(int index = 0; index<primes.length; index++){
          if(!is3DigitSubIntDivisibleByPrime(i,index)){
            isSubStringDivisible = false;
            break;
          }
        }
        if(isSubStringDivisible){
          System.out.println("Divisible sub string pandigital: " + i);
          result += i;
        }
      }
    }
    
    System.out.println(result);
    System.out.println(is3DigitSubIntDivisibleByPrime(1406357289,0));
  }
  
  public static boolean is3DigitSubIntDivisibleByPrime(long num, int index){
    int subInt = (int) Long.parseLong(Long.toString(num).substring(index+1,index+4));
    return subInt%primes[index] == 0;
  }
  
  private static boolean has10DistinctNonZeroDigits(long number){
    
    long numMask = 0;
    long numLength = Long.toString(number).length();
    if(numLength != 10) return false;
        
    long rightmostDuplicateIndex = -1;
    boolean resultFlag = true;
   
    for(long numIndex = numLength - 1; numIndex >= 0; numIndex--){
      long curDigit = (long) (number/Math.pow(10,numIndex))%10;
      long digitMask = (long) Math.pow(2,curDigit);
      if((numMask & digitMask) > 0){
        rightmostDuplicateIndex = numIndex;
        resultFlag = false;
      }
      numMask = numMask | digitMask; 
    }
    
    if(rightmostDuplicateIndex != -1)i += Math.pow(10,rightmostDuplicateIndex) - 1;
    
    String binNum = Long.toBinaryString(numMask);
    return resultFlag && binNum.equals("1111111111");
  }
  
  private static int digitAt(long num, int index){
    return Integer.parseInt(Long.toString(num).substring(index, index+1));
  }
  
}
