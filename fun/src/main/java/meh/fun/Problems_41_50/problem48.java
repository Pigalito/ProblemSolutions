/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meh.fun.Problems_41_50;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author n439081
 */
public class problem48 {

  /**
   * The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.

Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
   */
  public static void main(String[] args) {
    
    BigInteger sum = new BigInteger("1");
    
    for(int i = 2; i < 1000; i++){
      sum = sum.add(new BigInteger(Integer.toString(i)).pow(i));
    }
  
    System.out.println(sum);
    
  }
  
}
