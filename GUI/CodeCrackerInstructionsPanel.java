/**
 * FILE: CodeCrackerInstructionsPanel.java
 * AUTHORS: Clara Smith and Cali Stenson
 * DATE: Dec 3 2013
 * MODIFIED: Dec 3 2013
 * 
 * CodeCrackerInstructionsPanel provides instructions on how to play the game.
 */

// import declarations
import java.util.*;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;
import javax.swing.*;

public class CodeCrackerInstructionsPanel extends JPanel {
  
  // instance vars
  private JButton caesarButton, vigButton, affineButton, hillButton;
  private JTextArea instructionsText;
  
  // preferred sizes
  private final int WIDTH = 950, HEIGHT = 750;
  
  // constructor
  public CodeCrackerInstructionsPanel () {
    // sets up visuals
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // sets layout to Box Layout
    this.setBackground(new Color(76, 168, 194)); // sets background color
    this.setPreferredSize(new Dimension(WIDTH, HEIGHT)); // sets the size of the panel
    
    // create and stylize new componenets
    instructionsText = new JTextArea("This is where the instructions will be." +
                                     "\nHere, we will place lots of text with instructions." +
                                     "\nMaybe we could make buttons that make pop-up message boxes " +
                                     "appear with instructions if it's too much to all fit here?");
    instructionsText.setFont(new Font("Sans Serif", Font.PLAIN, 18)); // sets the font
    instructionsText.setLineWrap(true);
    instructionsText.setWrapStyleWord(true);
    
    caesarButton = new JButton("Caesar Cipher");
    caesarButton.setFont(new Font("Sans Serif", Font.PLAIN, 12));
    caesarButton.setPreferredSize(new Dimension(200, 100));
    
    vigButton = new JButton("Vigenere Cipher");
    vigButton.setFont(new Font("Sans Serif", Font.PLAIN, 12));
    vigButton.setPreferredSize(new Dimension(200, 100));
    
    affineButton = new JButton("Affine Cipher");
    affineButton.setFont(new Font("Sans Serif", Font.PLAIN, 12));
    affineButton.setPreferredSize(new Dimension(200, 100));
    
    hillButton = new JButton("Hill Cipher");
    hillButton.setFont(new Font("Sans Serif", Font.PLAIN, 12));
    hillButton.setPreferredSize(new Dimension(200, 100));
    
    CodeCrackerInstructionsPanelListener listener = new CodeCrackerInstructionsPanelListener();
    caesarButton.addActionListener(listener);
    vigButton.addActionListener(listener);
    affineButton.addActionListener(listener);
    hillButton.addActionListener(listener);
    
    // add everything to frame
    this.add(instructionsText);
    this.add(caesarButton);
    this.add(vigButton);
    this.add(affineButton);
    this.add(hillButton);
    
  }
  
  private class CodeCrackerInstructionsPanelListener implements ActionListener {
    
    public void actionPerformed(ActionEvent event) {
      if (event.getSource() == caesarButton) {
        JOptionPane.showMessageDialog(null, "Here is where instructions for the Caesar Cipher could be placed.");
      } else if (event.getSource() == vigButton) {
        JOptionPane.showMessageDialog(null, "Here is where instructions for the Vigenere Cipher could be placed.");
      } else if (event.getSource() == affineButton) {
        JOptionPane.showMessageDialog(null, "Here is where instructions for the Affine Cipher could be placed.");
      } else if (event.getSource() == hillButton) {
        JOptionPane.showMessageDialog(null, "Here is where instructions for the Hill Cipher could be placed.");
      }
      
    }
    
    
    
  }
  
}