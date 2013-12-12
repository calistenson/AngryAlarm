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
  
  
  public abstract String encrypt(String message);
  
  public abstract String decrypt(String message);
  
}