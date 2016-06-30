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
public class problem52 {

  /**
   * It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different order.

Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
   */
  public static void main(String[] args) {
    
//    System.out.println(generateNumMask(9876543210L));
//    System.out.println(generateNumMask(999999999L));
//    System.out.println(generateNumMask(1122334455L));
//    System.out.println(generateNumMask(5544332211L));
//    System.out.println(generateNumMask(6574839209L));

    long time = System.currentTimeMillis();

    for(int i = 123459; i<=166666;i+=6){
      long numMask = generateNumMask(i);
      
      if(numMask == generateNumMask(2*i)){
        if(numMask == generateNumMask(3*i)){
          if(numMask == generateNumMask(4*i)){
            if(numMask == generateNumMask(5*i)){
              if(numMask == generateNumMask(6*i)){
                System.out.println(i);
                break;
              } 
            }
          }
        }
      }
      
    }

    System.out.println(System.currentTimeMillis()-time);
    
  }
  
  private static long generateNumMask(long num){
    int length = Long.toString(num).length();
    
    long digitMask=0;
    
    for(int digitIndex = 0; digitIndex<length; digitIndex++){
      long digit = ((long)(num/Math.pow(10, digitIndex)))%10;
      digitMask+=Math.pow(10,digit);
    }
    
    return digitMask;
    
  }
  
}
