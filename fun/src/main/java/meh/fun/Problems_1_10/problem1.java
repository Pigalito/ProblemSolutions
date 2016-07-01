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
public class problem1 {

  /**
   * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.
   */
  public static void main(String[] args) {
    
    int result = 0;
    
    for(int num = 1; num < 1000; num++){
      
      if( num%5 == 0 || num%3 == 0 ){
        result+=num;
      }
      
    }
    
    System.out.println(result);
    
  }
  
}
