/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meh.fun.Problem_Utilities;

/**
 *
 * @author n439081
 */
public class GenerationException extends Exception{
  
  public GenerationException(String msg){
    super(msg);
  }
  
  public GenerationException(String msg, Exception ex){
    super(msg, ex);
  }
  
}
