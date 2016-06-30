/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package meh.fun;

/**
 *
 * @author n439081
 */
public class problem35 {
  
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    int result = 0;
    for(int i = 1; i < 1000000; i++){
      int tempNum = i;
      if(isPrime(i)){
        
        boolean areAllPrime = true;
        
        for(int j = 0; j < Integer.toString(i).length() - 1; j++){
          
          int when0ToBeAdded = -1;
          
          if(isLastDigitZero(tempNum))when0ToBeAdded = j + 1;
          
          tempNum = rotateInt(tempNum,j == when0ToBeAdded);
          
          if(!isPrime(tempNum)){
            areAllPrime = false;
            break;
          }
          
//          System.out.println(i + " " + tempNum + " " + isPrime(tempNum));
        }
        
        if(areAllPrime){
          result++;
          System.out.println(i);
        }
        
      }
    }
    
    System.out.println(result);
  }
  
  
  private static int rotateInt(int number, boolean isZeroNeeded){
    
    int lastDigit = number%10;
    
    if(isZeroNeeded)return Integer.parseInt(lastDigit + "0" + (int) number/10);
    return Integer.parseInt(lastDigit + "" + (int) number/10);
    
  }
  
  private static boolean isLastDigitZero(int number){
    return number%10 == 0;
  }
  
  private static boolean isPrime(long n) {
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
