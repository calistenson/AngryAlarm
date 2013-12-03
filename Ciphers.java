/**
 * Ciphers.java
 * Authors: Cali Stenson and Clara Smith
 * This Method holds all of the cipher functions 
 * for the code cracker class.
 */ 

import Jama.*;

public class Ciphers{
  
  /**
   * No instance variables are used since class is 
   * just independent functions
   */ 
  
  /**
   * Constructor  
   * Default constructor for this class since it's 
   * used for functional purposes.
   */ 
  public Ciphers(){}
  
  /**
   * Method: encryptCaesar()
   * @param shiftVal int
   * @param message String
   * @return String
   * 
   * Method encrypts a message using a Caesar or shift cipher
   */ 
  public String encryptCaesar(int shiftVal, String message){
    int newIndex;
    String encrypted = "";
    message = message.toUpperCase();
    char[] messageLet = message.toCharArray();
    for(int i=0; i<message.length(); i++){
      newIndex = messageLet[i] + shiftVal;
      newIndex = ((newIndex > 'Z') ? 'A'+(newIndex - 'Z')-1: newIndex);
      encrypted += (char) newIndex;
    }
    return encrypted;
  }
  
  public String decryptCaesar(int shiftVal, String message){
    int newIndex;
    String decrypted = "";
    message = message.toUpperCase();
    char[] messageLet = message.toCharArray();
    for(int i=0; i<message.length(); i++){
      newIndex = messageLet[i] - shiftVal;
      newIndex = ((newIndex < 'A') ? 'Z'-('A'-newIndex)+1: newIndex);
      decrypted += (char) newIndex;
    }
    return decrypted;
  }
  
  public String encryptVigenere(String keyword, String message){
    int newIndex;
    int p = 0; //index of the password added to message char
    int shiftVal = 0; //shift for the message char
    String encrypted = "";
    message = message.toUpperCase();
    char[] messageLet = message.toCharArray();
    for(int i=0; i<message.length(); i++){
      shiftVal = (int) keyword.charAt(p) - 'A';
      newIndex = messageLet[i] + shiftVal;
      newIndex = ((newIndex > 'Z') ? 'A'+(newIndex - 'Z')-1: newIndex);
      encrypted += (char) newIndex;
      p = (p+1) % keyword.length();
    }
    return encrypted;
  }
  
  public String decryptVigenere(String keyword, String message){
    int newIndex;
    int p = 0; //index of the password added to message char
    int shiftVal = 0; //shift for the message char
    String decrypted = "";
    message = message.toUpperCase();
    char[] messageLet = message.toCharArray();
    for(int i=0; i<message.length(); i++){
      shiftVal = (int) keyword.charAt(p) - 'A';
      newIndex = messageLet[i] - shiftVal;
      newIndex = ((newIndex < 'A') ? 'Z'-('A'-newIndex)+1: newIndex);
      decrypted += (char) newIndex;
      p = (p+1) % keyword.length();
    }
    return decrypted;
  }
  
  /**
   * NOTE: the keyVal must be relatively prime to 26.
   */ 
  public String encryptAffine(int keyVal, int shiftVal, String message){
    int newIndex;
    String encrypted = "";
    message = message.toUpperCase();
    char[] messageLet = message.toCharArray();
    for(int i=0; i<message.length(); i++){
      newIndex = 'A' + ( (keyVal * (messageLet[i]-'A') + shiftVal) % 26);
      newIndex = ((newIndex > 'Z') ? 'A'+(newIndex - 'Z')-1: newIndex);
      encrypted += (char) newIndex;
    }
    return encrypted;
  }
  
  public String decryptAffine(int keyValInvrse, int shiftVal, String message){
    int newIndex;
    String decrypted = "";
    message = message.toUpperCase();
    char[] messageLet = message.toCharArray();
    for(int i=0; i<message.length(); i++){
      newIndex = 'A' + (keyValInvrse*((messageLet[i] - 'A') - shiftVal)) % 26;
      newIndex = ((newIndex < 'A') ? 'Z'-('A'-newIndex)+1: newIndex);
      decrypted += (char) newIndex;
    }
    return decrypted;
  }
  
  public String encryptHill(Matrix key, Matrix shiftVal, String message){
    char[] messLets = message.toCharArray();
    int[] charVals = new int[messLets.length];
    String encrypted = "";
    int newIndex = 0;
    for(int i=0; i<messLets.length; i++){
      charVals[i] = messLets[i] - 'A';
    }
    if(charVals.length % 2 == 0){
      for(int i=0; i<charVals.length-1; i++){
        double[] charval = {(double)charVals[i], charVals[i+1]};
        Matrix letters = new Matrix(charval, 2);
        Matrix encrptd = (key.times(letters)).plus(shiftVal);
        newIndex = 'A' + (int)(encrptd.get(0,0) % 26);
        encrypted += (char) newIndex;
        newIndex = 'A' + (int)(encrptd.get(1,0) % 26);
        encrypted += (char) newIndex;
      }
    }else{
      double[] charval = {(double)charVals[0], -1};
      Matrix letters = new Matrix(charval, 2);
      Matrix encrptd = (key.times(letters)).plus(shiftVal);
      newIndex = 'A' + (int)(encrptd.get(0,0) % 26);
      encrypted += (char) newIndex;
      for(int i=1; i<charVals.length-1; i++){
        charval[0] = (double)charVals[i];
        charval[1] = charVals[i+1];
        letters = new Matrix(charval, 2);
        encrptd = (key.times(letters)).plus(shiftVal);
        newIndex = 'A' + (int)(encrptd.get(0,0) % 26);
        encrypted += (char) newIndex;
        newIndex = 'A' + (int)(encrptd.get(1,0) % 26);
        encrypted += (char) newIndex;
      }
    }
    
    return encrypted;
    
  }
  
  public String decryptHill(Matrix key, Matrix shiftVal, String message){
    key = key.inverse();
    System.out.println(key.getArrayCopy());
    for(int i=0; i<key.getRowDimension(); i++){
      for(int j=0; j<key.getColumnDimension(); j++){
        int fix = (int)key.get(i, j);
        System.out.println("Fix: " + fix);
        while(fix < 0){
            fix += 26;
            System.out.println("Fix was less than zero" + fix);
        }
        fix = fix % 26;
        key.set(i, j, fix);
      }
    }  
    char[] messLets = message.toCharArray();
    int[] charVals = new int[messLets.length];
    String decrypted = "";
    int newIndex = 0;
    for(int i=0; i<messLets.length; i++){
      charVals[i] = messLets[i] - 'A';
    }
    if(charVals.length % 2 == 0){
      for(int i=0; i<charVals.length-1; i++){
        double[] charval = {(double)charVals[i], charVals[i+1]};
        Matrix letters = new Matrix(charval, 2);
        Matrix decrptd = key.times(letters.minus(shiftVal));
        newIndex = 'A' + (int)(decrptd.get(0,0) % 26);
        decrypted += (char) newIndex;
        newIndex = 'A' + (int)(decrptd.get(1,0) % 26);
        decrypted += (char) newIndex;
      }
    }else{
      double[] charval = {(double)charVals[0], -1};
      Matrix letters = new Matrix(charval, 2);
      Matrix decrptd = key.times(letters.minus(shiftVal));
      newIndex = 'A' + (int)(decrptd.get(0,0) % 26);
      decrypted += (char) newIndex;
      for(int i=1; i<charVals.length-1; i++){
        charval[0] = (double)charVals[i];
        charval[1] = charVals[i+1];
        letters = new Matrix(charval, 2);
        decrptd = (key.times(letters.minus(shiftVal)));
        newIndex = 'A' + (int)(decrptd.get(0,0) % 26);
        decrypted += (char) newIndex;
        newIndex = 'A' + (int)(decrptd.get(1,0) % 26);
        decrypted += (char) newIndex;
      }
    }
    
    return decrypted;
    
  }
  
  public String encryptExp(){return "";}
  
  public String decryptExp(){return "";}
  
  public static void main(String[] args){
    
    Ciphers c = new Ciphers();
    System.out.println(c.encryptCaesar(3, "ABC"));
    System.out.println(c.decryptCaesar(3, "DEF"));
    System.out.println(c.encryptCaesar(26, "CALI"));
    System.out.println(c.decryptCaesar(26, "CALI"));
    System.out.println(c.decryptCaesar(3, c.encryptCaesar(3, "COIN")));
    System.out.println(c.encryptVigenere("LEMON", "ATTACKATDAWN"));
    System.out.println(c.decryptVigenere("LEMON", "LXFOPVEFRNHR"));
    System.out.println(c.decryptAffine(9, 3, c.encryptAffine(3, 3, "CALI"))); 
    System.out.println(c.decryptAffine(9, 3, c.encryptAffine(3, 3, "SUPERCALIFRAGILISTICEXPIALADOCIOUS")));
    
    double[][] k = new double[2][2];
    k[0][0] = 9;
    k[0][1] = 6;
    k[1][0] = 6;
    k[1][1] = 5;
    Matrix key = new Matrix(k);
    double[][] shift = new double[2][1];
    Matrix shiftVal = new Matrix(shift);
    System.out.println(c.encryptHill(key, shiftVal, "HI"));
    System.out.println(c.decryptHill(key, shiftVal, "HE"));
    

    
  }//end main()
  
  
  
  
  
}  