/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meh.fun.Problems_41_50;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so the first ten triangle numbers are:

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

By converting each letter in a word to a number corresponding to its alphabetical position and adding these values we form a word value. For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle number then we shall call the word a triangle word.

Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common English words, how many are triangle words?
 */
public class problem42 {

  static Map<Character,Integer> alphaValue = new HashMap<Character,Integer>();
  
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws FileNotFoundException, IOException {
    
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
    
    int triangleWordCount = 0;
    
    Integer[] triangleNumbers = new Integer[1000];
    
    for(int num = 1; num <= triangleNumbers.length; num++){
      triangleNumbers[num-1] = triangleNumber(num);
    }
    
    List<Integer> triangleList = Arrays.asList(triangleNumbers);
    List<String> words = new ArrayList<>();
    
    BufferedReader br = new BufferedReader(new FileReader("words.txt"));
    String currentLine;
    while((currentLine = br.readLine()) != null){
      words = Arrays.asList(currentLine.replaceAll("\"", "").split(","));
    }
    
    for(String word : words){
      if(triangleList.contains(characterCount(word))){
        triangleWordCount++;
      }
    }
    
    System.out.println(triangleWordCount);
    
  }
  
  private static int triangleNumber(int num){
    double firstMultiplier = (num/2.0);
    int secondMultiplier = (num+1);
    double result = firstMultiplier * secondMultiplier;
    return (int) result;
  }
  
  private static int characterCount(String str){
    int total = 0;
    for(Character cha : str.toCharArray()){
      total += alphaValue.get(cha);
    }
    return total;
  }
  
}
