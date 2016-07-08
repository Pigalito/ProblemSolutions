/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meh.fun.Problems_11_20;

/**
 *
 * @author n439081
 */
public class problem14 {

  /**
   * The following iterative sequence is defined for the set of positive integers:

n → n/2 (n is even)
n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
   */
  
  static long[] chainLengths = new long[1000000];
  
  public static void main(String[] args) {
    
    long maxCount = 0;
    long maxNum = 0;
    
    for(int startingNum = 1; startingNum < chainLengths.length; startingNum++){
      chainLengths[startingNum - 1] = countChain(startingNum);
      if(maxCount < chainLengths[startingNum - 1]) {
        maxCount = chainLengths[startingNum - 1];
        maxNum = startingNum;
      }
    }
    
    System.out.println(maxCount);
    System.out.println(maxNum);
  }
  
  private static int countChain(long num){
    int count = 1;
    
    while(num!=1){
      
      if(num < 1000000 && chainLengths[(int)num-1] != 0){
        count += chainLengths[(int)num - 1] - 1;
        break;
      }
      
      if(num%2==0){
        num = num/2;
      }else{
        num = 3*num + 1;
      }
      count++;
    }
    
    return count;
  }
  
}
