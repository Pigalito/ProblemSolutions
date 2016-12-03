/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meh.fun.Problem_Utilities;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author n439081
 */
public class PrimesUtils {
  
  public static boolean isPrime(long n){
    
    if(n < 2) return false;
    
    if(n == 2 || n == 3) return true;
    
    if(n%2 == 0 || n%3 == 0) return false;
    
    long sqrtN = (long)Math.sqrt(n)+1;
    
    for(long i = 6L; i <= sqrtN; i += 6) {
      if(n%(i-1) == 0 || n%(i+1) == 0) return false;
    }
    
    return true;
    
  }
  
  public static Set<Long> generatePrimeFactors(long num){
    Set<Long> primeFactors = new HashSet<>();

    for(long i=2;i<=num;i++){
        while(num%i == 0){
            primeFactors.add(i);
            num = num/i;
        }
    }
    
    return primeFactors;
  }
  
  public static List<Long> generatePrimeList(int maximum, GenerationType primeLimitOrCapacity) throws GenerationException{
    
    List<Long> primeNums = new LinkedList<>();
    primeNums.add(2L);
    primeNums.add(3L);
    
    switch (primeLimitOrCapacity) {
      
      case LIMIT:
        for(long currentIndex = 5; currentIndex < maximum; currentIndex+=2){
          if(isPrime(currentIndex))primeNums.add(currentIndex);
        }
        break;
        
      case CAPACITY:
        int numberOfEntriesInList = 2;
        for(long currentNumber = 5; numberOfEntriesInList <= maximum; currentNumber++){
          if(isPrime(currentNumber)){
            primeNums.add(currentNumber);
            numberOfEntriesInList++;
          }
        }
        break;
        
      default:
        throw new GenerationException(primeLimitOrCapacity + " is unsupported");
    }
    
    return primeNums;
  }
}
  

