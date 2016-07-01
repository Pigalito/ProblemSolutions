/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meh.fun;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author n439081
 */
public class problem26 {

  /**
   * A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:

1/2	= 	0.5
1/3	= 	0.(3)
1/4	= 	0.25
1/5	= 	0.2
1/6	= 	0.1(6)
1/7	= 	0.(142857)
1/8	= 	0.125
1/9	= 	0.(1)
1/10	= 	0.1
Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.

Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
   */
  public static void main(String[] args) {
    
    long starttime = System.currentTimeMillis();
    
    Map<String,Object> max = new HashMap<>();
    
    max.put("period", 0);
    max.put("i", 0);
    max.put("repeated decimal", 0);
    
    String regex = "(\\d+?)\\1\\1\\1\\1";
    Pattern p = Pattern.compile(regex);
    
    String regex1 = "(\\d+?)\\1\\1\\1\\1";
    Pattern pa = Pattern.compile(regex1);
    
    for(int i = 1; i <= 1000; i++){
      BigDecimal index = new BigDecimal(i);
      BigDecimal dividor = new BigDecimal(10).pow(10000);
      BigDecimal fraction = dividor.divide(index,RoundingMode.FLOOR);
      
//      System.out.println(fraction);
      Matcher matcher = p.matcher(fraction.toString());
      if(matcher.find()){
//        System.out.println(i + "  " + fraction);
//        System.out.println(i + "  " + matcher.group(1) + "  " + matcher.group(1).length());
        
        if((Integer) max.get("period") <= matcher.group(1).length()){
          
          Matcher matcher1 = p.matcher(new BigDecimal(10).pow(200000).divide(index,RoundingMode.FLOOR).toString());
          max.put("period", matcher.group(1).length());
          max.put("i", i);
          max.put("repeated decimal", matcher.group(1));
          System.out.println(max.get("i") + "  " + max.get("period") + "  " + max.get("repeated decimal"));
        }
      }
    }
    
    System.out.println("\n" + (System.currentTimeMillis() - starttime)/1000.0 + " secs");
    
  }
  
  
  
}
