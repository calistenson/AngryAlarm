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
import java.io.File;
import java.io.IOException;
import javax.swing.filechooser.FileFilter;
import javax.imageio.ImageIO;

public class CodeCrackerInstructionsPanel extends JPanel {
  
  // instance vars
  private JButton caesarButton, vigButton, affineButton, hillButton, otherButton;
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
    instructionsPanel.setLayout(new GridLayout(3, 4));
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
    
    for (int x = 0; x < 8; x ++) {
      otherButton = new JButton("");
      otherButton.setOpaque(false);
      otherButton.setContentAreaFilled(false);
      otherButton.setBorderPainted(false);
      instructionsPanel.add(otherButton);
    }
    instructionsPanel.add(caesarButton);
    instructionsPanel.add(vigButton);
    instructionsPanel.add(affineButton);
    instructionsPanel.add(hillButton);
    this.add(instructionsPanel, BorderLayout.LINE_START);
    
  }
  
  private class CodeCrackerInstructionsPanelListener implements ActionListener {
    
    public void actionPerformed(ActionEvent event) {
      if (event.getSource() == caesarButton || event.getSource() == vigButton 
            ||  event.getSource() == affineButton ||  event.getSource() == hillButton) {
        File instructions;
        if (event.getSource() == caesarButton) {
          instructions = new File("Content/Caesar.txt");
        } else if (event.getSource() == vigButton) {
          instructions = new File("Content/Vigenere.txt");
        } else if (event.getSource() == affineButton) {
          instructions = new File("Content/Affine.txt");
        } else { // if (event.getSource() == hillButton)
          instructions = new File("Content/Hill.txt");
        }
        try {
          String content = new Scanner(instructions).useDelimiter("\\A").next();
          JOptionPane.showMessageDialog(null, content);
        } catch (IOException e) {
          System.out.println("**ERROR**: " + e);
        }
      }
      
    }
    
    
    
  }
  
}