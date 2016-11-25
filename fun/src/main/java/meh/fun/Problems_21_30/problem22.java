/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meh.fun.Problems_21_30;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author n439081
 */
public class problem22 {

  static Map<Character,Integer> alphaValue = new HashMap<Character,Integer>();
  
  /**
   * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.

For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.

What is the total of all the name scores in the file?
   */
  public static void main(String[] args) {
    
    alphaValue.put('A', 1);
    alphaValue.put('B', 2);
    alphaValue.put('C', 3);
    alphaValue.put('D', 4);
    alphaValue.put('E', 5);
    alphaValue.put('F', 6);
    alphaValue.put('G', 7);
    alphaValue.put('H', 8);
    alphaValue.put('I', 9);
    alphaValue.put('J', 10);
    alphaValue.put('K', 11);
    alphaValue.put('L', 12);
    alphaValue.put('M', 13);
    alphaValue.put('N', 14);
    alphaValue.put('O', 15);
    alphaValue.put('P', 16);
    alphaValue.put('Q', 17);
    alphaValue.put('R', 18);
    alphaValue.put('S', 19);
    alphaValue.put('T', 20);
    alphaValue.put('U', 21);
    alphaValue.put('V', 22);
    alphaValue.put('W', 23);
    alphaValue.put('X', 24);
    alphaValue.put('Y', 25);
    alphaValue.put('Z', 26);
    
    String currentLine;
    List<String> names = new LinkedList<>();
    long total = 0;
    
    try {
      BufferedReader is = new BufferedReader(new FileReader("Names.txt"));
      while((currentLine = is.readLine()) != null){
        names = Arrays.asList(currentLine.replaceAll("\"", "").split(","));
      }
    } catch (FileNotFoundException ex) {
      System.out.println("FileNotFoundException");
    } catch (IOException ex) {
      System.out.println("IOException");
    }
    
    System.out.println(names.toString());
    
    Collections.sort(names);
    
    System.out.println(names.toString());
    
    for(int i = 0; i<names.size(); i++){
      int totFromChar = characterCount(names.get(i));
      total += totFromChar*(i+1);
      if(i == 937){
        System.out.println(names.get(i) + " " + totFromChar*(i+1));
      }
      
    }
    
    System.out.println(total);
    
  }
  
  private static int characterCount(String str){
    int total = 0;
    for(Character cha : str.toCharArray()){
      total += alphaValue.get(cha);
    }
    return total;
  }
  
}
