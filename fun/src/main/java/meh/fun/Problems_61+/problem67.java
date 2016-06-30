/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meh.fun;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author n439081
 */
public class problem67 {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    List<List<Integer>> triangleString = new ArrayList<>();
    List<List<Integer>> triangleTotals = new ArrayList<>();
    String currentLine;
    
    try {
      BufferedReader is = new BufferedReader(new FileReader("problem67Triangle.txt"));
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
