/**
 * HillCipher.java
 * Authors: Cali Stenson and Clara Smith
 * Date: December 5, 2013
 * Course: Wellesley College CS230-Data Structures 
 * Semester: Fall 2013
 * This class is a HillCipher object used to 
 * encrypt and decrypt Hill Ciphers 
 * Note: only uses a 2x2 matrix for encrypting and decrypting so that
 * our user will be able to encode and decode the ciphers easily by hand.
 * The functions here could be expanded to convert all of the letters 
 * using a square matrix corresponding to the message's length the way 
 * Hill is intended to work; however, an inverse of this matrix could
 * be hard for the user to decode and since our game is intended to 
 * teach ciphers we created a simpler version of the cipher for the
 * game's purposes. 
 */ 

package ciphers;
import Jama.*;


public class HillCipher extends Cipher{
  
  /**
   * Instance Variables
   * Matrix key (to encode the messages)
   * Matrix shiftVal (used to encode and decode)
   * Matrix keyInverse (to decode the messages)
   */ 
  Matrix key;
  Matrix shiftVal;
  Matrix keyInverse;
  
  /**
   * Constructor
   * @param a Matrix
   * @param k Matrix
   * @param inv Matrix
   */ 
  public HillCipher(Matrix k, Matrix s, Matrix inv) {
    key = k;
    shiftVal = s;
    keyInverse = inv;
  } 
  
  /**
   * getter method
   * @return Matrix
   */ 
  public Matrix getKey(){
    return key;
  }
  
  /**
   * setter method 
   * @param k Matrix
   */ 
  public void setKey(Matrix k){
    key = k;
  }
  
  
  /**
   * getter method
   * @return Matrix
   */ 
  public Matrix getShift(){
    return shiftVal;
  }
  /**
   * setter method 
   * @param s Matrix
   */
  public void setShift(Matrix s){
    shiftVal = s;
  }
  
  
  /**
   * getter method
   * @return Matrix
   */ 
  public Matrix getInverse(){
    return keyInverse;
  }
  
  /**
   * setter method 
   * @param inv Matrix
   */
  public void setInverse(Matrix inv){
    keyInverse = inv;
  }
  
  /**
   * encrypt()
   * @param message String
   * @return String
   * Defined abstract method inherited from Cipher.java
   * Encodes messages for Hill Ciphers.
   */   
  public String encrypt(String message){
    message = message.toUpperCase();
    String[] words = message.split(" ");
    String encrypted = "";
    for(int i=0; i<words.length; i++){
      String word = words[i];
      char[] messageLet = word.toCharArray();//allows each charactor to be encrypted in pairs
      int[] charVals = new int[messageLet.length];//used to store letters as integers from 0 (A) to 26 (Z)
      int newIndex = 0;
      for(int j=0; j<messageLet.length; j++){//fills the charVals array
        charVals[j] = messageLet[j] - 'A';
      }
     if(charVals.length % 2 == 0){//length of message is even and letters can be encoded in pairs
       for(int k=0; k<charVals.length-1; k+=2){
         double[] charval = {(double)charVals[k], charVals[k+1]};
         Matrix letters = new Matrix(charval, 2);
         Matrix encrptd = (key.times(letters)).plus(shiftVal);
         newIndex = 'A' + (int)(encrptd.get(0,0) % 26);
         encrypted += (char) newIndex;
         newIndex = 'A' + (int)(encrptd.get(1,0) % 26);
         encrypted += (char) newIndex;
       }
     }else{//length of message is odd and first letter is encoded separately.
       double[] charval = {(double)charVals[0], (double)charVals[1]};
       Matrix letters = new Matrix(charval, 2);
       Matrix encrptd = (key.times(letters)).plus(shiftVal);
       newIndex = 'A' + (int)(encrptd.get(0,0) % 26);
       encrypted += (char) newIndex;
       System.out.println(message + " odd letter " + (char)newIndex); 
       for(int k=1; k<charVals.length-1; k+=2){
         charval[0] = (double)charVals[k];
         charval[1] = charVals[k+1];
         letters = new Matrix(charval, 2);
         encrptd = (key.times(letters)).plus(shiftVal);
         newIndex = 'A' + (int)(encrptd.get(0,0) % 26);
         encrypted += (char) newIndex;
         newIndex = 'A' + (int)(encrptd.get(1,0) % 26);
         encrypted += (char) newIndex;
      }
     } encrypted += " ";  
    }
    
    return encrypted;
    
  }
  
  /**
   * decrypt()
   * @param message String
   * @return String
   * Defined abstract method inherited from Cipher.java
   * Decodes messages for Hill Ciphers.
   */ 
  public String decrypt(String message){
    message = message.toUpperCase();
    String[] words = message.split(" "); 
    String decrypted = "";
    for(int i=0; i<words.length; i++){
      int newIndex = 0;
      String word = words[i];
      char[] messageLet = word.toCharArray();//allows each charactor to be encrypted in pairs
      int[] charVals = new int[messageLet.length];//used to store letters as integers from 0 (A) to 26 (Z)
      for(int j=0; j<messageLet.length; j++){
       charVals[j] = messageLet[j] - 'A';
      }
      if(charVals.length % 2 == 0){
        for(int k=0; k<charVals.length-1; k+=2){
          double[] charval = {(double)charVals[k], (double)charVals[k+1]};
          Matrix letters = new Matrix(charval, 2);
          Matrix decrptd = keyInverse.times(letters.minus(shiftVal));
          newIndex = 'A' + (int)(decrptd.get(0,0) % 26);
          decrypted += (char) newIndex;
          newIndex = 'A' + (int)(decrptd.get(1,0) % 26);
          decrypted += (char) newIndex;
        }
      }else{
        double[] charval = {(double)charVals[0], (double)charVals[1]};
        Matrix letters = new Matrix(charval, 2);
        Matrix decrptd = (keyInverse.times(letters.minus(shiftVal)));
        newIndex = 'A' + (int)(decrptd.get(0,0) % 26);
        decrypted += (char) newIndex;
        System.out.println(message + " odd letter " + (char)newIndex); 
        for(int k=1; k<charVals.length-1; k+=2){
          charval[0] = (double)charVals[k];
          charval[1] = (double) charVals[k+1];
          letters = new Matrix(charval, 2);
          decrptd = (keyInverse.times(letters.minus(shiftVal)));
          newIndex = 'A' + (int)(decrptd.get(0,0) % 26);
          decrypted += (char) newIndex;
          newIndex = 'A' + (int)(decrptd.get(1,0) % 26);
          decrypted += (char) newIndex;
        } 
      }  decrypted += " ";  
    }
    
    return decrypted;
    
  }
  
  public String getType() {
    return "Hill Cipher";
  }
  
  /**
   * main()
   * for testing
   */
  public static void main(String[] args) {
    
    
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
    HillCipher c = new HillCipher(key, shiftVal, keyInv);
    System.out.println(c.decrypt(c.encrypt("HI CALI ANd CLARA")));
    System.out.println(c.decrypt("HE SMRC"));
    System.out.println(c.decrypt("HE"));
    System.out.println(c.decrypt(c.encrypt("EL")));
    //Odd string still don't work...
  }//end main
  
  
  
}
