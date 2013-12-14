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
  private ImagePanel instructionsPanel;
  
  // preferred sizes
  private final int WIDTH = 950, HEIGHT = 750;

  
  // constructor
  public CodeCrackerInstructionsPanel () {
    // sets up visuals
    setLayout(new BorderLayout());
    this.setBackground(Color.BLACK); // sets background color
    this.setPreferredSize(new Dimension(WIDTH, HEIGHT)); // sets the size of the panel
    instructionsPanel = new ImagePanel(new ImageIcon("Images/Instructions.png").getImage());
    instructionsPanel.setLayout(new GridLayout(2, 2));
    instructionsPanel.setOpaque(false);
    
    // create and stylize new componenets
   
    
    caesarButton = new JButton("");
    caesarButton.setOpaque(false);
    caesarButton.setContentAreaFilled(false);
    caesarButton.setBorderPainted(false);

    vigButton = new JButton("");
    vigButton.setOpaque(false);
    vigButton.setContentAreaFilled(false);
    vigButton.setBorderPainted(false);
    
    affineButton = new JButton("");
    affineButton.setOpaque(false);
    affineButton.setContentAreaFilled(false);
    affineButton.setBorderPainted(false);
    
    hillButton = new JButton("");
    hillButton.setOpaque(false);
    hillButton.setContentAreaFilled(false);
    hillButton.setBorderPainted(false);
    
    CodeCrackerInstructionsPanelListener listener = new CodeCrackerInstructionsPanelListener();
    caesarButton.addActionListener(listener);
    vigButton.addActionListener(listener);
    affineButton.addActionListener(listener);
    hillButton.addActionListener(listener);
    
    // add everything to frame
    instructionsPanel.add(caesarButton);
    instructionsPanel.add(vigButton);
    instructionsPanel.add(hillButton);
    instructionsPanel.add(affineButton);
    this.add(instructionsPanel, BorderLayout.LINE_START);
    
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