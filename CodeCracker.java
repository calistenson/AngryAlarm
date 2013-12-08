/**
 * CodeCracker.java
 * Authors: Cali Stenson and Clara Smith
 * Date: December 6, 2013
 * Course: Wellesley College CS230-Data Structures 
 * Semester: Fall 2013
 * This class creates and operates the game itself using
 * the ciphers package and the level class for construction.
 */

import java.util.*;
import javafoundations.*;

public class CodeCracker {
  
  AdjMatGraphPlus<Level> levels;
  HashMap codes = new HashMap();
  Level current;
  boolean levelAccomplished;
  
  public CodeCracker(AdjMatGraphPlus<Level> gameGraph) { 
    levels = gameGraph;
    constructMap();
    current = levels.allSources().get(0);//with game graph the must be only one source to start with
    levelAccomplished = false;
  }
  
  private HashMap constructMap(){
    LinkedList<Level> listLevs = levels.topologicalSort();
    for(int i=0; i<listLevs.size(); i++){
      Level curr = listLevs.get(i);
      codes.put(curr.getMessage(), curr.getCipher().encrypt(curr.getMessage()));
    }
    return codes;
  }
  
  public boolean playLevel(String decoded){
    if(current.getMessage().equals(decoded)){
      levelAccomplished = true;
      return true;
    }else{
      System.out.println("Decoded message incorrect");
      levelAccomplished = false;
      return false;
    }
  }  
  
  public void chooseNewLevel(Level l){
    if(levels.isArc(current, l) && levelAccomplished){
      current = l;
    }else if(!levelAccomplished){
      System.out.println("Please complete current level");
    }else{
      System.out.println("Please choose appropriate level");
    }
  }  
    
    
  
  public static void main(String[] args) { 
    
  }
  
  /* ADD YOUR CODE HERE */
  
}
