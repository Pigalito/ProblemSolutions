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
public class problem16 {

  /**
   * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 2^1000?
   */
  public static void main(String[] args) {
    BigInteger power_2 = new BigInteger("2");
    
    power_2 = power_2.pow(1000);
    
    String power_2String = power_2.toString();
    
    long sum = 0;
    
    for(int index = 0; index < power_2String.length(); index++){
      sum += power_2String.charAt(index) - '0';
    }
    
    System.out.println(sum);
  }
  
}
