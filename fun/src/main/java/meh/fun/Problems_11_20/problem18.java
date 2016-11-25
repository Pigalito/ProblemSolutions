/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meh.fun.Problems_11_20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author n439081
 */
public class problem18 {

  /**
   * By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.

3
7 4
2 4 6
8 5 9 3

That is, 3 + 7 + 4 + 9 = 23.

Find the maximum total from top to bottom of the triangle below:

75
95 64
17 47 82
18 35 87 10
20 04 82 47 65
19 01 23 75 03 34
88 02 77 73 07 63 67
99 65 04 28 06 16 70 92
41 41 26 56 83 40 80 70 33
41 48 72 33 47 32 37 16 94 29
53 71 44 65 25 43 91 52 97 51 14
70 11 33 28 77 73 17 78 39 68 17 57
91 71 52 38 17 14 91 43 58 50 27 29 48
63 66 04 68 89 53 67 30 73 16 69 87 40 31
04 62 98 27 23 09 70 98 73 93 38 53 60 04 23

NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. However, Problem 67, is the same challenge with a triangle containing one-hundred rows; it cannot be solved by brute force, and requires a clever method! ;o)
   */
  public static void main(String[] args) {
    
    List<List<Integer>> triangleString = new ArrayList<>();
    List<List<Integer>> triangleTotals = new ArrayList<>();
    String currentLine;
    
    try {
      BufferedReader is = new BufferedReader(new FileReader("problem18Triangle.txt"));
      while((currentLine = is.readLine()) != null){
        List<Integer> row = new ArrayList<>();
        for(String num : currentLine.split(" ")){
          row.add(Integer.parseInt(num));
        }
        triangleString.add(row);
      }
    } catch (FileNotFoundException ex) {
      System.out.println("triangle couldn't be found");
    } catch (IOException ex) {
      
    }
    
    for(int i = 0; i < triangleString.size(); i++){
      List<Integer> currentRow = triangleString.get(i);
      try{
        List<Integer> previousRow = triangleString.get(i-1);
        List<Integer> previousTotalsRow = triangleTotals.get(i-1);
        List<Integer> currentTotalsRow = new ArrayList<>();
        for(int j = 0; j < currentRow.size(); j++){
          
          Integer currentNum = currentRow.get(j);
          try{
            currentTotalsRow.add(Math.max(currentNum + previousTotalsRow.get(j), currentNum + previousTotalsRow.get(j-1)));
          }catch(IndexOutOfBoundsException ex){
            if(j==0){
              currentTotalsRow.add(currentNum + previousTotalsRow.get(j));
            }else{
              currentTotalsRow.add(currentNum + previousTotalsRow.get(j-1));
            }
          }
        }
        triangleTotals.add(currentTotalsRow);
      }catch(ArrayIndexOutOfBoundsException ex){
        triangleTotals.add(currentRow);
      }
      System.out.println(currentRow.toString());
      System.out.println(triangleTotals.get(i).toString());
    }
    
    System.out.println(Collections.max(triangleTotals.get(triangleTotals.size()-1)));
    
  }
  
}
