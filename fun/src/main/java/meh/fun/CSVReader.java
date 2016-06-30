/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meh.fun;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.MalformedInputException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author n439081
 */
public class CSVReader {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args){
    File csv = new File("src/main/resources/ListenerChangesCSV.csv");
    String[] charsets = {"US-ASCII","ISO-8859-1","UTF-8","UTF-16BE","UTF-16LE","UTF-16"};
//    for (String charset : Charset.availableCharsets().keySet()){
    for (String charset : charsets){
      try {
        Files.readAllLines(
          Paths.get(csv.getAbsolutePath()),
          Charset.forName(charset)
        );
      } catch (IOException ex) {
        System.out.println(charset + " threw exception: " + ex.toString());
      }
    }
    
    System.out.println("Default: " + Charset.defaultCharset());
  }
  
}
