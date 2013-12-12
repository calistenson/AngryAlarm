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
      levelAccomplished = false;
    }else if(!levelAccomplished){
      System.out.println("Please complete current level");
    }else{
      System.out.println("Please choose appropriate level");
    }
  }
  
  public boolean chooseLevelFromPause(Level last, Level next, String s){
    if (last.getMessage().equals(s)) {
      current = next;
      levelAccomplished = false;
      return true;
    }
    return false;
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
    Level rome = new Level(new CaesarCipher(3), "Ancient_Rome.txt", "Ancient Rome", "Beware of the Ides of March");
    
    VigenereCipher vc = new VigenereCipher("Wendy");
    Level tuscany = new Level(vc, "Tuscany.txt", "Tuscany", "The Medici family kills all who protest to their power.");
    Level venice = new Level(vc, "Venice.txt", "Venice", "The pirates attacked our ship! We need reinforcements.");
    
    AffineCipher ac = new AffineCipher(9, 3, 3);
    Level quad = new Level(ac, "Academic_Quad_1940.txt", "Academic Quad 1940", "Storm the tower! First person to the top gets ice cream!");
    Level tupelo = new Level(ac, "Tupelo_Lane_May_1,_1940.txt", "Tupelo Lane May 1 1940", "Martha Attridge");
    Level hoop = new Level(ac, "Caf_Hoop_1981.txt", "Caf Hoop 1981", "Make Nachos.");
    Level tunnels = new Level(ac, "Wellesley_Tunnels_1990.txt", "Wellesley Tunnels 1990", "Watch out there is asbestos!");
    
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
    Level clapp = new Level(hc, "Clapp_Library.txt", "Clapp Library", "HI");
    
    AdjMatGraphPlus<Level> gameGraph = new AdjMatGraphPlus<Level>();
    gameGraph.addVertex(rome);
    gameGraph.addVertex(tuscany);
    gameGraph.addVertex(venice);
    gameGraph.addVertex(quad);
    gameGraph.addVertex(tupelo);
    gameGraph.addVertex(hoop);
    gameGraph.addVertex(tunnels);
    gameGraph.addVertex(clapp);
    
    gameGraph.addArc(rome, tuscany);
    gameGraph.addArc(rome, venice);
    gameGraph.addArc(tuscany, quad);
    gameGraph.addArc(tuscany, tupelo);
    gameGraph.addArc(venice, hoop);
    gameGraph.addArc(venice, tunnels);
    gameGraph.addArc(quad, clapp);
    gameGraph.addArc(tupelo, clapp);
    gameGraph.addArc(hoop, clapp);
    gameGraph.addArc(tunnels, clapp);
    
    CodeCracker game = new CodeCracker(gameGraph);
    game.playLevel("Beware of the Ides of March");
    game.chooseNewLevel(tuscany);
    game.playLevel("The Medici family kills all who protest to their power.");
    game.chooseNewLevel(quad);
    game.playLevel("Storm the tower! First person to the top gets ice cream!");
    game.playLevel("ladsfjsaldfjsdjf");
    
    
    
    
  }
  
  /* ADD YOUR CODE HERE */
  
}
