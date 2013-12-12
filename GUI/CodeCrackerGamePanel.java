/**
 * FILE: CodeCrackerGamePanel.java
 * AUTHORS: Clara Smith and Cali Stenson
 * DATE: Dec 3 2013
 * MODIFIED: Dec 3 2013
 * 
 * CodeCrackerGamePanel creates the panel from which the user will play the game.
 */

// import declarations
import java.util.*;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.image.BufferedImage; 
import java.io.*;
import java.io.IOException;
import javax.swing.filechooser.FileFilter;
import javax.imageio.ImageIO;


public class CodeCrackerGamePanel extends JPanel {
  
  // instance vars 
  // for top
  private JLabel headerLabel;
  // for left panel
  private JPanel leftPanel;
  private JLabel levelsLabel;
  private JButton romeButton, tuscanyButton, veniceButton, quadButton, tupeloButton, hoopButton, tunnelsButton, clappButton;
  // for right panel
  private JPanel rightPanel;
  private JLabel instructLabel, imageLabel, submitLabel;
  private JTextField submitText;
  private JTextArea storyText;
  private JButton submitButton; 
  // preferred sizes
  private final int WIDTH = 850, HEIGHT = 750;
  
  // constructor
  public CodeCrackerGamePanel () { //(CodeCracker c) {
    
    // sets up visuals
    setLayout(new BorderLayout()); // sets layout to Border Layout
    
    this.setBackground(new Color(76, 168, 194)); // sets background color
    this.setPreferredSize(new Dimension(WIDTH, HEIGHT)); // sets the size of the panel
    
    // starts with the top panel
    headerLabel = new JLabel("<html><center>Welcome to Wendy Wellesley: Code Cracker!</center></html>");
    headerLabel.setFont(new Font("Sans Serif", Font.PLAIN, 24));
    headerLabel.setPreferredSize(new Dimension(850, 50));
    
    // creates left panel
    // nests Box Layout within panes of Flow Layout
    leftPanel = new JPanel();
    leftPanel.setPreferredSize(new Dimension(423, 700));
    leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
    leftPanel.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 4));
    leftPanel.setBackground(new Color(76, 168, 194));
    // creates componenets for left panel
    levelsLabel = new JLabel("Levels");
    romeButton = new JButton("Ancient Rome");
    tuscanyButton = new JButton("Tuscany");
    veniceButton = new JButton("Venice");
    quadButton = new JButton("Academic Quad");
    tupeloButton = new JButton("Tupelo Lane");
    hoopButton = new JButton("Cafe Hoop");
    tunnelsButton = new JButton("Wellesley Tunnels");
    clappButton = new JButton("Clapp Library");
    // creates and adds listener to buttons
    CodeCrackerGamePanelListener listener = new CodeCrackerGamePanelListener();
    romeButton.addActionListener(listener);
    tuscanyButton.addActionListener(listener);
    veniceButton.addActionListener(listener);
    quadButton.addActionListener(listener);
    tupeloButton.addActionListener(listener);
    hoopButton.addActionListener(listener);
    tunnelsButton.addActionListener(listener);
    clappButton.addActionListener(listener);
    // adds components to panel
    leftPanel.add(levelsLabel);
    leftPanel.add(romeButton);
    leftPanel.add(tuscanyButton);
    leftPanel.add(veniceButton);
    leftPanel.add(quadButton);
    leftPanel.add(tupeloButton);
    leftPanel.add(hoopButton);
    leftPanel.add(tunnelsButton);
    leftPanel.add(clappButton);
    
    // creates right panel
    // nests Box Layout within panes of Flow Layout    
    rightPanel = new JPanel();
    rightPanel.setPreferredSize(new Dimension(423, 700));
    rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
    rightPanel.setBorder(BorderFactory.createLineBorder(new Color(186, 186, 186), 4));
    rightPanel.setBackground(new Color(76, 168, 194));
    // creates componenets for right panel
    instructLabel = new JLabel("Instructions here");
    storyText = new JTextArea("story here");
    imageLabel = new JLabel("image here");
    submitLabel = new JLabel("Submit the decoded message here when you are done.");
    submitText = new JTextField();
    submitButton = new JButton("Submit");
    // adds listener to button
    submitButton.addActionListener(listener);
    // adds components to panel
    rightPanel.add(instructLabel);
    rightPanel.add(storyText);
    rightPanel.add(imageLabel);
    rightPanel.add(submitLabel);
    rightPanel.add(submitText);
    rightPanel.add(submitButton);
    
    // adds everything to GUI
    this.add(headerLabel, BorderLayout.PAGE_START);
    this.add(leftPanel, BorderLayout.LINE_START);
    this.add(rightPanel, BorderLayout.CENTER);
    
    
  }
  
  private class CodeCrackerGamePanelListener implements ActionListener {
    
    public void actionPerformed(ActionEvent event) {
      if (event.getSource() == romeButton) {
        System.out.println("Okay, begin level 1!");
        //set center panel to level1 info
      } else if (event.getSource() == ) {
        
      } else if (event.getSource() == ) {
        
      } else if (event.getSource() == ) {
        
      }
      
 

    }
    
      // checks message to make sure it's correct
      // returns true if so, false if not
      public boolean checkMessage(String message) {
        return (message == c.);
      }
      
      
      
      // takes in boolean "correct"
      // if !correct, then pop up box saying "please try again"
      // if correct, then changes all things in right panel to
      // the next level
      
      public void nextLevel(Level l) {
        if (!correct) {
          JOptionPane.showMessageDialog(null, "Your password was incorrect. Please try again.");
        }
        else {
        }
      }

  }
  
}