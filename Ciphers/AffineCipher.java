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
    String[] words = message.split(" ");
    for(int i=0; i<words.length; i++){
      String word = words[i];
      char[] messageLet = word.toCharArray();
      for(int j=0; j<messageLet.length; j++){
        newIndex = 'A' + ( (keyVal * (messageLet[j]-'A') + shiftVal) % 26);
        newIndex = ((newIndex > 'Z') ? 'A'+(newIndex - 'Z')-1: newIndex);
        encrypted += (char) newIndex;
      }
      encrypted += " ";
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
    String[] words = message.split(" ");
    for(int i=0; i<words.length; i++){
      String word = words[i];
      char[] messageLet = word.toCharArray();
      for(int j=0; j<messageLet.length; j++){
        newIndex = 'A' + (keyInverse*((messageLet[j] - 'A') - shiftVal)) % 26;
        newIndex = ((newIndex < 'A') ? 'Z'-('A'-newIndex)+1: newIndex);
        decrypted += (char) newIndex;
      } decrypted += " "; 
    }
    return decrypted;
  }
  
  /**
   * getType()
   * @return String  
   * returns string value of type of cipher.
   */
  public String getType() {
    return "Affine Cipher";
  }
  
  /**
   * main()
   * for testing
   */ 
  public static void main(String[] args) {
    
    AffineCipher c = new AffineCipher(9, 3, 3);
    
    System.out.println(c.decrypt(c.encrypt("CALI Stenson"))); 
    System.out.println(c.decrypt(c.encrypt("SUPERCALIFRAGILISTICEXPIALADOCIOUS")));
    System.out.println(c.encrypt("The pirates attacked our ship we need reinforcements"));
    
    AffineCipher test = new AffineCipher(11, 19, 18);
    System.out.println(test.decrypt("IEXXKFZKX"));
    
    //needs more testing
  }//end main
  
  
  
}
