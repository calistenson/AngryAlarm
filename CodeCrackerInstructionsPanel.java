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
import java.awt.image.BufferedImage; 

public class CodeCrackerInstructionsPanel extends JPanel {
  
  // instance vars
  private JButton caesarButton, vigButton, affineButton, hillButton, otherButton;
  private ImagePanel instructionsPanel;
  private BufferedImage alphabetImage;
  private JLabel alphabetLabel;
  
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
    
    //button for info for caesar cipher
    caesarButton = new JButton("");
    caesarButton.setOpaque(false);
    caesarButton.setContentAreaFilled(false);
    caesarButton.setBorderPainted(false);
    
    //button for info for caesar cipher
    vigButton = new JButton("");
    vigButton.setOpaque(false);
    vigButton.setContentAreaFilled(false);
    vigButton.setBorderPainted(false);
    
    //button for info for caesar cipher
    affineButton = new JButton("");
    affineButton.setOpaque(false);
    affineButton.setContentAreaFilled(false);
    affineButton.setBorderPainted(false);
    
    //button for info for caesar cipher
    hillButton = new JButton("");
    hillButton.setOpaque(false);
    hillButton.setContentAreaFilled(false);
    hillButton.setBorderPainted(false);
    
    CodeCrackerInstructionsPanelListener listener = new CodeCrackerInstructionsPanelListener(); //creates listener
    //adds listener to buttons
    caesarButton.addActionListener(listener); 
    vigButton.addActionListener(listener);
    affineButton.addActionListener(listener);
    hillButton.addActionListener(listener);
    
    // add everything to frame
    
    //initializes 8 instances of other button
    //sets invisible and then adds to frame
    //this is for the purpose of allowed other four
    //buttons to align with image
    //these buttons have no functional purpose
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
  
  
  //Listener for CodeCrackerInstructionsPanel
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
          alphabetImage = ImageIO.read(new File("Images/alphabet.png"));
          alphabetLabel = new JLabel(new ImageIcon(alphabetImage));
          JOptionPane.showMessageDialog(null, content);
          JOptionPane.showMessageDialog(null, alphabetLabel, "Alphabet Key", JOptionPane.PLAIN_MESSAGE, null);
        } catch (IOException e) {
          System.out.println("**ERROR**: " + e);
        }
      }
      
    }
    
    
    
  }
  
}