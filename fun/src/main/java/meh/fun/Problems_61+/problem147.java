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
public class problem147 {

  /**
   * In a 3x2 cross-hatched grid, a total of 37 different rectangles could be situated within that grid as indicated in the sketch.


There are 5 grids smaller than 3x2, vertical and horizontal dimensions being important, i.e. 1x1, 2x1, 3x1, 1x2 and 2x2. If each of them is cross-hatched, the following number of different rectangles could be situated within those smaller grids:

1x1: 1 
2x1: 4 
3x1: 8 
1x2: 4 
2x2: 18

Adding those to the 37 of the 3x2 grid, a total of 72 different rectangles could be situated within 3x2 and smaller grids.

How many different rectangles could be situated within 47x43 and smaller grids?
   */
  public static void main(String[] args) {
    
    int maxX = 3;
    int maxY = 3;
    
    Integer[][] rectangles = new Integer[maxX][maxY];
    
    for(int x = 1; x <= maxX; x++){
      for(int y = 1; y <= maxY; y++){
        
        rectangles[x-1][y-1] = sum(x)*sum(y);           // All Horizontal and Vertical rectangles, no diagonals
        if(!(y==1&&x==1)){                              // There's no diagonal rectangle in a 1x1 square
          if(y==1||x==1){
            rectangles[x-1][y-1] += Math.max(x,y)-1;    // If one side is only 1 square long then the only diagonal rectangles are those in the gaps
          }else{
            
            int maxwidth = 0;
            
          }
        }
      }
    }
    
    System.out.println("Debug here!!");
  }
  
  public static int sum(int num){
    int result = 0;
    
    for(int i = 1; i <= num; i++){
      result+=i;
    }
    
    return result;
  }
  
}
