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
public class problem4 {

  /**
   * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.
   */
  public static void main(String[] args) {
    
    int largestPalindrome = 0;
    
    for(int num1 = 100; num1 < 1000; num1++){
      for(int num2 = 100; num2 < 1000; num2++){
        int product = num1*num2;
        
        String prodString = Integer.toString(product);
        
        boolean isPalindrome = true;
        for(int index = 0; index <= prodString.length()/2; index++){
          if(prodString.charAt(index) != prodString.charAt(prodString.length()-index-1)){
            isPalindrome=false;
          }
        }
        
        if(isPalindrome && product > largestPalindrome){
          largestPalindrome = product;
        }
      }
    }
    
    System.out.println(largestPalindrome);
    
  }
  
}
