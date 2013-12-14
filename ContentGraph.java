import java.util.*;
import javafoundations.*;
import Jama.*;
import ciphers.Cipher;
import ciphers.CaesarCipher;
import ciphers.VigenereCipher;
import ciphers.AffineCipher;
import ciphers.HillCipher;

public class ContentGraph {
  
  private Level rome, tuscany, venice, quad, tupelo, hoop, tunnels, clapp;
  private AdjMatGraphPlus<Level> gameGraph;
  
  public ContentGraph () {
    CaesarCipher cc = new CaesarCipher(3);
    rome = new Level(cc, "Content/Ancient_Rome.txt", "Ancient Rome", "Beware of the Ides of March");
    
    VigenereCipher vc = new VigenereCipher("Wendy");
    tuscany = new Level(vc, "Content/Tuscany.txt", "Tuscany", "The Medici family kills all who protest to their power.");
    venice = new Level(vc, "Content/Venice.txt", "Venice", "The pirates attacked our ship! We need reinforcements.");
    
    AffineCipher ac = new AffineCipher(9, 3, 3);
    quad = new Level(ac, "Content/Academic_Quad_1940.txt", "Academic Quad 1940", "Storm the tower! First person to the top gets ice cream!");
    tupelo = new Level(ac, "Content/Tupelo_Lane_May_1,_1940.txt", "Tupelo Lane May 1 1940", "Martha Attridge");
    hoop = new Level(ac, "Content/Cafè_Hoop_1981.txt", "Cafè Hoop 1981", "Make Nachos.");
    tunnels = new Level(ac, "Content/Wellesley_Tunnels_1990.txt", "Wellesley Tunnels 1990", "Watch out there is asbestos!");
    
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
    inv[0][
           1] = 8;
    inv[1][0] = 8;
    inv[1][1] = 1;
    Matrix keyInv = new Matrix(inv);
    HillCipher hc = new HillCipher(key, shiftVal, keyInv);
    clapp = new Level(hc, "Content/Clapp_Library.txt", "Clapp Library", "HI");
    
    gameGraph = new AdjMatGraphPlus<Level>();
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
  }
  
  public AdjMatGraphPlus<Level> getGameGraph () {
    return this.gameGraph;
  }
  
  public Level getRome () {
    return this.rome;
  }
  
  public Level getTuscany () {
    return this.tuscany;
  }
  
  public Level getVenice () {
    return this.venice;
  }
  
  public Level getQuad () {
    return this.quad;
  }
  
  public Level getTupelo () {
    return this.tupelo;
  }
  
  public Level getHoop () {
    return this.hoop;
  }
  
  public Level getTunnels () {
    return this.tunnels;
  }
  
  public Level getClapp () {
    return this.clapp;
  }
  
}

