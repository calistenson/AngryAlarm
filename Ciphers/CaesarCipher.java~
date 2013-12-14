/**
 * CaesarCipher.java
 * Authors: Cali Stenson and Clara Smith
 * Date: December 5, 2013
 * Course: Wellesley College CS230-Data Structures 
 * Semester: Fall 2013
 * This class is a CaesarCipher object used to 
 * encrypt and decrypt Caesar Ciphers
 */ 

package ciphers;

public class CaesarCipher extends Cipher{
  
  /**
   * Instance Variables
   * shiftVal to store the number of places each
   * letter is shifted when encoding and decoding.
   */ 
  private int shiftVal = 0;
  
  /**
   * Default Constructor
   */ 
  public CaesarCipher(){};
  
  /**
   * Constructor
   * @param val int
   * takes a value to use to shift letters
   */ 
  public CaesarCipher(int val){
    shiftVal = val;
  }  
  
  /**
   * getter method
   * @return int
   */ 
  public int getVal(){
    return shiftVal;
  }
  
  /**
   * setter method
   * @param val int
   */ 
  public void setVal(int val){
    shiftVal = val;
  }
  
  /**
   * encrypt()
   * @param message String
   * @return String
   * Defined abstract method inherited from Cipher.java
   * Encodes messages for Caesar Ciphers.
   */   
  public String encrypt(String message){
    int newIndex;
    String encrypted = "";
    message = message.toUpperCase();
    String[] words = message.split(" ");
    for(int i=0; i<words.length; i++){
      String word = words[i];
      char[] messageLet = word.toCharArray();
      for(int j=0; j<message.length(); j++){
        newIndex = messageLet[j] + shiftVal;
        newIndex = ((newIndex > 'Z') ? 'A'+(newIndex - 'Z')-1: newIndex);
        encrypted += (char) newIndex;
      } encrypted += " ";
    }
    return encrypted;
  }
  
  /**
   * decrypt()
   * @param message String
   * @return String
   * Defined abstract method inherited from Cipher.java
   * Decodes messages for Caesar Ciphers.
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
        newIndex = messageLet[j] - shiftVal;
        newIndex = ((newIndex < 'A') ? 'Z'-('A'-newIndex)+1: newIndex);
        decrypted += (char) newIndex;
      } decrypted += " ";
    }
    return decrypted;
  }
  
  public String getType() {
    return "Caesar Cipher";
  }
  
  /**
   * main()
   * for testing
   */ 
  public static void main(String[] args){
    
    CaesarCipher c = new CaesarCipher(3);
    
    System.out.println("Encrypt ABC using Caesar with shift value of 3: " );
    System.out.println(c.encrypt("ABC"));
    System.out.println("Decrypt DEF using Caesar with shift value of 3: " );
    System.out.println(c.decrypt("DEF"));
    System.out.println("Decrypt COIN using Caesar with shift value of 3: ");
    System.out.println(c.decrypt(c.encrypt("COIN")));
    c.setVal(26);
    System.out.println("Encrypt CALI using Caesar with shift value of 26: ");
    System.out.println(c.encrypt("CALI"));
    System.out.println("Decrypt CALI using Caesar with shift value of 26: ");
    System.out.println(c.decrypt("CALI Stenson"));
    
  }//end main  
}
