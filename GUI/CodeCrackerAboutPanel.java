/**
 * FILE: CodeCrackerAboutPanel.java
 * AUTHORS: Clara Smith and Cali Stenson
 * DATE: Dec 3 2013
 * MODIFIED: Dec 3 2013
 * 
 * CodeCrackerAboutPanel provides information about the authors and creation of the game.
 */

// import declarations
import java.util.*;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.image.BufferedImage; 
import java.io.*;
import java.io.File;
import java.io.IOException;
import javax.swing.filechooser.FileFilter;
import javax.imageio.ImageIO;


public class CodeCrackerAboutPanel extends JPanel {
  
  // instance vars
  private ImagePanel aboutPanel;
  private JLabel sigsLabel;
  private BufferedImage sigsImage;
  
  // preferred sizes
  private final int WIDTH = 950, HEIGHT = 750;
  
  // constructor
  public CodeCrackerAboutPanel () {
    // sets up visuals
    //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // sets layout to Box Layout
    setLayout(new BorderLayout());
    // whateverlabel.setFont(new Font("Serif", Font.PLAIN, 18)); // sets the font
    this.setBackground(new Color(76, 168, 194)); // sets background color
    this.setPreferredSize(new Dimension(WIDTH, HEIGHT)); // sets the size of the panel
    aboutPanel = new ImagePanel(new ImageIcon("Images/About.png").getImage());
    try {
      sigsImage = ImageIO.read(new File("Images/sigs.png"));
      sigsLabel = new JLabel(new ImageIcon(sigsImage));
      aboutPanel.add(sigsLabel);
      System.out.println("*SIGS ADDED YALL*");
    } catch (IOException e) {
      System.out.println("***ALERT***  Could not read or display image! Error: " + e);
    }
    
    this.add(aboutPanel, BorderLayout.LINE_START);
    
    
    
  }
  
  
  
}