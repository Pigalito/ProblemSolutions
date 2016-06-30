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
public class easyPascalTriangle {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    
    int rows = 20;
    int columns = rows;
    
    long[][] triangleMatrix = new long[rows][columns];
    
    for(int i = 0; i < rows; i++){
      triangleMatrix[i][0] = 1;
      triangleMatrix[i][i] = 1;
    }
    
    for(int i = 1; i < rows; i++){
      for(int j = 1; j <= i; j++){
        triangleMatrix[i][j] = triangleMatrix[i-1][j-1] + triangleMatrix[i-1][j];
      }
    }
    
    System.out.println("\n\n\n\n");
    
    for(int i = 0; i < rows; i++){
      for(int j = 0; j <= i; j++){
        System.out.print(triangleMatrix[i][j] + " ");
      }
      System.out.println("\n");
    }
    
  }
  
}
