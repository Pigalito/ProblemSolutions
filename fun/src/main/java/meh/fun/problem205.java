/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meh.fun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author n439081
 */
public class problem205 {

  /**
   * Peter has nine four-sided (pyramidal) dice, each with faces numbered 1, 2, 3, 4.
Colin has six six-sided (cubic) dice, each with faces numbered 1, 2, 3, 4, 5, 6.

Peter and Colin roll their dice and compare totals: the highest total wins. The result is a draw if the totals are equal.

What is the probability that Pyramidal Pete beats Cubic Colin? Give your answer rounded to seven decimal places in the form 0.abcdefg
   */
  public static void main(String[] args) {
    
    long starttime = System.currentTimeMillis();
    double probability = 0.0;
    
    int noOf4SideDie = 9;
    int sidesOn4SideDie = 4;
    int total4Dice = 0;
    
    int noOf6SideDie = 6;
    int sidesOn6SideDie = 6;
    int total6Dice = 0;
    
    int total = 0;
    long factor = 10000000000L;
    
    Integer currentValue = 0;
    
    Map<Integer,Integer> totals4Sides = new HashMap<>();
    Map<Integer,Integer> totals6Sides = new HashMap<>();
    
    for(int i = 1; i <= sidesOn4SideDie; i++){
      for(int j = 1; j <= sidesOn4SideDie; j++){
        for(int k = 1; k <= sidesOn4SideDie; k++){
          for(int l = 1; l <= sidesOn4SideDie; l++){
            for(int n = 1; n <= sidesOn4SideDie; n++){
              for(int m = 1; m <= sidesOn4SideDie; m++){
                for(int x = 1; x <= sidesOn4SideDie; x++){
                  for(int y = 1; y <= sidesOn4SideDie; y++){
                    for(int z = 1; z <= sidesOn4SideDie; z++){
                      total = i+j+k+l+m+n+x+y+z;
//      total = i;
                      if(totals4Sides.containsKey(total)){
                        currentValue = totals4Sides.get(total);
                        totals4Sides.put(total, currentValue + 1);
                      }else{
                        totals4Sides.put(total, 1);
                      }
                    } 
                  }
                }
              } 
            }
          }
        } 
      }
    }
    
    for(Entry entry: totals4Sides.entrySet()){
      System.out.println(entry.getKey() + " " + entry.getValue());
      Integer value = (Integer) entry.getValue();
      total4Dice += value;
    }
    
    for(int i = 1; i <= sidesOn6SideDie; i++){
      for(int j = 1; j <= sidesOn6SideDie; j++){
        for(int k = 1; k <= sidesOn6SideDie; k++){
          for(int l = 1; l <= sidesOn6SideDie; l++){
            for(int n = 1; n <= sidesOn6SideDie; n++){
              for(int m = 1; m <= sidesOn6SideDie; m++){
                total = i+j+k+l+m+n;
//      total = i;
                if(totals6Sides.containsKey(total)){
                  currentValue = totals6Sides.get(total);
                  totals6Sides.put(total, currentValue + 1);
                }else{
                  totals6Sides.put(total, 1);
                }
              } 
            }
          }
        } 
      }
    }
    
    for(Entry entry: totals6Sides.entrySet()){
      System.out.println(entry.getKey() + " " + entry.getValue());
      Integer value = (Integer) entry.getValue();
      total6Dice += value;
    }
    
    for(Integer tot4 : totals4Sides.keySet()){
      for(Integer index = 6; index < tot4; index++){
        double prob4roll = (double)(totals4Sides.get(tot4)/((double)total4Dice));
        double prob6roll = (double)(totals6Sides.get(index)/((double)total6Dice));
        
        probability += Math.round(prob4roll*prob6roll*factor)/(double)factor;
      }
    }
    
    System.out.println(probability);
    
    System.out.println("\n" + (System.currentTimeMillis() - starttime)/1000.0 + " secs");    
    
  }
  
}
