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
public class problem33 {

  /**
   * The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.

We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.

If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
   */
  public static void main(String[] args) {
    
    int numeratorTens;
    int numeratorUnit;
    int denominatorTens;
    int denominatorUnit;
    
    for(int numerator = 10; numerator <= 98; numerator++){
      for(int denominator = numerator + 1; denominator <= 99; denominator++){
        double decimalValue = divide(numerator,denominator);
        
        numeratorTens = (numerator/10)%10;
        denominatorTens = (denominator/10)%10;
        numeratorUnit = numerator%10;
        denominatorUnit = denominator%10;
        
        if(denominatorUnit == 0 || numeratorUnit == 0){
          continue;
        }
        
        if(divide(numeratorTens,denominatorTens) == decimalValue && numeratorUnit == denominatorUnit){
          System.out.println(numerator + "/" + denominator + " = " + numeratorTens + "/" + denominatorTens);
        }
        if(divide(numeratorUnit,denominatorTens) == decimalValue && numeratorTens == denominatorUnit){
          System.out.println(numerator + "/" + denominator + " = " + numeratorUnit + "/" + denominatorTens);
        }
        if(divide(numeratorTens,denominatorUnit) == decimalValue && numeratorUnit == denominatorTens){
          System.out.println(numerator + "/" + denominator + " = " + numeratorTens + "/" + denominatorUnit);
        }
        if(divide(numeratorUnit,denominatorUnit) == decimalValue && numeratorTens == denominatorTens){
          System.out.println(numerator + "/" + denominator + " = " + numeratorUnit + "/" + denominatorUnit);
        }
      }
    }
    
  }
  
  private static double divide(int a, double b){
    return a/(double)b;
  }
  
}
