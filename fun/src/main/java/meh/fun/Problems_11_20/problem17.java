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
public class problem17 {

  /**
   * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?


NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.
   */
  
  public static void main(String[] args) {
    double sum = 0;
    for(int i = 0; i <= 1000; i++){
      double characterCount = characterCount(i);
      sum += characterCount;
      System.out.println(i + " " + characterCount);
    }
    System.out.println((int)sum);
  }
  
  public static double characterCount(int num){
    
    String numString = Integer.toString(num);
    
    switch(numString.length()){
      case 1: return unitNameLength(num); // one, two, three, four, etc. 
      case 2: return unitNameLength(num%10) + tensNameLength(numString.charAt(0) - '0'); 
      case 3: double tensAndUnits = unitNameLength(num%10) + tensNameLength(numString.charAt(1) - '0');
              return unitNameLength(numString.charAt(0) - '0') + 7 + tensAndUnits + (tensAndUnits!=0?3:0);
      case 4: return 11; // gonna be one thousand
    }
    
    return 0;
  }
  
  public static int unitNameLength(int unit){
    switch(unit){
      case 1: return 3;
      case 2: return 3;
      case 3: return 5;
      case 4: return 4;
      case 5: return 4;
      case 6: return 3;
      case 7: return 5;
      case 8: return 5;
      case 9: return 4;
      case 0: return 0;
    }
    return 0;
  }
  
  public static double tensNameLength(int tens){
    switch(tens){
      case 1: return 3.4;
      case 2: return 6;
      case 3: return 6;
      case 4: return 5;
      case 5: return 5;
      case 6: return 5;
      case 7: return 7;
      case 8: return 6;
      case 9: return 6;
      case 0: return 0;
    }
    return 0;
  }
  
}
