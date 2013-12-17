/**
 * Cipher.java
 * Authors: Cali Stenson and Clara Smith
 * Course: Wellesley College CS230-Data Structures 
 * Date: December 5, 2013
 * Semester: Fall 2013
 * This interface outline a cipher object form
 * for the cipher types in the package
 * (ie CaesarCipher, VigenereCipher, etc.)
 * Class helps to unify the construction of
 * the Level class for the CodeCracker game.
 */ 

//bug with the packaging so level isn't compiling.
package ciphers;

public abstract class Cipher{
<<<<<<< HEAD:ciphers/Cipher.java
=======
  
>>>>>>> 39339f7512ab93405a331bc89f33cfc41013acfc:Ciphers/Cipher.java~
  
  /**
   * abstract encrypt()
   * @param message String
   * @return String
   */ 
  public abstract String encrypt(String message);
  
  /**
   * abstract decrypt()
   * @param message String
   * @return String
   */ 
  public abstract String decrypt(String message);

  /**
   * abstract getType()
   * @return String  
   * returns string value of type of cipher.
   */
  public abstract String getType();
  
  public abstract String getType();
  
}