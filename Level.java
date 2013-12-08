/**
 * Level.Java
 * Authors: Cali Stenson and Clara Smith 
 * Date: December 5, 2013
 * Course: Wellesley College CS230-Data Structures 
 * Semester: Fall 2013
 * Level objects are used as an integral part of the code cracker 
 * game as nodes within the graph of the game. The levels hold 
 * information to be accessed in the CodeCracker class.
 */

import ciphers.Cipher;
import java.io.*;

public class Level {
  
  /**
   * Instance Variables 
   */ 
  private Cipher cipherType;
  private String message;
  private File storyLine;
  
  /**
   * Default Constructor
   */ 
  public Level(){};
  
  /**
   * Constructor that allows user to set cipherType and storyLine
   * @param c Cipher
   * @param s File
   */ 
  public Level(Cipher c, File s, String mess) { 
    cipherType = c;
    storyLine = s;  
    message = mess;
  }
  
  
  /**
   * Getter method 
   * @return Cipher
   */ 
  public Cipher getCipher(){
    return cipherType;
  }
  
  /**
   * Setter method
   * @param c Cipher
   */ 
  public void setCipher(Cipher c){
    cipherType = c;
  }
  
  /**
   * Getter method 
   * @return String
   */ 
  public String getMessage(){
    return message;
  }
  
  /**
   * Setter method
   * @param mess String
   */ 
  public void setMessage(String mess){
    message = mess;
  }
  
  /**
   * Getter Method
   * @return File
   */ 
  public File getStoryLine(){
    return storyLine;
  }
 
  /**
   * Setter method
   * @param c Cipher
   */ 
  public void setStoryLine(File s){
    storyLine = s;
  }
  
  /**
   * Class does not include a main method because the level class is similar to
   * a node and does not have any complicated methods.
   */ 
  
}
