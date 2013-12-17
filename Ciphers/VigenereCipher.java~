/**
 * VigenereCipher.java
 * Authors: Cali Stenson and Clara Smith
 * Date: December 5, 2013
 * Course: Wellesley College CS230-Data Structures 
 * Semester: Fall 2013
 * This class is a VigenereCipher object used to 
 * encrypt and decrypt Vigenere Ciphers
 */ 

package ciphers;

public class VigenereCipher extends Cipher{
  
  /**
   * Instance variables
   * keyword String 
   * used for encrypting and decrypting
   * default set to "CAT"
   */ 
  private String keyword = "CAT"; //default
  
  /**
   * Default Constructor
   */ 
  public VigenereCipher(){}
  
  
  /**
   * Constructor
   * @param key String
   * Allows user to choose keyword 
   * when they create the VigenereCipher object.
   */ 
  public VigenereCipher(String key){
    keyword = key.toUpperCase();
  }
  
  /**
   * getter method
   * @return String
   * allows user to access the VigenereCipher's 
   * keyword
   */ 
  public String getKey(){
    return keyword;
  }
  
  /**
   * setter method
   * @param key
   * allows user to set the VigenereCipher's keyword.
   */ 
  public void setKey(String key){
    keyword = key;
  }
  
  /**
   * encrypt()
   * @param message String
   * @return String
   * Defined abstract method inherited from Cipher.java
   * Encodes messages for Vigenere Ciphers.
   */ 
  public String encrypt(String message){
    int newIndex;
    int p = 0; //index of the password added to message char
    int shiftVal = 0; //shift for the message char
    String encrypted = "";
    message = message.toUpperCase();
    String[] words = message.split(" ");
    for(int i=0; i<words.length; i++){
      String word = words[i];
      char[] messageLet = word.toCharArray();
      for(int j=0; j<messageLet.length; j++){
        shiftVal = (int) keyword.charAt(p) - 'A';
        newIndex = messageLet[j] + shiftVal;
        newIndex = ((newIndex > 'Z') ? 'A'+(newIndex - 'Z')-1: newIndex);
        encrypted += (char) newIndex;
        p = (p+1) % keyword.length();
      } encrypted += " ";
    }
    return encrypted;
  }
  
  /**
   * decrypt()
   * @param message String
   * @return String
   * Defined abstract method inherited from Cipher.java
   * Decodes messages for Vigenere Ciphers.
   */ 
  public String decrypt(String message){
    int newIndex;
    int p = 0; //index of the password added to message char
    int shiftVal = 0; //shift for the message char
    String decrypted = "";
    message = message.toUpperCase();
    String[] words = message.split(" ");
    for(int i=0; i<words.length; i++){
      String word = words[i];
      char[] messageLet = word.toCharArray();
      for(int j=0; j<messageLet.length; j++){
        shiftVal = (int) keyword.charAt(p) - 'A';
        newIndex = messageLet[j] - shiftVal;
        newIndex = ((newIndex < 'A') ? 'Z'-('A'-newIndex)+1: newIndex);
        decrypted += (char) newIndex;
        p = (p+1) % keyword.length();
      } decrypted += " ";
    }
    return decrypted;
  }
  
  public String getType() {
    return "Vigenere Cipher";
  }
  
  /**
   * main()
   * tests the class methods.
   */ 
  public static void main(String[] args){
    VigenereCipher deflt = new VigenereCipher(); //tests the default construtor of class
    System.out.println("Encoded then decode CALI: " + deflt.encrypt(deflt.decrypt("CALI")));
    
    VigenereCipher otherConstruct = new VigenereCipher("LEMON");//tests the other constructor of the class
    System.out.println("Encrypt ATTACK AT DAWN using Vigenere with LEMON as a keyword (should result in LXFOPV EF RNHR):");
    System.out.println(otherConstruct.encrypt("ATTACK AT DAWN"));
    System.out.println("Decrypt LXFOPVEFRNHR using Vigenere with LEMON as a keyword (should result in ATTACKATDAWN):"); 
    System.out.println(otherConstruct.decrypt("LXFOPV EF RNHR"));
    
  }//end main
  
}  