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
public class problem6 {

  /**
   * The sum of the squares of the first ten natural numbers is,

12 + 22 + ... + 102 = 385
The square of the sum of the first ten natural numbers is,

(1 + 2 + ... + 10)2 = 552 = 3025
Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
   */
  public static void main(String[] args) {
    
    int maxNum = 100;
    
    int totalSum = 0;
    
    long sumOfSquares = 0;
    
    for(int num = 1; num <= maxNum; num++){
      totalSum+=num;
      
      sumOfSquares += Math.pow(num, 2);
    }
    
    long squareOfSum = totalSum*totalSum;
    
    System.out.println(squareOfSum - sumOfSquares);
  }
  
}
