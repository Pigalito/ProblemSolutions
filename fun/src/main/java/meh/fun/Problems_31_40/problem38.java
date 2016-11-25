/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meh.fun.Problems_31_40;

/**
 *
 * Take the number 192 and multiply it by each of 1, 2, and 3:

192 × 1 = 192
192 × 2 = 384
192 × 3 = 576
By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the concatenated product of 192 and (1,2,3)

The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).

What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with (1,2, ... , n) where n > 1?
 */
public class problem38 {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    
    long time = System.currentTimeMillis();
    
    int largestPandigital = 0;
    
    long currentConcatenation;
    
    for (int curNum = 1; curNum<=9876; curNum++){
      currentConcatenation = curNum;
      for(int i = 2; i <= 9; i++){
        currentConcatenation = concatenateInts(currentConcatenation, curNum*i);
        if(hasMoreThan9Digits(currentConcatenation))break;
        if(has9DistinctNonZeroDigits(currentConcatenation)){
          if(largestPandigital<currentConcatenation){
            largestPandigital = (int) currentConcatenation;
            System.out.println(largestPandigital + " " + curNum);
          }
          break;
        }
      }
    }
    
    System.out.println((System.currentTimeMillis()-time)/1000.0 + " seconds");
    
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
  
  private static boolean hasMoreThan9Digits(long number){
    return Long.toString(number).length() > 9;
  }
  
  private static long concatenateInts(long num1, long num2){
    return Long.parseLong(Long.toString(num1) + Long.toString(num2));
  }
  
}
