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

public class CodeCrackerAboutPanel extends JPanel {
  
  // instance vars
  
  // preferred sizes
  private final int WIDTH = 850, HEIGHT = 750;
  private JLabel womanImage;
  
  // constructor
  public CodeCrackerAboutPanel () {
    // sets up visuals
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // sets layout to Box Layout
    // whateverlabel.setFont(new Font("Serif", Font.PLAIN, 18)); // sets the font
    this.setBackground(new Color(76, 168, 194)); // sets background color
    this.setPreferredSize(new Dimension(WIDTH, HEIGHT)); // sets the size of the panel
    
    womanImage = new JLabel();
    womanImage.setIcon(new ImageIcon ("woman-final.gif"));
    womanImage.setLayout(new FlowLayout(FlowLayout.LEFT));
    
    this.add(womanImage);
    
  }
  
  
  
}