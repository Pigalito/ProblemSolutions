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
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * The following undirected network consists of seven vertices and twelve edges with a total weight of 243.


The same network can be represented by the matrix below.

    	A	B	C	D	E	F	G
A	-	16	12	21	-	-	-
B	16	-	-	17	20	-	-
C	12	-	-	28	-	31	-
D	21	17	28	-	18	19	23
E	-	20	-	18	-	-	11
F	-	-	31	19	-	-	27
G	-	-	-	23	11	27	-
However, it is possible to optimise the network by removing some edges and still ensure that all points on the network remain connected. The network which achieves the maximum saving is shown below. It has a weight of 93, representing a saving of 243 − 93 = 150 from the original network.


Using network.txt (right click and 'Save Link/Target As...'), a 6K text file containing a network with forty vertices, and given in matrix form, find the maximum saving which can be achieved by removing redundant edges whilst ensuring that the network remains connected.
 */
public class problem107 {
  
  List<Integer> pointsTraversed = new LinkedList<>();

  /**
   * @param args the command line arguments
   * @throws java.io.FileNotFoundException
   */
  public static void main(String[] args) throws FileNotFoundException, IOException {
    
    problem107 p107 = new problem107();
    
    int vertices = 40;
    
    Integer[][] lines = new Integer[vertices][vertices];
    Integer[][] refinedLines = new Integer[vertices][vertices];
    
    long startTime = System.currentTimeMillis();
    
    BufferedReader br = new BufferedReader(new FileReader("network.txt"));
    String currentLine;
    int index = 0;
    while((currentLine = br.readLine()) != null){
      lines[index] = p107.turnLineToArray(currentLine);
      index++;
    }
    
    List<List<Integer>> allSeperateNetworks = p107.generateStartingListOfPointLists(vertices);
    
    p107.printListOfLists(allSeperateNetworks);
    
    while(allSeperateNetworks.size() > 1){
      for(int listIndex = 0; listIndex < allSeperateNetworks.size(); listIndex++){
        Map<String,Integer> smallestNetworkConnection = p107.findSmallestNetworkConnection(allSeperateNetworks.get(listIndex),allSeperateNetworks,listIndex,lines);
        allSeperateNetworks.get(listIndex).addAll(allSeperateNetworks.get(smallestNetworkConnection.get("destinationListIndex")));
        allSeperateNetworks.remove((int) smallestNetworkConnection.get("destinationListIndex"));
        refinedLines[smallestNetworkConnection.get("sourcePoint")][smallestNetworkConnection.get("destinationPoint")] = smallestNetworkConnection.get("value");
        refinedLines[smallestNetworkConnection.get("destinationPoint")][smallestNetworkConnection.get("sourcePoint")] = smallestNetworkConnection.get("value");
        p107.printListOfLists(allSeperateNetworks);
      }
    }
    
    int resultSumRefined = p107.arrayofArraysSummation(refinedLines);
    int resultSumFull = p107.arrayofArraysSummation(lines);
    
    System.out.println("Full result: " + resultSumFull/2);
    System.out.println("Refined result: " + resultSumRefined/2);
    System.out.println("Final Result: " + (resultSumFull/2 - resultSumRefined/2));
    System.out.println("Time Taken: " + (System.currentTimeMillis() - startTime)/1000.0);
  }
  
  /**
   * 
   * @param arrays
   * @return 
   */
  public int arrayofArraysSummation(Integer[][] arrays){
    int result = 0;
    for(Integer[] row : arrays){
      for(Integer integer: row){
        if(integer!=null){
          result+=integer;
        }
      }
    }
    return result;
  }
  
  /**
   * 
   * @param line
   * @return 
   */
  public Integer[] turnLineToArray(String line){
    String[] lineSegments = line.split(",");
    Integer[] result = new Integer[lineSegments.length];
    
    int index = 0;
    for(String lineSegment : lineSegments){
      if(!lineSegment.equals("-")){
        result[index] = Integer.parseInt(lineSegment);
      }
      index++;
    }
    
    return result;
  }  

  /**
   * 
   * @param allSeperateNetworks 
   */
  public void printListOfLists(List<List<Integer>> allSeperateNetworks){
    for(List<Integer> list: allSeperateNetworks){
      System.out.println(Arrays.toString(list.toArray()));
    }
    System.out.println("");
  }
  
  /**
   * 
   * @param sourceList
   * @param allSeperateNetworks
   * @param sourceListIndex
   * @param lines
   * @return 
   */
  public Map<String,Integer> findSmallestNetworkConnection(List<Integer> sourceList, List<List<Integer>> allSeperateNetworks, int sourceListIndex, Integer[][] lines){
    Map<String,Integer> smallestNetworkConnection = new HashMap<>();
    smallestNetworkConnection.put("value", 99999);
    smallestNetworkConnection.put("sourcePoint", 0);
    smallestNetworkConnection.put("destinationPoint", 0);
    smallestNetworkConnection.put("destinationListIndex", 0);
    
    for(int destinationListIndex = 0; destinationListIndex < allSeperateNetworks.size(); destinationListIndex++){
      if(destinationListIndex!=sourceListIndex){
        for(Integer sourcePoint: sourceList){
          for(Integer destinationPoint: allSeperateNetworks.get(destinationListIndex)){
            if(lines[sourcePoint][destinationPoint]!=null &&
                    lines[sourcePoint][destinationPoint] < smallestNetworkConnection.get("value")){
              smallestNetworkConnection.put("value", lines[sourcePoint][destinationPoint]);
              smallestNetworkConnection.put("sourcePoint", sourcePoint);
              smallestNetworkConnection.put("destinationPoint", destinationPoint);
              smallestNetworkConnection.put("destinationListIndex", destinationListIndex);
            }
          }
        }
      }
    }
    
    return smallestNetworkConnection;
    
  }

  /**
   * 
   * @param length
   * @return 
   */
  public List<List<Integer>> generateStartingListOfPointLists(int length){
    List<List<Integer>> listOfLists = new LinkedList<>();
    
    for(int i = 0; i < length; i++){
      List<Integer> singlePointList = new LinkedList<>();
      singlePointList.add(i);
      listOfLists.add(singlePointList);
    }
    
    return listOfLists;
  }

  
  /* -------- USED IN CASE YOU WANT TO CHECK IF THE CURRENT NETWORK IS FULLY CONNECTED --------
  public boolean checkAllPointsConnected(Integer[][] lines){
    
    boolean areAllPointsConnected = true;
    
    //keep track of traversed points for each A -> X path finding
    pointsTraversed.add(0);
    
    //Loop for all non A points
    for(int i = 1; i<lines.length; i++){
      int goal = i;
      
      boolean routeSuccessfullyFound = false;
      
      //End search if A is already connected
      if(lines[0][goal] != null)continue;
      
      //Iterate through each point
      for(int j = 1; j<lines.length; j++){
        
        //Move onto next point if same as what we're looking for
        if(j==i)continue;
        
        //Make sure A is connected to point before searching it
        if(lines[0][j]!=null){
          
          //Recursive look up to see if the point or any of the points 
          //it's connected to are connected to the goal point
          //If we get a successful connection then break out of the loop 
          //and are all points connected will remain true
          if(doesLineContainEntry(lines,goal,j)){
            routeSuccessfullyFound = true;
            break;
          }
        }
      }
      
      areAllPointsConnected = routeSuccessfullyFound;
      
      pointsTraversed.clear();
      
      if(!areAllPointsConnected){
        break;
      }
    }
    
    return areAllPointsConnected;
  }
  

  private boolean doesLineContainEntry(Integer[][] lines, int goal, int lineIndex){
    
    //Make sure this method isn't called again for this point
    pointsTraversed.add(lineIndex);
    
    //Return true if this point is connected to the goal
    if(lines[lineIndex][goal]!=null){
      return true;
    }
    
    //Assume none of the points this point is connected to is the goal
    boolean result=false;
    
    //Iterate through all points
    for(int index = 0; index < lines[lineIndex].length; index++){
      
      //Make sure we don't look at a point that has already been looked at
      if(!pointsTraversed.contains(index)){
        
        //Check point has connection to what we're about to check
        if(lines[lineIndex][index] != null){
          
          // check if point or any connecting points are connected to the goal
          if(doesLineContainEntry(lines,goal,index)){
            result=true;
          }
        }
      }
    }
    
    return result;
    
  }*/
  
  /* -------- ORIGINALLY USED TO RETRIEVE SEPERATE NETWORKS WHEN THERE ARE CONNECTIONS ALREADY -------- FOUND TO BE UNNECESSARY --------
  
  public List<List<Integer>> findAllSeperateNetworks(Integer[][] lines){
    List<List<Integer>> pointsInNetworks = new LinkedList<>();
    
    //We want to iterate over every point to find the network that it is a part of
    for(int i = 0; i < lines.length; i++){
      //If a point is in pointsTraversed then that means it must already be part of a network
      if(!pointsTraversed.contains(i)){
        pointsInNetworks.add(findSeperateNetwork(lines,i));
      }
    }
    pointsTraversed.clear();
    return pointsInNetworks;
  }
  
  private List<Integer> findSeperateNetwork(Integer[][] lines, int startingPoint){
    List<Integer> pointsInNetwork = new LinkedList<>();
    pointsInNetwork.add(startingPoint);
    pointsTraversed.add(startingPoint);
    for(int i = 0; i<lines.length; i++){
      if(!pointsTraversed.contains(i) && lines[startingPoint][i]!=null){
        pointsInNetwork.addAll(findSeperateNetwork(lines,i));
      }
    }
    return pointsInNetwork;
  }*/
  
  /*  -------- CODE CONTAINED IN MAIN METHOD THAT USED SHORTEST LINE METHODS BELOW --------
  
    for(int column = 0; column<vertices; column++){
      for(int row = 0; row<vertices; row++){
        System.out.print(lines[column][row] + " ");
      }
      System.out.println("");
    }
    
    for(int point = 1; point < lines.length; point++){
      Map<String,Integer> shortestLine = findShortestLineToPoint(lines,point);
      refinedLines[shortestLine.get("row")][shortestLine.get("column")] = shortestLine.get("value");
      refinedLines[shortestLine.get("column")][shortestLine.get("row")] = shortestLine.get("value");
    }
    
    System.out.println("");
    
    for(int column = 0; column<vertices; column++){
      for(int row = 0; row<vertices; row++){
        System.out.print(refinedLines[column][row] + " ");
      }
      System.out.println("");
    }*/

  
  /*  -------- METHODS USED FOR FINDING SHORTEST LINE TO A POINT FROM ANY OTHER POINT -------- FOUND TO BE UNNECESSARY --------
  
  private static Map<String, Integer> findShortestLineToPoint(Integer[][] lines, int pointIndex){
    //Want to find the shortest line connecting to a point from our current network
    //Make sure that we don't only include one line between two points as it was the shortest for both.
    
    pointsTraversed.add(0);
    
    Map<String,Integer> shortestLine = new HashMap<>();
    Map<String,Integer> possibleShortestLine = new HashMap<>();
    
    shortestLine.put("value", 99999);
    shortestLine.put("column", 0);
    shortestLine.put("row", 0);
    
    if(lines[0][pointIndex]!=null){
      shortestLine.put("value", lines[0][pointIndex]);
      shortestLine.put("column", pointIndex);
      shortestLine.put("row", 0);
    }
    
    possibleShortestLine.put("value", 99999);
    possibleShortestLine.put("column", 0);
    possibleShortestLine.put("row", 0);
    
    for(int index = 1; index<lines.length; index++){
      //getShortestLineFromPointNetwork will only change possible shortest line if the value is smaller.
      //A built in check so a seperate one would be unnecessary 
      if(lines[0][index]!=null){
        possibleShortestLine = getShortestLineFromPointNetwork(lines, pointIndex, index, possibleShortestLine);
      }
    }
    
    if(shortestLine.get("value") > possibleShortestLine.get("value")){
      shortestLine.put("value", possibleShortestLine.get("value"));
      shortestLine.put("column", possibleShortestLine.get("column"));
      shortestLine.put("row", possibleShortestLine.get("row"));
    }
    
    pointsTraversed.clear();
    return shortestLine;
  }
  
  private static Map<String,Integer> getShortestLineFromPointNetwork(Integer[][] lines, int pointIndex, int currentPoint, Map<String,Integer> possibleShortestLine){
    
    pointsTraversed.add(currentPoint);
    
    //If this point has a direct connection to the desired point and it's shorter then we need to change the possible shortest line
    if(lines[currentPoint][pointIndex]!= null && 
            possibleShortestLine.get("value") > lines[currentPoint][pointIndex]){
      possibleShortestLine.put("value", lines[currentPoint][pointIndex]);
      possibleShortestLine.put("column", pointIndex);
      possibleShortestLine.put("row", currentPoint);
    }
    
    for(int index = 0; index < lines[currentPoint].length; index++){
      
      //Make sure we don't look at a point that has already been looked at
      if(!pointsTraversed.contains(index)){
        
        //Check point has connection to what we're about to check
        if(lines[currentPoint][index] != null){
          
          possibleShortestLine = getShortestLineFromPointNetwork(lines,pointIndex,index,possibleShortestLine);
        }
      }
    }
    
    return possibleShortestLine;
  }*/
  
}
