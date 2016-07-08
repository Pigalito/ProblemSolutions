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
public class problem15 {

  /**
   * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.


How many such routes are there through a 20×20 grid?
   */
  public static void main(String[] args) {
    
    int x_Dimension = 20;
    int y_Dimension = 20;
    
    int rows = x_Dimension + y_Dimension + 1;
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
    
    System.out.println(triangleMatrix[x_Dimension + y_Dimension][x_Dimension]);
  }
  
}
