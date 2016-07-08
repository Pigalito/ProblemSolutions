/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meh.fun.Problems_1_10;

/**
 *
 * @author n439081
 */
public class problem9 {

  /**
   * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

a^2 + b^2 = c2
For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
   */
  public static void main(String[] args) {
    
    int result = 0;
    
    for (int a = 1; a < 334; a++){
      for(int b = a; b < (1000-a)/2; b++){
        int c = 1000 - a - b;
        if(Math.pow(a,2) + Math.pow(b,2) == Math.pow(c,2)){
          result = a*b*c;
        }
      }
    }
    
    System.out.println(result);
    
  }
  
}
