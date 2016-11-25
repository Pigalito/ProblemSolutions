/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meh.fun.Problems_31_40;

import java.util.HashMap;

/**
 *
 * @author n439081
 */
public class problem34 {

  static HashMap<Integer,Integer> factorials = new HashMap<>(); 
  
  /**
   * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

Find the sum of all numbers which are equal to the sum of the factorial of their digits.

Note: as 1! = 1 and 2! = 2 are not sums they are not included.
   */
  public static void main(String[] args) {
    factorials.put(0,1);
    factorials.put(1,1);
    factorials.put(2,2);
    factorials.put(3,6);
    factorials.put(4,24);
    factorials.put(5,120);
    factorials.put(6,720);
    factorials.put(7,5040);
    factorials.put(8,40320);
    factorials.put(9,362880);
    
//    System.out.println(factorialiseDigits(145));
//    System.out.println(factorialiseDigits(101));
//    System.out.println(factorialiseDigits(6431));
//    System.out.println(factorialiseDigits(1346));
    
    int result = 0;
    
    for(int currentNumber = 3; currentNumber < 10000000; currentNumber++){
      int digitsFactorialised = factorialiseDigits(currentNumber);
      if (digitsFactorialised == currentNumber){
        System.out.println(currentNumber + " " + digitsFactorialised);
        result += currentNumber;
      }
    }
    
    System.out.println(result);
    
  }
  
  private static int factorialiseDigits(int number){
    int sum = 0;
    
    int numLength = Integer.toString(number).length();
    
    for(int numIndex = 0; numIndex < numLength; numIndex++){
      int curDigit = (int) (number/Math.pow(10,numIndex))%10;
      sum += factorials.get(curDigit);
    }
    
    return sum;
  }
  
  
  
}
