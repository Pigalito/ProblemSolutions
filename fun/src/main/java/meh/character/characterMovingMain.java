/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meh.character;

import java.util.Scanner;

/**
 *
 * @author n439081
 */
public class characterMovingMain{

  Integer[] arenaDimensions = {12,6}; // {x,y}
  Integer[] characterCoords = {1,1}; // {x,y}
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    characterMovingMain ch = new characterMovingMain();
    Scanner input = new Scanner(System.in);
    while(true){
      ch.printArena();
      String dirInput = input.next();
      if (dirInput.equals("e")){
        break;
      }
      ch.adjustCharacterCoords(dirInput);
    }
    
  }

  private void adjustCharacterCoords(String direction){
    if (direction.equals("u")){
      characterCoords[1]--;
    } else if (direction.equals("d")){
      characterCoords[1]++;
    } else if (direction.equals("l")){
      characterCoords[0]--;
    } else if (direction.equals("r")){
      characterCoords[0]++;
    } else {
      System.out.println("unsupported action");
    }
    
    if(characterCoords[0] == arenaDimensions[0] - 1) characterCoords[0] = 1;
    if(characterCoords[0] == 0) characterCoords[0] = arenaDimensions[0] - 2;
    if(characterCoords[1] == arenaDimensions[1] - 1) characterCoords[1] = 1;
    if(characterCoords[1] == 0) characterCoords[1] = arenaDimensions[1] - 2;
    
  }

  private void printArena(){
    StringBuilder[] arena = new StringBuilder[arenaDimensions[1]];
    for(int y = 0; y < arenaDimensions[1]; y++){
      StringBuilder row = new StringBuilder();
      for(int x = 0; x < arenaDimensions[0]; x++){
        if( y == 0 || y == arenaDimensions[1] - 1){
          row.append("-");
        }else{
          if( x == 0 || x == arenaDimensions[0] - 1){
            row.append("|");
          }else if( x == characterCoords[0] && y == characterCoords[1]){
            row.append("O");
          }else{
            row.append(".");
          }
        }
      }
      arena[y] = row;
    }
    
    for(StringBuilder row : arena){
      System.out.println(row);
    }
    
  }
  
}
