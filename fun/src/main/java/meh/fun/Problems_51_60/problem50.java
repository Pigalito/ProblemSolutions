/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meh.fun.Problems_51_60;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author n439081
 */
public class problem50 {

  /**
   * The prime 41, can be written as the sum of six consecutive primes:

41 = 2 + 3 + 5 + 7 + 11 + 13
This is the longest sum of consecutive primes that adds to a prime below one-hundred.

The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.

Which prime, below one-million, can be written as the sum of the most consecutive primes?
   */
  public static void main(String[] args) {
    
    int max = 1000000;
    Map<String,Integer> largestSequenceInfo = new HashMap<>();
    
    largestSequenceInfo.put("sequenceLength", 0);
    largestSequenceInfo.put("sequenceSum", 0);
    
    List<Integer> primes = new LinkedList<>();
    
    for(int i = 0; i <= max; i++){
      if(isPrime(i))primes.add(i);
    }
    
    System.out.println(Arrays.toString(primes.toArray()));
    
    for(int startingPrimeIndex = 0; startingPrimeIndex < primes.size(); startingPrimeIndex++){
      int sum = 0;
      int nextPrimeIndex = startingPrimeIndex;
      while(sum < max && nextPrimeIndex < primes.size()){
        sum += primes.get(nextPrimeIndex);
        if(isPrime(sum) && 
                sum > largestSequenceInfo.get("sequenceSum") && 
                (nextPrimeIndex + 1 - startingPrimeIndex) >= largestSequenceInfo.get("sequenceLength") &&
                sum < max){
          largestSequenceInfo.put("sequenceLength", nextPrimeIndex + 1 - startingPrimeIndex);
          largestSequenceInfo.put("sequenceSum", sum);
        }
        nextPrimeIndex++;
      }
      
    }
    
    System.out.println(largestSequenceInfo.get("sequenceSum") + " " + largestSequenceInfo.get("sequenceLength"));
    
  }
  
  private static boolean isPrime(int n) {
    if(n < 2) return false;
    if(n == 2 || n == 3) return true;
    if(n%2 == 0 || n%3 == 0) return false;
    long sqrtN = (long)Math.sqrt(n)+1;
    for(long i = 6L; i <= sqrtN; i += 6) {
      if(n%(i-1) == 0 || n%(i+1) == 0) return false;
    }
    return true;
  }
  
}
