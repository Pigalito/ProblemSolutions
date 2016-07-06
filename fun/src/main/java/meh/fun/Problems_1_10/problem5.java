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
public class problem5 {

  /**
   * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
   */
  public static void main(String[] args) {
    
    int divisibleTo = 20;
    
    long index = 20;
    
    while(true){
      boolean isStillDivisible = true;
      
      for(int divNum = 1; divNum <= divisibleTo; divNum++){
        if(index%divNum != 0){
          isStillDivisible = false;
          break;
        }
      }
      
      if(isStillDivisible){
        System.out.println(index);
        break;
      }
      
      index+=20;
    }
    
  }
  
}
