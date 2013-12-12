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
  private JPanel leftPanel, rightPanel, bottom;
  private JLabel topLabel;
  private JLabel womanImage;
  private JButton level1, level2a, level2b, level3a, level3b, level3c, level3d, level4;
  
  // preferred sizes
  private final int WIDTH = 850, HEIGHT = 750;
  
  // constructor
  public CodeCrackerGamePanel () { //(CodeCracker c) {
    
    // sets up visuals
    setLayout(new BorderLayout()); // sets layout to Border Layout
    
    this.setBackground(new Color(76, 168, 194)); // sets background color
    this.setPreferredSize(new Dimension(WIDTH, HEIGHT)); // sets the size of the panel
    
    topLabel = new JLabel("<html><center>Welcome to Wendy Wellesley: Code Cracker!</center></html>");
    topLabel.setFont(new Font("Sans Serif", Font.PLAIN, 24));
    topLabel.setPreferredSize(new Dimension(850, 50));
    
    // nests Box Layout within panes of Flow Layout
    leftPanel = new JPanel();
    leftPanel.setPreferredSize(new Dimension(423, 700));
    leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
    leftPanel.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 4));
    leftPanel.setBackground(new Color(76, 168, 194));
    
    rightPanel = new JPanel();
    rightPanel.setPreferredSize(new Dimension(423, 700));
    rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
    rightPanel.setBorder(BorderFactory.createLineBorder(new Color(186, 186, 186), 4));
    rightPanel.setBackground(new Color(76, 168, 194));
    
    bottom = new JPanel();
    bottom.setLayout(new BoxLayout(bottom, BoxLayout.Y_AXIS));
    bottom.setBorder(BorderFactory.createLineBorder(new Color(186, 186, 186), 4));
    
    // creates buttons for left pane
    level1 = new JButton("Level 1");
    level2a = new JButton("Level 2 A");
    level2b = new JButton("Level 2 B");
    level3a = new JButton("Level 3 A");
    level3b = new JButton("Level 3 B");
    level3c = new JButton("Level 3 C");
    level3d = new JButton("Level 3 D");
    level4 = new JButton("Level 4");
    
    womanImage = new JLabel();
    womanImage.setIcon(new ImageIcon ("woman-final.png"));
    woman.setPreferredSize();
    //womanImage.setLayout(new FlowLayout(FlowLayout.LEFT));
    
    //bottom = new JPanel();
    //bottom.add(topLabel, BorderLayout.PAGE_END);
    //bottom.add(womanImage, BorderLayout.PAGE_END);
    
    
    CodeCrackerGamePanelListener listener = new CodeCrackerGamePanelListener();
    level1.addActionListener(listener);
    level2a.addActionListener(listener);
    level2b.addActionListener(listener);
    level3a.addActionListener(listener);
    level3b.addActionListener(listener);
    level3c.addActionListener(listener);
    level3d.addActionListener(listener);
    level4.addActionListener(listener);
    
    
    // add components to pane
    leftPanel.add(level1);
    leftPanel.add(level2a, BorderLayout.LINE_START);
    leftPanel.add(level2b, BorderLayout.LINE_START);
    leftPanel.add(level3a, BorderLayout.LINE_START);
    leftPanel.add(level3b, BorderLayout.LINE_START);
    leftPanel.add(level3c, BorderLayout.LINE_START);
    leftPanel.add(level3d, BorderLayout.LINE_START);
    leftPanel.add(level4, BorderLayout.LINE_START);
    
    this.add(topLabel, BorderLayout.PAGE_START);
    this.add(leftPanel, BorderLayout.LINE_START);
    // this.add(rightPanel, BorderLayout.CENTER);
    this.add(bottom, BorderLayout.CENTER);
    //this.add(womanImage, BorderLayout.LINE_END);
    
  }
  
  private class CodeCrackerGamePanelListener implements ActionListener {
    
    public void actionPerformed(ActionEvent event) {
      if (event.getSource() == level1) {
        System.out.println("Okay, begin level 1!");
        //set center panel to level1 info
      } //else if (event.getSource() == ) {
      //whatever
      // } else if (event.getSource() == ) {
      //whatever
      // } else if (event.getSource() == ) {
      //whatever
      //  }
      
      
      //checks message to make sure it's correct
      //returns true if so, false if not
      /*
       public boolean checkMessage(String message) {
       return (message == whatever the correct message is);
       }
       */
      
      
      //takes in boolean "correct"
      //if !correct, then pop up box saying "please try again"
      //if correct, then changes all things in right panel to
      //the next level
      /*
       public void nextLevel(boolean correct) {
       if (!correct) {
       JOptionPane.showMessageDialog(null, "Your password was incorrect. Please try again.");
       }
       else {
       }
       }
       */ 
      
      
    }
    
    
    
    
  }
  
  
  
  
}