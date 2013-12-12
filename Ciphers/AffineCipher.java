/**
 * AffineCipher.java
 * Authors: Cali Stenson and Clara Smith
 * Date: December 5, 2013
 * Course: Wellesley College CS230-Data Structures 
 * Semester: Fall 2013
 * This class is a AffineCipher object used to 
 * encrypt and decrypt Affine Ciphers
 */ 

package ciphers;

public class AffineCipher extends Cipher {
  
  /**
   * Instance variables
   * keyVal, shiftVal, keyInverse int
   * NOTE: the keyVal must be relatively prime to 26.
   */ 
  private int keyVal = 1;
  private int shiftVal = 0;
  private int keyInverse = 1;
  
  /**
   * Default Constructor
   */ 
  public AffineCipher() {}
  
  /**
   * Constructor
   * @param k int
   * @param kinv int
   * @param s int
   */ 
  public AffineCipher(int k, int kinv, int s){
    keyVal = k;
    keyInverse = kinv;
    shiftVal = s;
  }
  
  
  /**
   * getter method
   * @return int
   */ 
  public int getKey(){
    return keyVal;
  }
  
  /**
   * setter method 
   * @param k int
   */ 
  public void setKey(int k){
    keyVal = k;
  }
  
  
  /**
   * getter method
   * @return int
   */ 
  public int getShift(){
    return shiftVal;
  }
  /**
   * setter method 
   * @param s int
   */
  public void setShift(int s){
    shiftVal = s;
  }
  
  
  /**
   * getter method
   * @return int
   */ 
  public int getInverse(){
    return keyInverse;
  }
  
  /**
   * setter method 
   * @param inv int 
   */
  public void setInverse(int inv){
    keyInverse = inv;
  }
  
  
  /**
   * encrypt()
   * @param message String
   * @return String
   * Defined abstract method inherited from Cipher.java
   * Encodes messages for Affine Ciphers.
   */   
  public String encrypt(String message){
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
  
  /**
   * decrypt()
   * @param message String
   * @return String
   * Defined abstract method inherited from Cipher.java
   * Decodes messages for Affine Ciphers.
   */
  public String decrypt(String message){
    int newIndex;
    String decrypted = "";
    message = message.toUpperCase();
    char[] messageLet = message.toCharArray();
    for(int i=0; i<message.length(); i++){
      newIndex = 'A' + (keyInverse*((messageLet[i] - 'A') - shiftVal)) % 26;
      newIndex = ((newIndex < 'A') ? 'Z'-('A'-newIndex)+1: newIndex);
      decrypted += (char) newIndex;
    }
    return decrypted;
  }
  
  /**
   * main()
   * for testing
   */ 
  public static void main(String[] args) {
    
    AffineCipher c = new AffineCipher(9, 3, 3);
    
    System.out.println(c.decrypt(c.encrypt("CALI"))); 
    System.out.println(c.decrypt(c.encrypt("SUPERCALIFRAGILISTICEXPIALADOCIOUS")));
    
    //needs more testing
  }//end main
  
  
  
}
