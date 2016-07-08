/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meh.fun.Problems_11_20;

import java.math.BigInteger;

/**
 *
 * @author n439081
 */
public class problem20 {

  /**
   * n! means n × (n − 1) × ... × 3 × 2 × 1

For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

Find the sum of the digits in the number 100!
   */
  public static void main(String[] args) {
    
    long sum = 0;
    BigInteger factorial100 = new BigInteger("1");
    
    for(int i = 2; i <= 100; i++){
      factorial100 = factorial100.multiply(new BigInteger(Integer.toString(i)));
    }
    
    String numString = factorial100.toString();
    
    for(int i = 0; i < numString.length(); i++){
      sum += numString.charAt(i) - '0';
    }
    
    System.out.println(sum);
    
  }
  
}
