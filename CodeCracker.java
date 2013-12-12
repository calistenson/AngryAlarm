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
import Jama.*;
import ciphers.Cipher;
import ciphers.CaesarCipher;
import ciphers.VigenereCipher;
import ciphers.AffineCipher;
import ciphers.HillCipher;

public class CodeCracker {
  
  AdjMatGraphPlus<Level> levels;
  HashMap<String,String> codes = new HashMap();
  Level current;
  boolean levelAccomplished;
  
  public CodeCracker(AdjMatGraphPlus<Level> gameGraph) { 
    levels = gameGraph;
    current = levels.allSources().get(0);//with game graph the must be only one source to start with
    constructMap();
    levelAccomplished = false;
  }
  
  private HashMap constructMap(){
    LinkedList<Level> listLevs = levels.DFS(current);
    for(int i=0; i<listLevs.size(); i++){
      Level curr = listLevs.get(i);
      String message = curr.getMessage();
      String encrypted = curr.getCipher().encrypt(curr.getMessage());
      codes.put(message, encrypted);
    }
    return codes;
  }
  
  public boolean playLevel(String decoded){
    if(current.getMessage().equals(decoded)){
      levelAccomplished = true;
      System.out.println("Level " + current.getName() + " completed!");
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
  
  public String codedMessage(Level l){
    String message = l.getMessage();
    String coded = codes.get(message);
    return coded;
  }  
  
  public Level getCurrentLevel() {
    return current;
  }
  
  
  
  public static void main(String[] args) { 
    //(Cipher c, String storyFile, String name, String mess)
    Level one = new Level(new CaesarCipher(3), "Ancient_Rome.txt", "Ancient Rome", "Beware of the Ides of March");
    
    VigenereCipher vc = new VigenereCipher("Wendy");
    Level twoA = new Level(vc, "Tuscany.txt", "Tuscany", "The Medici family kills all who protest to their power.");
    Level twoB = new Level(vc, "Venice.txt", "Venice", "The pirates attacked our ship! We need reinforcements.");
    
    AffineCipher ac = new AffineCipher(9, 3, 3);
    Level threeA = new Level(ac, "Academic_Quad_1940.txt", "Academic Quad 1940", "Storm the tower! First person to the top gets ice cream!");
    Level threeB = new Level(ac, "Tupelo_Lane_May_1,_1940.txt", "Tupelo Lane May 1 1940", "Martha Attridge");
    Level threeC = new Level(ac, "Caf_Hoop_1981.txt", "Caf Hoop 1981", "Make Nachos.");
    Level threeD = new Level(ac, "Wellesley_Tunnels_1990.txt", "Wellesley Tunnels 1990", "Watch out there is asbestos!");
    
    double[][] k = new double[2][2];
    k[0][0] = 9;
    k[0][1] = 6;
    k[1][0] = 6;
    k[1][1] = 5;
    Matrix key = new Matrix(k);
    double[][] shift = new double[2][1];
    Matrix shiftVal = new Matrix(shift);
    double[][] inv = new double[2][2]; 
    inv[0][0] = 15;
    inv[0][1] = 8;
    inv[1][0] = 8;
    inv[1][1] = 1;
    Matrix keyInv = new Matrix(inv);
    HillCipher hc = new HillCipher(key, shiftVal, keyInv);
    Level four = new Level(hc, "New Jersey Princeton University.txt", "Jersey", "HI");
    
    AdjMatGraphPlus<Level> gameGraph = new AdjMatGraphPlus<Level>();
    gameGraph.addVertex(one);
    gameGraph.addVertex(twoA);
    gameGraph.addVertex(twoB);
    gameGraph.addVertex(threeA);
    gameGraph.addVertex(threeB);
    gameGraph.addVertex(threeC);
    gameGraph.addVertex(threeD);
    gameGraph.addVertex(four);
    
    gameGraph.addArc(one, twoA);
    gameGraph.addArc(one, twoB);
    gameGraph.addArc(twoA, threeA);
    gameGraph.addArc(twoA, threeB);
    gameGraph.addArc(twoB, threeC);
    gameGraph.addArc(twoB, threeD);
    gameGraph.addArc(threeA, four);
    gameGraph.addArc(threeB, four);
    gameGraph.addArc(threeC, four);
    gameGraph.addArc(threeD, four);
    
    CodeCracker game = new CodeCracker(gameGraph);
    game.playLevel("Beware of the Ides of March");
    game.chooseNewLevel(twoA);
    game.playLevel("The Medici family kills all who protest to their power.");
    game.chooseNewLevel(threeA);
    game.playLevel("Storm the tower! First person to the top gets ice cream!");
    game.playLevel("ladsfjsaldfjsdjf");
    
    
    
    
  }
  
  /* ADD YOUR CODE HERE */
  
}
