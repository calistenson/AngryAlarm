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

public class CodeCrackerGamePanel extends JPanel {
  
  // instance vars
  private JPanel leftPanel, rightPanel;
  private JLabel topLabel;
  
  // preferred sizes
  private final int WIDTH = 850, HEIGHT = 750;
  
  // constructor
  public CodeCrackerGamePanel () { //(CodeCracker c) {

    // sets up visuals
    setLayout(new BorderLayout()); // sets layout to Border Layout
    
    this.setBackground(new Color(76, 168, 194)); // sets background color
    this.setPreferredSize(new Dimension(WIDTH, HEIGHT)); // sets the size of the panel
    
    topLabel = new JLabel("Welcome to Wendy Wellesley: Code Cracker!");
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
    
    // add components to pane
    this.add(topLabel, BorderLayout.PAGE_START);
    this.add(leftPanel, BorderLayout.LINE_START);
    this.add(rightPanel, BorderLayout.CENTER);
              
  }
  

  
}
