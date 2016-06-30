/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meh.character;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author n439081
 */
public class NoughtsAndCrosses {

  int x = 3;
  int y = 3;
  boolean isVictory = false;
  
  Player player = Player.O;
  
  String horizontalBar = "-----";
  
  private String[][] values = new String[y][x];
  
  public static void main(String[] args) {
    NoughtsAndCrosses nc = new NoughtsAndCrosses();
    nc.replaceNulls();
    while(!nc.isVictory){
      nc.takeGo();
      nc.printBoard();
      nc.player = nc.player.getNextPlayer();
    }
    System.out.println(nc.player.toString() + " wins!!");
  }
  
  private void replaceNulls(){
    for (int i = 0; i < y; i++){
      for (int j = 0; j < x; j++){
        if (values[i][j]==null) values[i][j] = " ";
      }
    }
  }
  
  private void printBoard(){
    for(int i = 0; i < y; i++){
      String row = Arrays.asList(values[i]).toString().replace(", ", "|");
      System.out.println(row.substring(1, row.length()-1));
      if(i!=y-1)System.out.println(horizontalBar);
    }
  }
  
  private void takeGo(){
    
    Scanner input = new Scanner(System.in);
    String[] coordStrings = input.next().split(",");
    
    int[] coords = new int[coordStrings.length];
    coords[0] = Integer.parseInt(coordStrings[0]);
    coords[1] = Integer.parseInt(coordStrings[1]);
    
    if(!values[coords[1]][coords[0]].equals(" ")){
      System.out.println("Invalid entry given");
      takeGo();
      return;
    }
    
    values[coords[1]][coords[0]] = player.toString();
    
    for (Direction direction : Direction.values()){
      if(is3InARow(player.toString(),direction,coords)){
        isVictory = true;
        break;
      }
    }
  }
  
  private boolean is3InARow(String player, Direction direction, int[] coords){
    
    boolean result = true;
    coords = direction.initialCoordSetUp(direction, coords);
    
    for(int i = 0; i < 3; i++){
      if(!values[coords[1]][coords[0]].equals(player)){
        result = false;
        break;
      }
      coords = direction.coordIncrement(direction, coords);
    }
    
    return result;
    
  }
  
  private enum Direction {
    UpRightDiagonal,
    DownRightDiagonal,
    Vertical,
    Horizontal;
    
    public int[] initialCoordSetUp(Direction direction, int[] coords){
      switch (direction){
        case UpRightDiagonal:
          coords[0] = 0;
          coords[1] = 2;
          break;
        default:
          coords[0] = 0;
          coords[1] = 0;
          break;
      }
      return coords;
    }
    
    public int[] coordIncrement(Direction direction, int[] coords){
      switch (direction){
        case UpRightDiagonal:
          coords[0]++;
          coords[1]--;
          break;
        case DownRightDiagonal:
          coords[0]++;
          coords[1]++;
          break;
        case Vertical:
          coords[1]++;
          break;
        case Horizontal:
          coords[0]++;
          break;
      }
      return coords;
    }
    
  }
  
  private enum Player {
    O("O"),
    X("X");
    
    private Player(final String text) {
      this.text = text;
    }

    private final String text;
    
    @Override
    public String toString() {
      return text;
    }
    
    public Player getNextPlayer(){
      switch(this.text){
        case "O":
          return Player.X;
        case "X":
          return Player.O;
        default:
          return null;
      }
    }
    
  }
}
